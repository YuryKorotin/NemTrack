package com.androidhipster.node_monitor.net.models

import com.androidhipster.node_monitor.net.models.nis.NisNode

/**
 * Created by yurykorotin on 5/2/18.
 */
class NodesResponse (
    val active: Array<NisNode>,
    val inactive: Array<NisNode>,
    val busy: Array<NisNode>,
    val failure: Array<NisNode>
)