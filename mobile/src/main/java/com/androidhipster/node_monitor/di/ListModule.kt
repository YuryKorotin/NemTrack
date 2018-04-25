package com.androidhipster.node_monitor.di

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import com.androidhipster.node_monitor.ui.models.NisViewModel
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider

/**
 * Created by yurykorotin on 4/25/18.
 */

fun createListModule(fragment: Fragment) = Kodein.Module {
    bind<NisViewModel>() with provider {
        val factory = NisViewModel.Fabric(instance())
        ViewModelProviders.of(fragment, factory)[NisViewModel::class.java]
    }

    /*bind<SelectedId>() with provider {
        ViewModelProviders.of(instance<FragmentActivity>("Activity"))[SelectedId::class.java]
    }*/
}