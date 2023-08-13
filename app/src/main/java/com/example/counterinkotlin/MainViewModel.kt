package com.example.counterinkotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
  private var counter:Int=0

    private var score=MutableLiveData<Int>()

    val counterData: LiveData<Int> = score

    init {
        score.postValue(counter)
    }


    fun increment(){
        counter++
        score.postValue(counter)
    }
    fun decrement(){
        counter--
        score.postValue(counter)
    }

    fun reset(){
        counter=0
        score.postValue(counter)
    }

}