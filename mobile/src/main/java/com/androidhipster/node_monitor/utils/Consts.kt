package com.androidhipster.node_monitor.utils

/**
 * Created by yurykorotin on 4/23/18.
 */

class Consts {
    companion object {
        val DEFAULT_NIS_ROOT= "https://185.159.131.123:7890"
        val NODE_LIST = "/node/peer-list/all";

        val EXTENDED_INFO = DEFAULT_NIS_ROOT.plus("/extended_info")
        val STATUS= DEFAULT_NIS_ROOT.plus("/status")
        val HEART_BEAT = DEFAULT_NIS_ROOT.plus("/heartbeat")
    }
}