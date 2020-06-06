package com.tuacy.room.database.daos;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.tuacy.room.database.entities.User;

import java.util.List;

import io.reactivex.Flowable;

/**
 * 用于访问数据库的方法
 */
@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insert(User... users);


//    @Insert
//    List<Long> insert(User... users);

    @Query("SELECT * from user")
    Flowable<List<User>> loadUser();




}
