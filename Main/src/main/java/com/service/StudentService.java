package com.service;

import com.dao.StudentMapper;
import com.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public Student getById(int id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    public int insert(Student student) {
        return studentMapper.insert(student);
    }

    @Async
    public void asyncMethod(int i){
        try{
            for(;i<10;i+=2){
                Thread.sleep(3000);
                System.out.println(i);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
