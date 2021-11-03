package com.shady.room
import androidx.room.Dao
import androidx.room.Query
import org.intellij.lang.annotations.Flow


@Dao

interface WordDao {

 @Query ( "SELECT * FROM word_table ORDER BY word ASC")

 fun getAlphabetizedWords(): Flow<List<Word>>
 abstract fun insert(word: Word)


}