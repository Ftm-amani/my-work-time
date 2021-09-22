package com.example.worktime.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.worktime.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider
import java.util.*

@Database(entities = [Work::class] , version = 1 )
abstract class WorkDatabase : RoomDatabase(){

    abstract fun workDao() : WorkDao

    class Callback  @Inject constructor(
        private val database: Provider<WorkDatabase>,
        @ApplicationScope private val applicationScope : CoroutineScope

        ):RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            //db operations
            val dao = database.get().workDao()

            applicationScope.launch {
                dao.insert(Work("0","0","0","0",15,5))

            }
        }
    }
}