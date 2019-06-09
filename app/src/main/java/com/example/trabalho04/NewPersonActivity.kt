package com.example.trabalho04

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_new_person.*

class NewPersonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_person)

        spn_group.adapter = ArrayAdapter<Group>(this, android.R.layout.simple_list_item_1, Group.values())

        btn_new.setOnClickListener {

            if (edt_name.text.length < 3) {
                edt_name.error = "Insira um nome valido"
            } else if (edt_address.text.length < 10) {
                edt_address.error = "Insira um endereço valido"
            } else {
                val person = Person(
                    edt_name.text.toString(),
                    edt_age.text.toString().toInt(),
                    edt_address.text.toString(),
                    spn_group.selectedItem as Group
                )
                setResult(Activity.RESULT_OK, Intent().putExtra("newPerson", person))
                finish()
            }
        }
    }
}
