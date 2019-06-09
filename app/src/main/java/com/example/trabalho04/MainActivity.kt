package com.example.trabalho04

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.ListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQUEST_NEW_PERSON: Int = 1

    val people: MutableList<Person> = mutableListOf<Person>(
        Person("Raphael Garnica", 23, "Rua Jose Carlos Clodoaudo", Group.BLUE),
        Person("Ana", 23, "Rua olimpo gomes arnaldo", Group.GREEN),
        Person("João", 20, "Rua marta joana", Group.RED)
    )

    var viewAdapter : PersonListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewAdapter = PersonListAdapter(this, people)
        val viewManager : RecyclerView.LayoutManager = LinearLayoutManager(this)


        list_people.apply {
            adapter = viewAdapter
            layoutManager = viewManager
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_new_person -> {
                startActivityForResult(Intent(this, NewPersonActivity::class.java), REQUEST_NEW_PERSON)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_NEW_PERSON && resultCode == Activity.RESULT_OK) {
            val person = data!!.getParcelableExtra<Person>("newPerson")
            people.add(person)
            viewAdapter!!.notifyDataSetChanged()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
