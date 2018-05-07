package com.androidhipster.node_monitor.view.nis_list

import com.androidhipster.node_monitor.net.NisServiceDecorator
import com.androidhipster.node_monitor.storage.models.NisData
import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*




/**
 * Created by yurykorotin on 5/3/18.
 */
class NisListPresenter(val apiService: NisServiceDecorator) :
        MviBasePresenter<NisListView, NisListViewState>() {
    override fun bindIntents() {
        val nisListViewStateObservable = intent(NisListView::loadIntents)
                .flatMap { nodeName ->
                            apiService.getNodes()
                                    .subscribeOn(Schedulers.io())
                                    .map { item ->
                                        NisListViewState.DataState(item.active)
                                    }
                                    .cast(NisListViewState::class.java)
                                    .startWith(NisListViewState.LoadingState())
                                    .onErrorReturn(NisListViewState::ErrorState)
                }
                .observeOn(AndroidSchedulers.mainThread())

        subscribeViewState(nisListViewStateObservable, NisListView::render)
    }
}