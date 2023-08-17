package com.example.catsapp.UI.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.catsapp.Model.CatFact
import com.example.catsapp.Network.CatFactRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CatViewModel : ViewModel() {

    private val catFactRepository = CatFactRepository()
    val catLiveData: MutableLiveData<CatFact> = MutableLiveData()

    fun getRandomCatFact() {
      GlobalScope.launch(Dispatchers.Main) {
          val fact = catFactRepository.getRandomCatFact();
          fact?.let {
              catLiveData.postValue(it)
          }

      }
    }
}
