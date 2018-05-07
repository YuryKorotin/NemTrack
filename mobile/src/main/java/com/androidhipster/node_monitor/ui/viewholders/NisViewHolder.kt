package com.androidhipster.node_monitor.ui.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.androidhipster.node_monitor.R
import com.androidhipster.node_monitor.net.models.nis.NisNode
import com.androidhipster.node_monitor.storage.models.NisData

/**
 * Created by yurykorotin on 5/7/18.
 */
class NisViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    lateinit var nisData: NisNode
    val name: TextView

    init {
        name = itemView!!.findViewById(R.id.name)
    }

    open fun bind(nisData: NisNode) {
        this.nisData = nisData

        name.text = nisData.identity.name ?: "NONAME"
    }
}