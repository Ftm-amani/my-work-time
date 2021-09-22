package com.example.worktime.com.example.worktime.ui.workstime

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.worktime.com.example.worktime.data.WorkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WokeTimesViewModel @Inject constructor(
    private val workRepository: WorkRepository
    )
    : ViewModel() {

        val works = workRepository.getAllToDo()

    //sum operation
//    fun getTotalH() = viewModelScope.launch {
//        val a = workRepository.getTotalH()
//    }

}