package com.androidhipster.node_monitor.net

import com.androidhipster.node_monitor.net.models.NodesResponse
import com.androidhipster.node_monitor.storage.models.NisData
import com.androidhipster.node_monitor.ui.models.NisViewModel
import io.reactivex.Observable
import retrofit2.Call
import java.util.*

/**
 * Created by yurykorotin on 5/3/18.
 */

class NisServiceDecorator(val service: NisService) {
    fun getNodes() : Observable<NodesResponse> {
        return service.nodes();
    }
}