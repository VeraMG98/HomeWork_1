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
                edit_name.setText(
                        resultName.data?.getStringExtra(SecondActivity.TOTAL_COUNT).toString())
            }
        }

        btn_enter.setOnClickListener {
            if (edit_name.text.isEmpty())
                Toast.makeText(applicationContext, R.string.enter_name, Toast.LENGTH_SHORT).show()
            else {
                resultName.launch(Intent(this, SecondActivity :: class.java)
                        .putExtra(SecondActivity.TOTAL_COUNT, edit_name.text.toString()))
            }
        }
    }
}