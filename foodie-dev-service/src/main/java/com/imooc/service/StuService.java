package com.imooc.service;

import com.imooc.pojo.Stu;

public interface StuService {

    Stu getStuInfo(int id);

    Object saveStu();

    Object updateStu(int id);

    Object deleteStu(int id);

    public void saveParent();

    public void saveChildren();

}
