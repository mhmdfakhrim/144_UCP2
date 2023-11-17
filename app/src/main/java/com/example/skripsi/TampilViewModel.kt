package com.example.skripsi

import androidx.lifecycle.ViewModel
import com.example.skripsi.data.PengajuanUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TampilViewModel : ViewModel(){
    private val _stateUIForm = MutableStateFlow(PengajuanUIState())
    val stateUIForm: StateFlow<PengajuanUIState> = _stateUIForm.asStateFlow()

    fun setBiodata(listData: MutableList<String>){
        _stateUIForm.update{ stateSaatIni ->
            stateSaatIni.copy(
                nama = listData[0],
                nim = listData[1],
                konsentrasi = listData[2],
                judul = listData[3]
            )
        }
    }

    fun setDosen(dosenPilihan: String){
        _stateUIForm.update { stateSaatIni ->
            stateSaatIni.copy(dosen = dosenPilihan)
        }
    }
}