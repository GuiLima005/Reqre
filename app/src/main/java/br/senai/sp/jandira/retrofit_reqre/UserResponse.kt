package br.senai.sp.jandira.retrofit_reqre

import com.google.gson.annotations.SerializedName

data class UserResponse(

    @SerializedName("id") var id: Int? = 0,
    @SerializedName("email") var email: String? = "",
    @SerializedName("fist_name") var fist_name: String? = "",
    @SerializedName ("last_name") var last_name: String? = "",
    @SerializedName ("avatar") var avatar: String? = "",

)
