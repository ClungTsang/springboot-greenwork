package com.tsang.greenwork;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GreenworkApplicationTests {

    @Test
    public void test(){

        Atest a =  new Atest(1);
        Atest b =  new Atest(3);
        System.out.println(a.add(b));


    }
    class  Atest {
        private int x;

        Atest(int x){
            this.x = x;
        }
        int add(Atest b){
            return this.x + b.x;
        }
    }
}
