package com.androidhipster.node_monitor.view.nis_list

import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.Observable
import io.reactivex.Single
import java.util.*

/**
 * Created by yurykorotin on 5/3/18.
 */
interface NisListView : MvpView {

    fun loadIntents() : Observable<String>

    fun render(nisListViewState: NisListViewState)
}