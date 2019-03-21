package com.conference.conferencesdk.jobs.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Dinorah Tovar on 3/20/19.
 */
data class JobsResponse(
    @field:SerializedName("id")
    @field:Expose
    val id: String?,
    @field:SerializedName("type")
    @field:Expose
    val type: String?,
    @field:SerializedName("url")
    @field:Expose
    val url: String?,
    @field:SerializedName("created_at")
    @field:Expose
    val created_at: String?,
    @field:SerializedName("company")
    @field:Expose
    val company: String?,
    @field:SerializedName("company_url")
    @field:Expose
    val company_url: String?,
    @field:SerializedName("location")
    @field:Expose
    val location: String?,
    @field:SerializedName("title")
    @field:Expose
    val title: String?,
    @field:SerializedName("description")
    @field:Expose
    val description: String?,
    @field:SerializedName("how_to_apply")
    @field:Expose
    val how_to_apply: String?,
    @field:SerializedName("company_logo")
    @field:Expose
    val company_logo: String?
)

