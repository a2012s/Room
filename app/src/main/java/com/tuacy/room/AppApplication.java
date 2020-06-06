package com.tuacy.room;

import android.app.Application;

import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.tuacy.room.database.AppDatabase;

public class AppApplication extends Application {

    private AppDatabase mAppDatabase;

    private String databaseName = "android_room_dev.db";

    @Override
    public void onCreate() {
        super.onCreate();
        
        //创建数据库的实例
        mAppDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, databaseName)
                .allowMainThreadQueries()
                .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                .build();
    }

    public AppDatabase getAppDatabase() {
        return mAppDatabase;
    }

    /**
     * 数据库版本 1->2 user表格新增了age列
     */
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE User ADD COLUMN age integer");
        }
    };

    /**
     * 数据库版本 2->3 新增book表格
     */
    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL(
                    "CREATE TABLE IF NOT EXISTS `book` (`uid` INTEGER PRIMARY KEY autoincrement, `name` TEXT , `userId` INTEGER, 'time' INTEGER)");
        }
    };
}
