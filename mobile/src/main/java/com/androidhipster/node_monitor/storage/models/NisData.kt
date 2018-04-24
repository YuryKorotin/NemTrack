package com.androidhipster.node_monitor.storage.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * Created by yurykorotin on 4/24/18.
 */

@Entity
data class NisData(@PrimaryKey(autoGenerate = true) val id: Long,
                   var name: String = "",
                   var address: String = "",
                   var status: String = "",
                   var created: Date = Date(),
                   var updated: Date = Date()) {
}