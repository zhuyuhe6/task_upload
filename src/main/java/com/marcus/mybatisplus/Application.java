package com.tbk.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author T-bk
 * @version 2.0
 * @date 2020/10/5 19:09
 */

@SpringBootApplication
@MapperScan("com.tbk.mybatisplus.mapper")   //扫描mapper文件夹
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
