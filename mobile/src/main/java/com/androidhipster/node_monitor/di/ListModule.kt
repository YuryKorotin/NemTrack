package com.androidhipster.node_monitor.di

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import com.androidhipster.node_monitor.ui.models.NisViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

/**
 * Created by yurykorotin on 4/25/18.
 */

fun createListModule(fragment: Fragment) = Kodein.Module {
    /*bind<NisViewModel>() with provider {
        val factory = NisViewModel.Fabric(instance())
        ViewModelProviders.of(fragment, factory)[NisViewModel::class.java]
    }*/

    /*bind<SelectedId>() with provider {
        ViewModelProviders.of(instance<FragmentActivity>("Activity"))[SelectedId::class.java]
    }*/
}