package com.example.homework_1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var resultName : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        resultName = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            resultName ->
            if (resultName.resultCode == Activity.RESULT_OK) {
                val name = resultName.data?.getStringExtra(SecondActivity.TOTAL_COUNT).toString()
                edit_name.setText(name)
            }
        }

        btn_enter.setOnClickListener {
            if (edit_name.text.isEmpty())
                Toast.makeText(applicationContext, R.string.enter_name, Toast.LENGTH_SHORT).show()
            else {
                App.addList(edit_name.text.toString())
                resultName.launch(Intent(this, SecondActivity :: class.java)
                    .putExtra(SecondActivity.TOTAL_COUNT, edit_name.text.toString()))
            }
        }

        btn_get__list.setOnClickListener {
            App.addList(edit_name.text.toString())
            startActivity(Intent(this, ThirdActivity :: class.java))
        }
    }
}