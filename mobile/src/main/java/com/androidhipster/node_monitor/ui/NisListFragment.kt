package com.androidhipster.node_monitor.ui

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.transition.TransitionManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidhipster.node_monitor.R
import com.androidhipster.node_monitor.net.models.nis.NisNode
import com.androidhipster.node_monitor.view.nis_list.NisListPresenter
import com.androidhipster.node_monitor.view.nis_list.NisListView
import com.androidhipster.node_monitor.view.nis_list.NisListViewState
import com.hannesdorfmann.mosby3.mvi.MviFragment
import io.reactivex.Observable
import kotlinx.android.synthetic.main.collection_error_view.*
import kotlinx.android.synthetic.main.collection_progress_view.*
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinContext
import org.kodein.di.generic.kcontext
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import com.androidhipster.node_monitor.view.nis_list.NisListAdapter


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

    val presenter: NisListPresenter by instance()
    lateinit var adapter: NisListAdapter
    lateinit var nislistview: RecyclerView

    override fun createPresenter(): NisListPresenter {
        return presenter
    }

    override fun loadIntents(): Observable<String> {
        val nodeName = arguments?.getString(NODE_NAME)

        return Observable.just(nodeName ?: "");
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(
                R.layout.fragment_nis_list,
                container,
                false)

        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        adapter = NisListAdapter(inflater)
        nislistview = view.findViewById(R.id.nislistview)
        nislistview.setAdapter(adapter)
        nislistview.setLayoutManager(layoutManager)
        //recyclerView.addItemDecoration(GridSpacingItemDecoration(spanCount,
        //        resources.getDimensionPixelSize(R.dimen.grid_spacing), true))
        return view;
    }

    override fun render(nisListViewState: NisListViewState) {
        if (nisListViewState is NisListViewState.LoadingState) {
            renderLoading()
        } else if(nisListViewState is NisListViewState.DataState) {
            renderData((nisListViewState as NisListViewState.DataState).nodes)
        } else if(nisListViewState is NisListViewState.ErrorState)  {
            renderError(nisListViewState.error)
        }
    }

    private fun renderError(error: Throwable) {
        errorView.text = error.message

        TransitionManager.beginDelayedTransition(view as ViewGroup)
        loadingView.setVisibility(View.GONE)
        errorView.setVisibility(View.VISIBLE)
        nislistview.setVisibility(View.GONE)
    }

    private fun renderLoading() {
        TransitionManager.beginDelayedTransition(view as ViewGroup)
        loadingView.setVisibility(View.VISIBLE)
        errorView.setVisibility(View.GONE)
        nislistview.setVisibility(View.GONE)
    }

    private fun renderData(nodes: Array<NisNode>) {
        adapter.nisItems = nodes
        adapter.notifyDataSetChanged()
        TransitionManager.beginDelayedTransition(view as ViewGroup)
        loadingView.setVisibility(View.GONE)
        errorView.setVisibility(View.GONE)
        //recyclerView.setVisibility(View.VISIBLE)
    }
}