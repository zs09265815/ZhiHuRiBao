package com.example.ce4;

import com.example.ce4.dao.App;
import com.example.ce4.dao.DaoMaster;
import com.example.ce4.dao.DaoSession;
import com.example.ce4.dao.StudentDao;

import java.util.ArrayList;
import java.util.List;

public class DbHolder {
    private static DbHolder dbHolder;
    private final StudentDao studentDao;

    private DbHolder(){
         DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(App.getApp(), "s.db");
         DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
         DaoSession daoSession = daoMaster.newSession();
        studentDao = daoSession.getStudentDao();
    }

    public static DbHolder getDbHolder() {
        if (dbHolder==null){
            synchronized (DbHolder.class){
                if (dbHolder==null){
                   dbHolder=new DbHolder();
                }
            }
        }
        return dbHolder;
    }
    public void insert(ArrayList<Student> stu){
        studentDao.insertOrReplaceInTx(stu);
    }
    public void updata(Student stu){
        studentDao.update(stu);
    }
    public void delete(Student stu){
        studentDao.delete(stu);
    }
    public List<Student> query(){
         List<Student> list = studentDao.queryBuilder().list();
        return list;
    }
}
