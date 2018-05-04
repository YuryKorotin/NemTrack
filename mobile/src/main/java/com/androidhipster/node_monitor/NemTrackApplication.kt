package com.androidhipster.node_monitor

import android.app.Application
import android.arch.persistence.room.Room
import com.androidhipster.node_monitor.net.NisService
import com.androidhipster.node_monitor.net.NisServiceDecorator
import com.androidhipster.node_monitor.storage.database.AppDatabase
import com.androidhipster.node_monitor.utils.Consts
import com.androidhipster.node_monitor.view.nis_list.NisListPresenter
import retrofit2.converter.moshi.MoshiConverterFactory
import okhttp3.OkHttpClient
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.*
import retrofit2.Retrofit



/**
 * Created by yurykorotin on 4/25/18.
 */
class NemTrackApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein {
        /*bind<AppDatabase>() with eagerSingleton {
            Room.databaseBuilder(
                    this@NemTrackApplication,
                    AppDatabase::class.java,
                    "nem_db")
                    .allowMainThreadQueries()
                    .build()
        }*/

        bind<Retrofit>() with provider {
             Retrofit.Builder().baseUrl(Consts.DEFAULT_NIS_ROOT)
                    //.client(OkHttpClient.Builder().addInterceptor(httpLogger).build())
                    //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
        }

        bind<NisServiceDecorator>() with provider {
            val retrofit: Retrofit = instance()
            NisServiceDecorator(retrofit.create(NisService::class.java))
        }

        bind<NisListPresenter>() with singleton {
            NisListPresenter(instance())
        }
    }
}