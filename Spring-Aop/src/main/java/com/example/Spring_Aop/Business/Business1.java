package com.example.Spring_Aop.Business;

import com.example.Spring_Aop.Annotations.MyAnnotation;
import com.example.Spring_Aop.Data.Dao1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business1 {

    @Autowired
    private Dao1 dao1;

    @MyAnnotation
    public String getSomething(){
        return dao1.reteriveSomething();
    }
}
