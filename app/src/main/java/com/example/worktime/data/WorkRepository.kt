package com.example.worktime.com.example.worktime.data


import androidx.lifecycle.LiveData
import com.example.worktime.data.Work
import com.example.worktime.data.WorkDao
import javax.inject.Inject


class WorkRepository @Inject constructor(private val workDao: WorkDao) {

        suspend fun insertWork(work: Work) = workDao.insert(work)
//        suspend fun deleteWork(work: Work) = workDao.delete(work)
//        suspend fun updateWork(work: Work) = workDao.update(work)
//        suspend fun deleteAllWorks() = workDao.deleteAllWorks()

        fun getAllToDo() = workDao.getAllWorks()

        //sum operation
//        suspend fun getTotalH(): Int {
//                return workDao.getTotalSumH()
//        }


}