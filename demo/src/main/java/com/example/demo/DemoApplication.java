package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	/*
	 * AutoConfigration(자동 구성)
	 * 
	 * 스프링부트의 핵심 기능
	 * 애플리케이션의 클래스패스에 존재하는 라이브러리와 설정을 기반으로 Bean을 자동으로 구성해줌
	 * 
	 * @EnableAutoConfiguration
	 * 스프링부트의 자동구성을 활성화해주는 애노테이션
	 * @SpringBootApplication내부에 포함되어있기 때문에 직접 작성할 일은 잘 없음
	 * 
	 * @SpringBootApplication
	 * 스프링 부트 애플리케이션의 진입점 클래스에 사용되는 애노테이션
	 * 핵심 애노테이션
	 * @EnableAutoConfiguration
	 * @ComponentScan
	 * @Configuration
	 * 
	 * 동작순서
	 * 
	 * 애플리케이션 시작 -> @SpringBootApplication 애노테이션이 붙은 클래스의 main메서드에서 run을 호출
	 * 자동구성 활성화 -> @EnableAutoConfiguration 애노테이션을 통해 자동구성을 활성화
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
