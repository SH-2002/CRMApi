package com.learning.crm.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.learning.crm.ApiEssentials
import com.learning.crm.R
import com.learning.crm.TableCreatingFunction
import com.learning.crm.dataclasses.contacts.CrmContacts
import com.learning.crm.dataclasses.contacts.Data
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity(), TableCreatingFunction.OnTableClicked {

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        heading.text = "Contacts"
        initApiCall()
    }

    private fun initApiCall(){
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiEssentials.BASE_URL)
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api : FetchContacts = retrofit.create(FetchContacts::class.java)
        val header = HashMap<String,String>()
        header["Content-Type"] = "application/json"
        header["Authorization"] = "Zoho-oauthtoken ${ApiEssentials.oauthToken}"
        val call : Call<CrmContacts> = api.getContacts(header)

        call.enqueue(object : Callback<CrmContacts>{
            override fun onFailure(call: Call<CrmContacts>, t: Throwable) {
                Log.e(TAG,":: onFailure Called!")
            }

            override fun onResponse(call: Call<CrmContacts>, response: Response<CrmContacts>) {
                Log.e(TAG,"onResponse called Response = ${response.body()}")
                runOnUiThread {
                    val data = (response.body() as CrmContacts).data
                    loader.visibility = View.GONE
                    scrollLayout.addView(TableCreatingFunction(this@MainActivity,data).viewReturner())
                }
            }

        })
    }


    interface FetchContacts{
        @GET("v2/Contacts")
        fun getContacts(@HeaderMap header : HashMap<String,String>) : Call<CrmContacts>
    }
    private fun getClient() : OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val builder : OkHttpClient.Builder = OkHttpClient.Builder()
            .connectTimeout(50, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
        builder.addNetworkInterceptor(interceptor)
        return builder.build()
    }

    override fun sendTable(tableData: List<Data>) {

    }

}