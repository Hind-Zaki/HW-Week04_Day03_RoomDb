package com.shady.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import java.lang.IllegalArgumentException

class WordViewModel(private val repository: WordRepository) : ViewModel() {

    val allWords: LiveData<List<Word>>=repository.allWords. asLiveData()
    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }


}
class WordViewModelFactroy(private val repository: WordRepository) :ViewModelProvider.Factory{

    override fun <T:ViewModel>create(modelClass: Class<T>:T){
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {

            @Suppress("UNCHECKED_CAST")

            return WordViewModel(repository) as T
        }
            throw IllegalArgumentException("Unknown ViewModel class")


    }



}

