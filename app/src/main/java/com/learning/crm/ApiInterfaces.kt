package com.learning.crm

import com.learning.crm.dataclasses.contacts.AddContact
import com.learning.crm.dataclasses.contacts.AddContactWrapper
import com.learning.crm.dataclasses.contacts.AddResponse
import com.learning.crm.dataclasses.contacts.CrmContacts
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.POST

interface ApiInterfaces {

    @GET("v2/Contacts")
    fun getContacts(@HeaderMap header : HashMap<String,String>) : Call<CrmContacts>

    @POST("v2/Contacts")
    fun addContact(@Body contact : AddContactWrapper, @HeaderMap header : HashMap<String,String>) : Call<AddResponse>

}