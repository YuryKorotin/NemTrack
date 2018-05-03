package com.androidhipster.node_monitor.ui

import android.support.transition.TransitionManager
import android.support.v4.app.Fragment
import android.view.ViewGroup
import com.androidhipster.node_monitor.NemTrackApplication
import com.androidhipster.node_monitor.net.models.nis.NisNode
import com.androidhipster.node_monitor.view.nis_list.NisListPresenter
import com.androidhipster.node_monitor.view.nis_list.NisListView
import com.androidhipster.node_monitor.view.nis_list.NisListViewState
import com.hannesdorfmann.mosby3.mvi.MviFragment
import io.reactivex.Observable
import io.reactivex.Single
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinContext
import org.kodein.di.generic.kcontext
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import java.util.*

/**
 * Created by yurykorotin on 4/25/18.
 */
class NisListFragment : MviFragment<NisListView, NisListPresenter>(),
        NisListView,
        KodeinAware {
    companion object {
        val NODE_NAME = "node_name"
    }

    override val kodeinContext: KodeinContext<*> get() = kcontext(activity)

    override val kodein by closestKodein()


    override fun createPresenter(): NisListPresenter {
        return kodein.instance<NisListPresenter>() as NisListPresenter
    }

    override fun loadIntents(): Observable<String> {
        return Observable.just(arguments!!.getString(NODE_NAME));
    }

    override fun render(nisListViewState: NisListViewState) {
        if (nisListViewState is NisListViewState.LoadingState) {
            renderLoading()
        } else if(nisListViewState is NisListViewState.DataState) {
            renderData((nisListViewState as NisListViewState.DataState).nodes)
        }
    }

    private fun renderError() {
        TransitionManager.beginDelayedTransition(view as ViewGroup)
        //loadingView.setVisibility(View.GONE)
        //errorView.setVisibility(View.VISIBLE)
        //recyclerView.setVisibility(View.GONE)
    }

    private fun renderLoading() {
        TransitionManager.beginDelayedTransition(view as ViewGroup)
        //loadingView.setVisibility(View.VISIBLE)
        //errorView.setVisibility(View.GONE)
        //recyclerView.setVisibility(View.GONE)
    }

    private fun renderData(products: Array<NisNode>) {
        //adapter.setProducts(products)
        //adapter.notifyDataSetChanged()
        TransitionManager.beginDelayedTransition(view as ViewGroup)
        //loadingView.setVisibility(View.GONE)
        //errorView.setVisibility(View.GONE)
        //recyclerView.setVisibility(View.VISIBLE)
    }

}