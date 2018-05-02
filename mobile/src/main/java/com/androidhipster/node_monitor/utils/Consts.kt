package com.androidhipster.node_monitor.utils

/**
 * Created by yurykorotin on 4/23/18.
 */

object Consts {
    const val DEFAULT_NIS_ROOT= "https://185.159.131.123:7890"
    const val NODE_LIST = "/node/peer-list/all";

    const val EXTENDED_INFO = DEFAULT_NIS_ROOT.plus("/extended_info")
    const val STATUS= DEFAULT_NIS_ROOT.plus("/status")
    const val HEART_BEAT = DEFAULT_NIS_ROOT.plus("/heartbeat")
}