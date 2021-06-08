package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var isNewOp = true
    var oldnum =""
    var newnum =""
    var op = "+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun calculate( x: Double,  y: Double):Double{
        var result = 0.0
        when(op){
            "+"-> {result = x.toDouble() + y.toDouble()}
            "-"-> {result = x.toDouble() - y.toDouble()}
            "*"-> {result = x.toDouble() * y.toDouble()}
            "/"-> {result = x.toDouble() / y.toDouble()}
            "%"-> {result = (x.toDouble()/100)* y.toDouble()}
        }
        return result
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
        if (oldnum==""){
        oldnum=entry.text.toString()}
        else{
            newnum =entry.text.toString()
        }
        var buselect = view as Button
        when(buselect.id){
            into.id -> {op ="*"}
            plus.id -> {op ="+"}
            minus.id -> {op ="-"}
            divide.id -> {op="/"}
            percentage.id ->{op="%"}
        }
        entry.setText(op)
        if(newnum!=""){
            oldnum=(calculate(oldnum.toDouble(),newnum.toDouble())).toString()
        }
    }


    fun equalevent(view: View) {
        isNewOp= true
        newnum = entry.text.toString()
        oldnum=(calculate(oldnum.toDouble(),newnum.toDouble())).toString()
        entry.setText(oldnum)
        newnum=""
        oldnum=""
    }

    fun clearAll(view: View) {
        entry.setText("0")
        isNewOp=true
        oldnum=""
        newnum=""
    }

    fun backspace(view: View) {
        val text = entry.text.toString()
        if(text.isNotEmpty()) {
            entry.setText(text.dropLast(1))
        }
        val temp=entry.text.toString()
        if (temp.isEmpty()){entry.setText("0")
            isNewOp=true
            oldnum=""
            newnum=""
        }
    }
}