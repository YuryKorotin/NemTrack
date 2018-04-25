package com.androidhipster.node_monitor.storage.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.androidhipster.node_monitor.storage.models.NisData

/**
 * Created by yurykorotin on 4/24/18.
 */

@Dao
interface NisDAO {
    @Query("select * from nisdata")
    fun getAllNisItems() : LiveData<List<NisData>>

    @Insert
    fun add(item: NisData)

    @Delete
    fun delete(nisData: NisData?)

    @Query("select * from nisdata where name=:name")
    fun find(name: String): LiveData<NisData>

    @Update
    fun update(nisData: NisData?)
}