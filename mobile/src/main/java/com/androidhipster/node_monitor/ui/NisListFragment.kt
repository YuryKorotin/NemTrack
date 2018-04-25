package com.androidhipster.node_monitor.ui

import android.support.v4.app.Fragment
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.SupportFragmentInjector

/**
 * Created by yurykorotin on 4/25/18.
 */
class NisListFragment : Fragment(), SupportFragmentInjector {
    override val injector: KodeinInjector = KodeinInjector()
}