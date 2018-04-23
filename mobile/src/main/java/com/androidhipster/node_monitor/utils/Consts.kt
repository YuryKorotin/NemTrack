package com.androidhipster.node_monitor.utils

/**
 * Created by yurykorotin on 4/23/18.
 */

class Consts {
    companion object {
        val NIS_ROOT= "https://185.159.131.123:7890"

        val EXTENDED_INFO = NIS_ROOT.plus("/extended_info")
        val STATUS= NIS_ROOT.plus("/status")
        val HEART_BEAT = NIS_ROOT.plus("/heartbeat")
    }
}