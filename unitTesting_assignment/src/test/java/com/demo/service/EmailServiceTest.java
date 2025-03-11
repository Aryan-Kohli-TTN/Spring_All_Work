package com.demo.service;

import com.sun.org.apache.xpath.internal.objects.XStringForChars;
import org.junit.After;
import org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.demo.domain.Order;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class EmailServiceTest {
    @InjectMocks
    EmailService emailService;
    @Test(expected = RuntimeException.class)
    public void test_sendEmail_withoutCC(){
        Order order= new Order(12,"MOBILE",10000);
        try{
            emailService.sendEmail(order);
        }
        catch (RuntimeException exception){
            assertFalse(order.isCustomerNotified());
        }
    }
    @Test
    public void test_sendEmail_withCC() {
        Order order = new Order(12, "MOBILE", 10000);
        boolean result = emailService.sendEmail(order, "CC");
        assertTrue(result);
        assertTrue(order.isCustomerNotified());
    }

}