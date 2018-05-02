package com.androidhipster.node_monitor.net

import com.androidhipster.node_monitor.utils.Consts
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by yurykorotin on 5/2/18.
 */
interface NisService {
    @GET(Consts.NODE_LIST)
    fun nodes() : Call<NodesResponse>
}