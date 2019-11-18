package com.imooc.service.impl;

import com.imooc.mapper.StuMapper;
import com.imooc.pojo.Stu;
import com.imooc.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StuServiceImpl implements StuService {
        @Autowired
        private StuMapper stuMapper;

        @Override
        public Stu getStuInfo(int id) {
            return stuMapper.selectByPrimaryKey(id);
        }

    @Override
    public Object saveStu() {
            Stu stu=new Stu();
        stu.setRevision(0);
            stu.setName("zhang");
            stu.setAge("26");
        stuMapper.insert(stu);
        return "ok";
    }

    @Override
    public Object updateStu(int id) {
        Stu stu=new Stu();
        stu.setRevision(0);
        stu.setId(id);
        stu.setName("lucy");
        stu.setAge("27");
        stuMapper.updateByPrimaryKey(stu);
        return "ok";
    }

    @Override
    public Object deleteStu(int id) {
        stuMapper.deleteByPrimaryKey(id);
        return "ok";
    }

    public void saveParent(){
            Stu stu =new Stu();
            stu.setName("parent");
            stu.setAge("19");
            stuMapper.insert(stu);

    }
        @Transactional(propagation = Propagation.NESTED)
        public   void  saveChildren(){
            saveChild1();
            int a=1/0;
            saveChild2();
    }

    private void saveChild2() {
        Stu stu =new Stu();
        stu.setName("child-2");
        stu.setAge("22");
        stuMapper.insert(stu);
    }

    private void saveChild1() {
        Stu stu =new Stu();
        stu.setName("child-1");
        stu.setAge("11");
        stuMapper.insert(stu);
    }
}
