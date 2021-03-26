package cn.zcbigdata.mybits_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("cn.zcbigdata.mybits_demo.mapper") //扫描的mapper
@SpringBootApplication
public class MybitsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybitsDemoApplication.class, args);
    }

}
