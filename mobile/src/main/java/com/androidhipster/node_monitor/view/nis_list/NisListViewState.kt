package com.androidhipster.node_monitor.view.nis_list

import com.androidhipster.node_monitor.net.models.nis.NisNode
import com.androidhipster.node_monitor.storage.models.NisData
import com.androidhipster.node_monitor.ui.models.NisViewModel

/**
 * Created by yurykorotin on 5/3/18.
 */
interface NisListViewState {
    class LoadingState : NisListViewState {
        override fun toString(): String {
            return "LoadingState{}"
        }
    }

    class ErrorState(val error : Throwable) : NisListViewState {
        override fun toString(): String {
            return "ErrorState{" +
                    "error=" + error +
                    '}';
        }
    }

    class DataState(val nodes : Array<NisNode>) : NisListViewState {

        override fun toString(): String {
            return "DataState{"
                    .plus("nodes=")
                    .plus(nodes)
                    .plus("}")
        }
    }

}