package com.demo.service;

import org.junit.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestServiceTest {
    TestService testService = new TestService();
    private String input;
    private String output;

    public TestServiceTest(String input,String output)
    {
        this.input=input;
        this.output=output;
    }
    @Parameterized.Parameters
    public static Collection<String[]> test(){
        String[][] ExpectedOutput ={
                {"Aryan","An"},
                {"vdcd","vd"},
                {"vdc3","v3"},
                {"vdce","ve"},
                {"vdcy","vy"},
                {"tdcd","td"},
        };
        return Arrays.asList(ExpectedOutput);
    }
    @BeforeClass
    public static void beforeClass() {
        System.out.println("before class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("after class");
    }
    @Before
    public void beforeEach() {
        System.out.println("before Each");
    }

    @After
    public  void afterEach() {
        System.out.println("After each");
    }

//    @Test
//    public void testFirstMethod() {
//        assertEquals(1, testService.test());
//    }
//
    @Test
    public void testFirstAndLastChar_1(){
        assertEquals(output,testService.firstAndLastChar(input));
    }
    @Test
    public void testFirstAndLastChar_2(){
        assertEquals(output,testService.firstAndLastChar(input));
    }
    @Test
    public void testFirstAndLastChar_3(){
        assertEquals(output,testService.firstAndLastChar(input));
    }
    @Test
    public void testFirstAndLastChar_4(){
        assertEquals(output,testService.firstAndLastChar(input));
    }
}