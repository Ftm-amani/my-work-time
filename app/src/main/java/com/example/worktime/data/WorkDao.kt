package com.example.worktime.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WorkDao {

    @Query("SELECT * from work_table")
    fun getAllWorks(): LiveData<List<Work?>?>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(work: Work)

    @Delete
    suspend fun delete(work: Work)

    @Query("DELETE FROM work_table")
    suspend fun deleteAllWorks()

//sum operation
//    @Query("SELECT SUM(totalH) FROM work_table")
//    suspend fun getTotalSumH(): Int


}