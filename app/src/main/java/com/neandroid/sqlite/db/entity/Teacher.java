package com.neandroid.sqlite.db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


/**
 * 定义数据库表结构
 */
@Entity(tableName = "teacher")
public class Teacher {

    /**
     * 定义数据库表字段
     */
    //@PrimaryKey标签用于指定该字段作为表的主键。
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id", typeAffinity = ColumnInfo.INTEGER)
    public int id;

    @ColumnInfo(name = "Name", typeAffinity = ColumnInfo.TEXT)
    public String name;

    @ColumnInfo(name = "Age", typeAffinity = ColumnInfo.INTEGER)
    public int age;

    @ColumnInfo(name = "Address", typeAffinity = ColumnInfo.TEXT)
    public String address;

    @ColumnInfo(name = "Course", typeAffinity = ColumnInfo.TEXT)
    public String course;


    /**
     * Room会使用这个构造器来存储数据，也就是当你从表中得到Student对象时候，Room会使用这个构造器
     *
     * @param id
     * @param name
     * @param age
     * @param address
     */
    public Teacher(int id, String name, int age, String address, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.course = course;
    }

    /**
     * 由于Room只能识别和使用一个构造器，如果希望定义多个构造器，你可以使用Ignore标签，让Room忽略这个构造器
     * 同样，@Ignore标签还可用于字段，使用@Ignore标签标记过的字段，Room不会持久化该字段的数据
     */
    @Ignore
    public Teacher(String name, int age, String address,String course) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.course = course;
    }
}
