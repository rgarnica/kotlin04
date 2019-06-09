package com.example.trabalho04

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.list_item_person.view.*

class PersonListAdapter(val context: Context, val data: MutableList<Person>) : BaseAdapter() {

    val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.list_item_person, parent, false)
        val item = getItem(position) as Person
        rowView.apply {
            txt_person_address.text = item.address
            txt_person_name_age.text = item.name.plus(item.age)
            img_person_group.setImageResource(item.group.resourceId)
        }
        return rowView
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.size
    }
}