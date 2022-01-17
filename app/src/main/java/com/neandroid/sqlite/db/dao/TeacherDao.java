package com.neandroid.sqlite.db.dao;

import com.neandroid.sqlite.db.entity.Teacher;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

/**
 * 定义一个Dao接口文件，以完成对Entity的访问
 */
@Dao
public interface TeacherDao {

    @Insert
    abstract void insert(Teacher teacher);

    @Delete
    abstract void delete(Teacher teacher);

    @Update
    abstract void update(Teacher teacher);

    @Query("SELECT * FROM teacher")
    List<Teacher> getAll();

    @Query("SELECT * FROM teacher WHERE Id = :id")
    abstract Teacher getById(int id);
}
