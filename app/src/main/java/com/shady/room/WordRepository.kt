package com.shady.room

import androidx.annotation.WorkerThread
import org.intellij.lang.annotations.Flow

class WordRepository(private val wordDao: WordDao) {

    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word){

        wordDao.insert(word)
    }





}