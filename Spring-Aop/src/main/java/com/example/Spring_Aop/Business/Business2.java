package com.example.Spring_Aop.Business;

import com.example.Spring_Aop.Data.Dao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business2 {

    @Autowired
    private Dao2 dao2;

    public String getSomething(){
        return dao2.reteriveSomething();
    }
}

