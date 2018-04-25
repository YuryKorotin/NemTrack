package com.androidhipster.node_monitor

import android.app.Application
import android.arch.persistence.room.Room
import com.androidhipster.node_monitor.storage.database.AppDatabase
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.bindings.EagerSingletonBinding
import com.github.salomonbrys.kodein.eagerSingleton

/**
 * Created by yurykorotin on 4/25/18.
 */
class NemTrackApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein {
        bind<AppDatabase>() with eagerSingleton {
            Room.databaseBuilder(
                    this@NemTrackApplication,
                    AppDatabase::class.java,
                    "nem_db")
                    .allowMainThreadQueries()
                    .build()
        }
    }
}