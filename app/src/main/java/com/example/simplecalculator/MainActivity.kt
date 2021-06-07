package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var isNewOp = true
    var oldnum =""
    var op = "+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun noevent(view: View) {
        if (isNewOp)
            entry.setText("")
        isNewOp=false
        var buclick= entry.text.toString()
        var buselect = view as Button
        when(buselect.id){
            one.id ->{buclick+="1"}
            two.id ->{buclick+="2"}
            three.id ->{buclick+="3"}
            four.id ->{buclick+="4"}
            five.id ->{buclick+="5"}
            six.id ->{buclick+="6"}
            seven.id ->{buclick+="7"}
            eight.id ->{buclick+="8"}
            nine.id ->{buclick+="9"}
            zero.id ->{buclick+="0"}
            dot.id->{buclick+="."}
            plusminus.id->{buclick="-$buclick"}
        }
        entry.setText(buclick)
    }

    fun opevent(view: View) {
        isNewOp=true
        oldnum=entry.text.toString()
        var buselect = view as Button
        when(buselect.id){
            into.id -> {op ="*"}
            plus.id -> {op ="+"}
            minus.id -> {op ="-"}
            divide.id -> {op="/"}
            percentage.id ->{op="%"}
        }
        entry.setText(op)
    }

    fun equalevent(view: View) {
        isNewOp= true
        var newnum = entry.text.toString()
        var result = 0.0
        when(op){
            "+"-> {result = oldnum.toDouble() + newnum.toDouble()}
            "-"-> {result = oldnum.toDouble() - newnum.toDouble()}
            "*"-> {result = oldnum.toDouble() * newnum.toDouble()}
            "/"-> {result = oldnum.toDouble() / newnum.toDouble()}
            "%"-> {result = (oldnum.toDouble()/100)* newnum.toDouble()}
        }
        entry.setText(result.toString())
    }

    fun clearAll(view: View) {
        entry.setText("0")
        isNewOp=true
    }

    fun backspace(view: View) {
        val text = entry.text.toString()
        if(text.isNotEmpty()) {
            entry.setText(text.dropLast(1))
        }
        val temp=entry.text.toString()
        if (temp.isEmpty()){entry.setText("0")
            isNewOp=true
        }
    }
}