package com.isle.preventrepeattest;

import com.isle.preventrepeat.annotation.EnablePreventRepeat;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnablePreventRepeat
@MapperScan("com.isle.preventrepeattest.mapper")
public class PreventRepeatTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreventRepeatTestApplication.class, args);
	}

}

