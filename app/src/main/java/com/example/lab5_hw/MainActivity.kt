package com.example.lab5_hw

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnD : Button = findViewById(R.id.btn_Dia)
        btnD.setOnClickListener {

            AlertDialog.Builder(this)
            .setTitle("請選擇功能")
            .setMessage("請依據下方按鈕選擇要顯示的物件")
            .setNeutralButton("取消"){ _ , _ ->
                Toast.makeText(this,"dialog關閉",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("自訂義Toast") { _ , _ ->
                showToast()
            }
            .setPositiveButton("顯示list") { _ , _ ->
                showListDialog()
            }
            .show()
        }
    }
    private  fun showToast(){
        val toast = Toast(this@MainActivity)
        toast.setGravity(Gravity.TOP,0,50)
        toast.duration = (Toast.LENGTH_SHORT)
        val inflater  = layoutInflater
        val layout : View = inflater.inflate(R.layout.costom_toast,findViewById(R.id.custom_toast_root))
        toast.view = layout
        toast.show()
    }
    private  fun showListDialog(){
        val list : Array<String> = arrayOf("message1","message2","message3","message4","message5","message6")
        AlertDialog.Builder(this@MainActivity)
        .setTitle("使用LIST呈現")
        .setItems(list){_,i ->
            Toast.makeText(this@MainActivity,"你選的是"+list[i],Toast.LENGTH_SHORT).show()
        }
        .show()
    }
}
