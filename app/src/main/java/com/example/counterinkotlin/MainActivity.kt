package com.example.counterinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.counterinkotlin.databinding.ActivityMainBinding

    lateinit var binding: ActivityMainBinding
    lateinit var mainmodel: MainViewModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       mainmodel= ViewModelProvider(this)[MainViewModel::class.java]
        mainmodel.counterData.observe(this){
            setValue(it)
        }

        binding.incrementBtn.setOnClickListener(){
            mainmodel.increment()

        }

        binding.decrementBtn.setOnClickListener(){
            mainmodel.decrement()

        }
        binding.ResetAll.setOnClickListener(){
            mainmodel.reset()

        }
    }

    fun setValue(int: Int){
        binding.counterTv.text="$int"
    }
}