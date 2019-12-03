package com.tsang.greenwork;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GreenworkApplicationTests {


    @Test
    public void test(){
        int input = 0;
        if(input%4==0||"0".equals(input)){
            System.out.println("output:true");
        }else{
            System.out.println("output:false");
        }
    }

    @Test
    public void test01(){
        int input = 0;
        if(input%4==0||"0".equals(input)){
            System.out.println("output:true");
        }else{
            System.out.println("output:false");
        }
    }
}
