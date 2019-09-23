package com.penguodev.jetpackexample

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import com.penguodev.jetpackexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    private var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding?.lifecycleOwner = this

        viewModel = ViewModelProviders.of(this)
            .get(MainViewModel::class.java)
            .also {
                binding?.viewModel = it
            }
    }
}

class MainViewModel(private val app: Application) : AndroidViewModel(app) {

    val value = MutableLiveData<Int>().apply { value = 0 }

    fun onClickPlus1(view: View?) {
        value.value = (value.value ?: 0) + 1
    }

    fun onClickMinus1(view: View?) {
        value.value = (value.value ?: 0) - 1
    }
}