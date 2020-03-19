package com.learning.crm.activities.dataclasses.contacts


import com.google.gson.annotations.SerializedName
import com.learning.crm.dataclasses.contacts.Data

data class CrmContacts(
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("info")
    val info: Info
)