package com.tuacy.room.database.daos;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.tuacy.room.database.entities.Book;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface BookDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	List<Long> insert(Book... books);

	@Query("SELECT * from book")
	Flowable<List<Book>> load();

}
