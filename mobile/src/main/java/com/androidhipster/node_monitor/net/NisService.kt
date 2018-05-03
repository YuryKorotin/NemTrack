package com.androidhipster.node_monitor.net

import com.androidhipster.node_monitor.net.models.NodesResponse
import com.androidhipster.node_monitor.utils.Consts
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by yurykorotin on 5/2/18.
 */
interface NisService {
    @GET(Consts.NODE_LIST)
    fun nodes() : Observable<NodesResponse>
}