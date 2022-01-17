package com.neandroid.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.neandroid.sqlite.db.MyAppDatabase;
import com.neandroid.sqlite.db.MyAppDatabase2;
import com.neandroid.sqlite.db.dao.StudentDao;
import com.neandroid.sqlite.db.dao.TeacherDao;
import com.neandroid.sqlite.db.entity.Student;
import com.neandroid.sqlite.db.entity.Teacher;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String TAG = this.getClass().getSimpleName();

    /**
     * 获取能够操作数据库的DAO,学生表DAO
     */
    private StudentDao mStudentDao;

    /**
     * 获取能够操作数据库的DAO,老师表DAO
     */
    private TeacherDao mTeacherDao;

    /**
     * 操作第二个数据库
     */
    private TeacherDao mTeacherDao2;
    private StudentDao mStudentDao2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyAppDatabase myAppDatabase = MyAppDatabase.getInstance(MyApp.getContext());
        mStudentDao = myAppDatabase.studemtDao();
        mTeacherDao = myAppDatabase.teacherDao();

        MyAppDatabase2 myAppDatabase2 = MyAppDatabase2.getInstance(MyApp.getContext());
        mStudentDao2 = myAppDatabase2.studemtDao();
        mTeacherDao2 = myAppDatabase2.teacherDao();
    }

    /**
     * 插入学生数据
     *
     * @param view
     */
    public void onInsertStudent(View view) {
        Student student = new Student(1, "杨过", 22, "桃花岛");
        Student student2 = new Student(2, "小龙女", 18, "武当");
        Student student3 = new Student(3, "周芷若", 20, "峨嵋山");
        Student student4 = new Student(4, "黄蓉", 27, "襄阳");
        Student student5 = new Student(5, "令狐冲", 25, "华山");
        Student student6 = new Student(6, "郭靖", 31, "衡山");
        Student student7 = new Student(7, "张三丰", 80, "少林寺");
        mStudentDao.insert(student);
        mStudentDao.insert(student2);
        mStudentDao.insert(student3);
        mStudentDao.insert(student4);
        mStudentDao.insert(student5);
        mStudentDao.insert(student6);
        mStudentDao.insert(student7);
    }

    /**
     * 删除学生数据
     *
     * @param view
     */
    public void onDeleteStudent(View view) {
        Student student = new Student(2, "小龙女", 18, "武当");
        mStudentDao.delete(student);
    }

    /**
     * 更新学生数据
     *
     * @param view
     */
    public void onUpdateStudent(View view) {
        Student student = new Student(3, "周芷若", 25, "峨嵋山");
        mStudentDao.update(student);
    }

    /**
     * 查询学生数据
     *
     * @param view
     */
    public void onQueryStudent(View view) {
        List<Student> students = mStudentDao.getAll();
        for (Student student : students) {
            Log.d(TAG, student.id + "," + student.name + "," + student.age + "," + student.address);
        }
    }

    /**
     * by查询学生数据
     *
     * @param view
     */
    public void onQueryByStudent(View view) {
        Student student = mStudentDao.getById(3);
        Log.d(TAG, student.id + "," + student.name + "," + student.age + "," + student.address);
    }


    /**
     * 插入学生数据
     *
     * @param view
     */
    public void onInsertTeacher(View view) {
        Teacher teacher = new Teacher(1, "杨过", 22, "桃花岛", "语文");
        Teacher teacher2 = new Teacher(2, "小龙女", 18, "武当", "数学");
        Teacher teacher3 = new Teacher(3, "周芷若", 20, "峨嵋山", "历史");
        Teacher teacher4 = new Teacher(4, "黄蓉", 27, "襄阳", "物理");
        Teacher teacher5 = new Teacher(5, "令狐冲", 25, "华山", "化学");
        Teacher teacher6 = new Teacher(6, "郭靖", 31, "衡山", "地理");
        Teacher teacher7 = new Teacher(7, "张三丰", 80, "少林寺", "体育");
        mTeacherDao2.insert(teacher);
        mTeacherDao2.insert(teacher2);
        mTeacherDao2.insert(teacher3);
        mTeacherDao2.insert(teacher4);
        mTeacherDao2.insert(teacher5);
        mTeacherDao2.insert(teacher6);
        mTeacherDao2.insert(teacher7);
    }

    /**
     * 删除学生数据
     *
     * @param view
     */
    public void onDeleteTeacher(View view) {
        Teacher student = new Teacher(2, "小龙女", 18, "武当", "物理");
        mTeacherDao2.delete(student);
    }

    /**
     * 更新学生数据
     *
     * @param view
     */
    public void onUpdateTeacher(View view) {
        Teacher teacher = new Teacher(3, "周芷若", 25, "峨嵋山", "地理");
        mTeacherDao2.update(teacher);
    }

    /**
     * 查询学生数据
     *
     * @param view
     */
    public void onQueryTeacher(View view) {
        List<Teacher> students = mTeacherDao2.getAll();
        for (Teacher teacher : students) {
            Log.d(TAG, teacher.id + "," + teacher.name + "," + teacher.age + "," + teacher.address + "," + teacher.course);
        }
    }

    /**
     * by查询学生数据
     *
     * @param view
     */
    public void onQueryByTeacher(View view) {
        Teacher teacher = mTeacherDao2.getById(3);
        Log.d(TAG, teacher.id + "," + teacher.name + "," + teacher.age + "," + teacher.address + "," + teacher.course);
    }

}