package com.tuacy.room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.tuacy.room.app.BaseActivity;
import com.tuacy.room.database.HeadItem;
import com.tuacy.room.database.entities.Book;
import com.tuacy.room.database.entities.User;

import java.util.Date;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.textView);

        findViewById(R.id.button_add_user).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_user();
                //add_headItem();
            }
        });

        findViewById(R.id.button_get_user).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get_user();
            }
        });

        findViewById(R.id.button_add_book).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setName("Android入门到精通");
                book.setTime(new Date());
                book.setUserId(1L);
                List<Long> ids = mAppDatabase.bookDao().insert(book);
                if (ids != null && ids.size() > 0) {

                    book.setUid(ids.get(ids.size() - 1));
                    textView.setText("添加 " + book.toString());

                    for (Long id : ids) {
                        Log.d("tuacy", "id = " + id);

                    }
                }
            }
        });

        findViewById(R.id.button_get_book).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAppDatabase.bookDao()
                        .load()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<List<Book>>() {
                            @Override
                            public void accept(List<Book> entities) {
                                if (entities != null) {
                                    for (Book book : entities) {
                                        Log.d("tuacy", book.toString());
                                        textView.setText(book.toString());
                                    }
                                }

                            }
                        });
            }
        });
    }

    private void get_user() {
        mAppDatabase.userDao()
                .loadUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<User>>() {
                    @Override
                    public void accept(List<User> entities) {
                        if (entities != null) {
                            StringBuilder sb = new StringBuilder();
                            for (User user : entities) {
                                Log.d("tuacy", user.toString());
                                sb.append(user.toString() + "\n");

                            }
                            textView.setText(sb.toString());
                        }

                    }
                });
    }


    private int no = 1;

    private void add_user() {
        no++;
        User user = new User(no, "tuac2", "广州", "18988195061", 18 + no, null);
//        user.setPhone("18988195061");
//        user.setAddress("珠海");
//        user.setName("tuacy");
        //				user.setAge("28");
        List<Long> ids = mAppDatabase.userDao().insert(user);
        if (ids != null && ids.size() > 0) {
            user.setUid(ids.get(ids.size() - 1));
            textView.setText("添加 " + user.toString());
            for (Long id : ids) {
                Log.d("tuacy", "id = " + id);

            }
        }
    }

    private void add_headItem() {
        HeadItem user = new HeadItem(55L, "测试的");
//        user.setDays();

        //				user.setAge("28");
        mAppDatabase.headItemDao().insertHeadItem(user);
        Log.d("logcat", mAppDatabase.headItemDao().getHeadItemById(55L).getName());
        textView.setText(String.format("添加 %s", mAppDatabase.headItemDao().getHeadItemById(55L).getName()));

    }
}
