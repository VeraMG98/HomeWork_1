package com.example.homework_1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        init()
    }

    private fun init() {
        edit_name_second.setText(intent.getStringExtra(TOTAL_COUNT))
        btn_back_second.setOnClickListener {
            if (edit_name_second.text.isEmpty())
                Toast.makeText(applicationContext, R.string.enter_name, Toast.LENGTH_SHORT).show()
            else {
                App.addList(edit_name_second.text.toString())
                setResult(
                    Activity.RESULT_OK, Intent()
                    .putExtra(TOTAL_COUNT, edit_name_second.text.toString()))
                finish()
            }
        }
    }

    companion object {
        const val TOTAL_COUNT = "total_count"
    }
}