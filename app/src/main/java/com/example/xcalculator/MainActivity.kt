package com.example.xcalculator

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.xcalculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btn0.setOnClickListener {
            binding.inputText.append("0")
        }
        binding.btn1.setOnClickListener {
            binding.inputText.append("1")
        }
        binding.btn2.setOnClickListener {
            binding.inputText.append("2")
        }
        binding.btn3.setOnClickListener {
            binding.inputText.append("3")
        }
        binding.btn4.setOnClickListener {
            binding.inputText.append("4")
        }
        binding.btn5.setOnClickListener {
            binding.inputText.append("5")
        }
        binding.btn6.setOnClickListener {
            binding.inputText.append("6")
        }
        binding.btn7.setOnClickListener {
            binding.inputText.append("7")
        }
        binding.btn8.setOnClickListener {
            binding.inputText.append("8")
        }
        binding.btn9.setOnClickListener {
            binding.inputText.append("9")
        }
        binding.btnPlus.setOnClickListener {
            binding.inputText.append("+")
        }
        binding.btnMinus.setOnClickListener {
            binding.inputText.append("-")
        }
        binding.btnMultiply.setOnClickListener {
            binding.inputText.append("*")
        }
        binding.btnDivide.setOnClickListener {
            binding.inputText.append("/")
        }
        binding.btnBracket1.setOnClickListener {
            binding.inputText.append("(")
        }
        binding.btnBracket2.setOnClickListener {
            binding.inputText.append(")")
        }
        binding.btnDot.setOnClickListener {
            binding.inputText.append(".")
        }
        binding.btnAC.setOnClickListener {
            binding.inputText.text = ""
            binding.outputText.text = ""
        }

        binding.btnBackspace.setOnClickListener {
            val string = binding.inputText.text.toString()
            if(string.isNotEmpty()){
                binding.inputText.text = string.substring(0,string.length-1)
            }
        }

        binding.btnEqual.setOnClickListener {
          if (binding.inputText.text.toString().isEmpty()){
              binding.outputText.text = "0"
          }
          else {
              try {
                  val expression = ExpressionBuilder(binding.inputText.text.toString()).build()
                  val result = expression.evaluate()
                  val longResult = result.toLong()

                  if (result == longResult.toDouble()) {
                      binding.outputText.text = longResult.toString()
                  } else {
                      binding.outputText.text = result.toString()
                  }
              }catch (e: Exception){
                  binding.outputText.text = "ERROR"
              }
          }
            binding.inputText.text = ""
        }

    }

}