package com.neandroid.sqlite.db;

import android.content.Context;

import com.neandroid.sqlite.db.dao.StudentDao;
import com.neandroid.sqlite.db.dao.TeacherDao;
import com.neandroid.sqlite.db.entity.Student;
import com.neandroid.sqlite.db.entity.Teacher;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;


@Database(version = 1,//版本号
        exportSchema = false,
        entities = {Student.class, Teacher.class})//支持的数据库表
public abstract class MyAppDatabase extends RoomDatabase {

    /**
     * 数据库名称
     */
    private static final String DATABASE_NAME = "my_database.db";

    /**
     * 获取数据库实例-单例实现
     */
    private static MyAppDatabase INSTANCE;

    /**
     * 单例
     */
    public static MyAppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (MyAppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MyAppDatabase.class, DATABASE_NAME)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }

    /**
     * 添加需要操作数据库的DAO,操作student表
     */
    public abstract StudentDao studemtDao();

    /**
     * 添加需要操作数据库的DAO,操作teacher表
     */
    public abstract TeacherDao teacherDao();
}
