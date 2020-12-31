package com.tsang.greenwork;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class GreenworkApplicationTests {


    @Test
    public void test01() {
        System.out.println(new Date(System.currentTimeMillis()+1000*60));

    }

}
