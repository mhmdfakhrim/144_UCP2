package com.example.skripsi

import androidx.lifecycle.ViewModel
import com.example.skripsi.data.PengajuanUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TampilViewModel : ViewModel(){
    private val _stateUI = MutableStateFlow(PengajuanUIState())
    val stateUI: StateFlow<PengajuanUIState> = _stateUI.asStateFlow()


    fun setBiodata(listData: MutableList<String>){
        _stateUI.update{ stateSaatIni ->
            stateSaatIni.copy(
                nama = listData[0],
                nim = listData[1],
                konsentrasi = listData[2],
                judul = listData[3]
            )
        }
    }

    fun setDosen(dosenPilihan: String){
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(dosen = dosenPilihan)
        }
    }

    fun resetForm(){
        _stateUI.value = PengajuanUIState()
    }
}