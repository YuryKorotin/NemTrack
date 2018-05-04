package com.androidhipster.node_monitor.ui.models

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.androidhipster.node_monitor.storage.database.AppDatabase
import com.androidhipster.node_monitor.storage.models.NisData

/**
 * Created by yurykorotin on 4/24/18.
 */
class NisViewModel(val appDatabase: AppDatabase) : ViewModel() {
    val nisListItems = appDatabase.nisDao().getAllNisItems()

    fun addItem(item: NisData) = appDatabase.nisDao().add(item)
    fun delete(item: NisData?) = appDatabase.nisDao().delete(item)
    fun find(name : String) = appDatabase.nisDao().find(name)
    fun update(item: NisData) = appDatabase.nisDao().update(item)

    /*class Fabric(val appDataBase: AppDatabase) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                NisViewModel(appDataBase) as T
    }*/
}