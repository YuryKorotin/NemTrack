package com.androidhipster.node_monitor.storage.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.androidhipster.node_monitor.storage.dao.NisDAO
import com.androidhipster.node_monitor.storage.models.NisData

/**
 * Created by yurykorotin on 4/24/18.
 */

@Database(entities = arrayOf(NisData::class), version = 2)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun nisDao() : NisDAO
}