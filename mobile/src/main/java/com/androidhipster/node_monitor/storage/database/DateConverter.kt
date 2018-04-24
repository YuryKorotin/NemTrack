package com.androidhipster.node_monitor.storage.database

import android.arch.persistence.room.TypeConverter
import java.util.*

/**
 * Created by yurykorotin on 4/24/18.
 */
class DateConverter {
    @TypeConverter
    fun toDate(timestamp: Long?) : Date? {
        return Date(timestamp!!)
    }

    @TypeConverter
    fun toTimestamp(date: Date?): Long?  {
        return date?.time
    }
}