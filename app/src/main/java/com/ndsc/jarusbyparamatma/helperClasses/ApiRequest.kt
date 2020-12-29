package com.ndsc.jarusbyparamatma.helperClasses

import com.ndsc.jarusbyparamatma.model.Equipment
import retrofit2.Response
import retrofit2.http.POST

interface ApiRequest {

    companion object {
        const val Base_URl = "put your ip address here"
    }

    @POST("put here your method path or page path")
    suspend fun getEquipment(): Response<List<Equipment>>
}