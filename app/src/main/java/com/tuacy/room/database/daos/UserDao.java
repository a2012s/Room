package com.tuacy.room.database.daos;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.tuacy.room.database.entities.User;

import java.util.List;

import io.reactivex.Flowable;

/**
 * 用于访问数据库的方法
 *
 * 如果 @Insert 方法只接收 1 个参数，则可返回 long，这是插入项的新 rowId。如果参数是数组或集合，则应返回 long[] 或 List<Long>。
 */
@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insert(User... users);

    @Insert
    void insertAll(User... users);


//    @Insert
//    List<Long> insert(User... users);

    @Query("SELECT * from user")
    Flowable<List<User>> loadUser();

    @Query("SELECT * FROM user")
    List<User> getAll();


    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);


    @Delete
    void delete(User user);




}
