package com.demo.service;

public class TestService {
    public int test() {
        return 1;
    }
    public String firstAndLastChar(String s){
        String ans = s.charAt(0)+""+s.charAt(s.length()-1);
        return ans;
    }
}
