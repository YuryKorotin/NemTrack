package com.androidhipster.node_monitor.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.androidhipster.node_monitor.R
import kotlinx.android.synthetic.main.activity_welcome.*
import org.kodein.di.Copy
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinContext
import org.kodein.di.android.closestKodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.kcontext

class WelcomeActivity : AppCompatActivity(), KodeinAware {

    override val kodeinContext: KodeinContext<*> = kcontext(this)

    private val _parentKodein by closestKodein()

    override val kodein: Kodein by retainedKodein {
        extend(_parentKodein, copy = Copy.All)
        //import(thermosiphonModule)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_welcome)
        setSupportActionBar(toolbar)

        /*fab.setOnClickListener { view ->
            addNewNode(view)
        }*/

        if(savedInstanceState == null) {
            //log.log("Going to brew coffee using $coffeeMaker")

            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.nis_list_fragment, NisListFragment())
                    .commit()
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
