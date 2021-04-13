package com.pomzwj.trans;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhaowj
 * @date 2021-04-13
 */
@MapperScan({"com.pomzwj.trans.dao.**"})
@SpringBootApplication
public class TransApplication {
	public static void main(String[] args){
		SpringApplication.run(TransApplication.class);
	}
}
