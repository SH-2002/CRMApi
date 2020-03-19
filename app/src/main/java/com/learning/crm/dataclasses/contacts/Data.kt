package com.learning.crm.dataclasses.contacts


import com.google.gson.annotations.SerializedName
import com.learning.crm.activities.dataclasses.contacts.Approval
import com.learning.crm.activities.dataclasses.contacts.CreatedBy
import com.learning.crm.activities.dataclasses.contacts.ModifiedBy
import com.learning.crm.activities.dataclasses.contacts.Owner

data class Data(
    @SerializedName("Account_Name")
    val accountName: Any,
    @SerializedName("\$approval")
    val approval: Approval,
    @SerializedName("\$approved")
    val approved: Boolean,
    @SerializedName("Assistant")
    val assistant: Any,
    @SerializedName("Asst_Phone")
    val asstPhone: Any,
    @SerializedName("Created_By")
    val createdBy: CreatedBy,
    @SerializedName("Created_Time")
    val createdTime: String,
    @SerializedName("\$currency_symbol")
    val currencySymbol: String,
    @SerializedName("Date_of_Birth")
    val dateOfBirth: String,
    @SerializedName("Department")
    val department: Any,
    @SerializedName("Description")
    val description: Any,
    @SerializedName("\$editable")
    val editable: Boolean,
    @SerializedName("Email")
    val email: String,
    @SerializedName("Email_Opt_Out")
    val emailOptOut: Boolean,
    @SerializedName("Fax")
    val fax: Any,
    @SerializedName("First_Name")
    val firstName: String,
    @SerializedName("Full_Name")
    val fullName: String,
    @SerializedName("Home_Phone")
    val homePhone: Any,
    @SerializedName("id")
    val id: String,
    @SerializedName("Last_Activity_Time")
    val lastActivityTime: Any,
    @SerializedName("Last_Name")
    val lastName: String,
    @SerializedName("Lead_Source")
    val leadSource: Any,
    @SerializedName("Mailing_City")
    val mailingCity: Any,
    @SerializedName("Mailing_Country")
    val mailingCountry: Any,
    @SerializedName("Mailing_State")
    val mailingState: Any,
    @SerializedName("Mailing_Street")
    val mailingStreet: Any,
    @SerializedName("Mailing_Zip")
    val mailingZip: Any,
    @SerializedName("Mobile")
    val mobile: String,
    @SerializedName("Modified_By")
    val modifiedBy: ModifiedBy,
    @SerializedName("Modified_Time")
    val modifiedTime: String,
    @SerializedName("\$orchestration")
    val orchestration: Any,
    @SerializedName("Other_City")
    val otherCity: Any,
    @SerializedName("Other_Country")
    val otherCountry: Any,
    @SerializedName("Other_Phone")
    val otherPhone: Any,
    @SerializedName("Other_State")
    val otherState: Any,
    @SerializedName("Other_Street")
    val otherStreet: Any,
    @SerializedName("Other_Zip")
    val otherZip: Any,
    @SerializedName("Owner")
    val owner: Owner,
    @SerializedName("Phone")
    val phone: Any,
    @SerializedName("\$process_flow")
    val processFlow: Boolean,
    @SerializedName("Record_Image")
    val recordImage: Any,
    @SerializedName("Reporting_To")
    val reportingTo: Any,
    @SerializedName("\$review")
    val review: Any,
    @SerializedName("\$review_process")
    val reviewProcess: Any,
    @SerializedName("Salutation")
    val salutation: Any,
    @SerializedName("Secondary_Email")
    val secondaryEmail: Any,
    @SerializedName("Skype_ID")
    val skypeID: Any,
    @SerializedName("\$state")
    val state: String,
    @SerializedName("Title")
    val title: Any,
    @SerializedName("Twitter")
    val twitter: Any
)