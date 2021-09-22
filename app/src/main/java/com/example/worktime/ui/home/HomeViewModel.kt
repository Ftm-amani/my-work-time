package com.example.worktime.com.example.worktime.ui.home

import androidx.lifecycle.*
import com.example.worktime.com.example.worktime.data.WorkRepository
import com.example.worktime.data.Work
import com.example.worktime.data.WorkDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val workRepository: WorkRepository  ,
) : ViewModel() {

    fun insertW(work: Work) = viewModelScope.launch {
        workRepository.insertWork(work)
    }
}





















//    private val workLiveData = MutableLiveData<Work>()
//
//    init {
//        viewModelScope.launch{
//            val works = workDao.getAllWorks()
//            workLiveData.value = works
//
//        }
//
//    }



//    var time = Work(1,1,1,1,1,1)
//
//    private val _works = MutableLiveData<Work>()
//    val works: LiveData<Work>
//        get() = _works
//
//    private val _startTimeH = MutableLiveData<Int>(0)
//    val startTimeH: LiveData<Int>
//        get() = _startTimeH
//
//    private val _startTimeM = MutableLiveData<Int>(0)
//    val startTimeM: LiveData<Int>
//        get() = _startTimeM
//
//    private val _endTimeH = MutableLiveData<Int>(0)
//    val endTimeH: LiveData<Int>
//        get() = _endTimeH
//
//    private val _endTimeM = MutableLiveData<Int>(0)
//    val endTimeM: LiveData<Int>
//        get() = _endTimeM
//
//    private val _totalTimeH = MutableLiveData<Int>(0)
//    val totalTimeH: LiveData<Int>
//        get() = _totalTimeH
//
//    private val _totalTimeM = MutableLiveData<Int>(0)
//    val totalTimeM: LiveData<Int>
//        get() = _totalTimeM


    //-------------------------------------------------



//    fun onSaveClick() {
//        val newWork = Work(
//            startTimeH.value,
//            startTimeM.value,
//            endTimeH.value,
//            endTimeM.value,
//            totalTimeH.value,
//            totalTimeM.value
//        )
//        createWork(newWork)
//    }
//
//    private fun createWork(work: Work) = viewModelScope.launch {
//        workDao.insert(work)
//    }


//}