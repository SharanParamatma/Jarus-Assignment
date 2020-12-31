package com.ndsc.jarusbyparamatma.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ndsc.jarusbyparamatma.helperClasses.ApiClient
import com.ndsc.jarusbyparamatma.model.Equipment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EquipmentViewModel : ViewModel() {

    private var equipment:List<Equipment>?=null
    private var apiClient = ApiClient()
    private var mutableLiveData: MutableLiveData<List<Equipment>>? = null

    private fun fromServer(){
        viewModelScope.launch(Dispatchers.IO) {
            val response =apiClient.getClient().getEquipment()
            if (response.isSuccessful){
                equipment= response.body()
            }
            mutableLiveData?.postValue(equipment)
        }
    }

    val getData: LiveData<List<Equipment>>
        get() {
            if (mutableLiveData == null) {
                mutableLiveData = MutableLiveData()
                fromServer()
            }
            return mutableLiveData!!
        }
}