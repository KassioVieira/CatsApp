package com.example.catsapp.UI.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.airbnb.lottie.LottieAnimationView
import com.example.catsapp.R
import com.example.catsapp.UI.ViewModel.CatViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(CatViewModel::class.java)
        val factTextView = findViewById<TextView>(R.id.factTextView)
        val lottieAnimationView = findViewById<LottieAnimationView>(R.id.animation);

        lottieAnimationView.playAnimation()

        viewModel.catLiveData.observe(this, Observer { fact ->
            factTextView.text = fact.fact
        })

        viewModel.getRandomCatFact()
    }
}