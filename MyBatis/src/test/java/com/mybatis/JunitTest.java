package com.mybatis;

import org.junit.*;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: nekotako
 * @Date: 2023/7/1 10:34
 */
public class JunitTest {
    @Test
    public void show(){
        System.out.println("TEST");
    }
    @Before
    public void before(){
        System.out.println("Before");
    }
    @After
    public void after(){
        System.out.println("After");
    }
    @BeforeClass
    public static void beforeClass(){
        System.out.println("beforeClass");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("afterClass");
    }
}


















