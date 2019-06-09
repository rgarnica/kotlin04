package com.example.trabalho04

import android.content.Context
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_person.view.*

class PersonListAdapter(val context: Context, val data: MutableList<Person>) : RecyclerView.Adapter<PersonListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_person, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val item = data[p1]
        p0.let{
            it.name.text = item.name.plus(item.age)
            it.address.text = item.address
            it.image.setImageResource(item.group.resourceId)
        }

        p0.itemView.setOnLongClickListener {
            AlertDialog.Builder(it.context)
                .setTitle("Remover Pessoa")
                .setMessage("Gostaria mesmo de remover essa pessoa da lista?")
                .setPositiveButton("Sim") { _, _ ->
                    removeItem(p0.adapterPosition)
                }
                .setNegativeButton("Não") { dialog, _ ->
                    dialog.cancel()
                }
                .create()
                .show()
            return@setOnLongClickListener true
        }
    }

    fun removeItem(position: Int) {
        data.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, data.size)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.txt_person_name_age
        val address = itemView.txt_person_address
        val image = itemView.img_person_group
    }
}