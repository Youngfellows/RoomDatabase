package com.neandroid.sqlite.db.dao;

import com.neandroid.sqlite.db.entity.Student;

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
public interface StudentDao {

    @Insert
    abstract void insert(Student student);

    @Delete
    abstract void delete(Student student);

    @Update
    abstract void update(Student student);

    @Query("SELECT * FROM student")
    List<Student> getAll();

    @Query("SELECT * FROM student WHERE Id = :id")
    abstract Student getById(int id);
}
