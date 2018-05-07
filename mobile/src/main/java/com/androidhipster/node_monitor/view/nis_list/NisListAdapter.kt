package com.androidhipster.node_monitor.view.nis_list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.androidhipster.node_monitor.R
import com.androidhipster.node_monitor.net.models.nis.NisNode
import com.androidhipster.node_monitor.storage.models.NisData
import com.androidhipster.node_monitor.ui.viewholders.NisViewHolder

/**
 * Created by yurykorotin on 5/7/18.
 */
class NisListAdapter(val inflater: LayoutInflater) : RecyclerView.Adapter<NisViewHolder>() {
    lateinit var nisItems: Array<NisNode>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NisViewHolder {
        val view = inflater.inflate(R.layout.nis_list_item, parent, false)

        return NisViewHolder(view)
    }

    override fun getItemCount(): Int {
        return nisItems?.size
    }

    override fun onBindViewHolder(holder: NisViewHolder, position: Int) {
        holder.bind(nisItems.get(position))
    }

}