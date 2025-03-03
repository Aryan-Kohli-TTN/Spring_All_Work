package com.example.Spring_Aop.Data;

import com.example.Spring_Aop.Annotations.MyAnnotation;
import org.springframework.stereotype.Repository;

@Repository
public class Dao2 {
    public String reteriveSomething(){
        return "Dao2";
    }
}