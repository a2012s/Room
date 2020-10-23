package com.tuacy.room.database

import androidx.room.*


@Dao
public interface HeadItemDao {

    //@Insert(onConflict = OnConflictStrategy.REPLACE)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHeadItem(headItem: HeadItem?)

    @Update
    fun updateHeadItem(headItem: HeadItem?)

    @Query("SELECT * FROM headItem")
    fun getHeadItemList(): List<HeadItem?>?

    @Query("SELECT * FROM headItem WHERE id = :id")
    fun getHeadItemById(id: Long): HeadItem?


}