package com.androidhipster.node_monitor.ui

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.androidhipster.node_monitor.R
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.android.KodeinFragmentActivity
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : KodeinFragmentActivity() {

    override fun provideOverridingModule(): Kodein.Module = Kodein.Module {
        bind<FragmentActivity>("Activity") with instance(this@WelcomeActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_welcome)
        setActionBar(toolbar)
        fab.setOnClickListener { view ->
                addNewNode(view)
        }
    }

    private fun addNewNode(view: View) {
        /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()*/
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_welcome, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> {
                return true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}
