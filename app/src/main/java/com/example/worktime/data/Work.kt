package com.example.worktime.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.text.DateFormat

@Entity(tableName = "work_table")
@Parcelize
data class Work(
    @ColumnInfo(name ="startH")
    var sTimeH : String?,
    @ColumnInfo(name ="startM")
    var sTimeM : String?,
    @ColumnInfo(name ="endH")
    var eTimeH : String?,
    @ColumnInfo(name ="endM")
    var eTimeM : String?,
    @ColumnInfo(name ="totalH")
    var tTimeH : Int?,
    @ColumnInfo(name ="totalM")
    var tTimeM : Int?,

    @ColumnInfo(name ="date")
    val dateCreated: Long = System.currentTimeMillis(),
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0


): Parcelable {

    val createdDateFormatted: String
    get() = DateFormat.getDateInstance().format(dateCreated)
}