package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 해당 클래스가 스프링 부트를 설정하는 클래스임을 의미 -> 이 클래스가 있는 패키지를 베이스 패키지로 간주.
// 베이스(기준) 패키지와 그 하위 패키지에서 자바 Bean을 찾아 스프링의 DI 컨테이너 오브젝트(어플리케이션 컨텍스트, ApplicationContext)에 등록.
// App 실행 중 어떤 오브젝트가 필요한 경우 의존하는 다른 오브젝트를 찾아 연결해 줌.
// 자동으로 다른 오브젝트를 찾아 연결해 주는 것은 @Autowired 어노테이션이 함.

// 어떻게 ApplicationContext 에 등록할 자바 Bean을 찾는걸까?
// @Component : 어이 스프링씨 ~ 이 클래스 좀 자바 Bean으로 등록해주쇼 !
// 그러면 위 어노테이션만 붙이면 알아서 찾아주나?
// ㄴㄴ
// @ComponentScan 이 클래스에 있어야하만 컴포넌트를 검색해서 등록할 수 있음/
// @SpringBootApplication 내부적으로 이미 위 어노테이션을 포함함.

// 스프링을 이용해 관리하고 싶은 Bean 이 있다? 그러면 Bean의 클래스 상단에 @Component를 추가해주면 자동으로 이 오브젝트를 스프링에 빈으로 등록할 수 있음.
// @Autowired와 함께 이용하면, 스프링이 필요할 때 알아서 이 오브젝트를 생성해줌

// 자동으로 오브젝트를 찾아 생성하는 방법을 원치않는다면?
// 수동적으로 스프링으로 빈을 관리하려면 @Bean 을 이용해 이 빈을 이렇게 생성해라고 명시해줘야한다.
// @Bean을 잉요하면 스프링에게 오브젝트를 정확히 어떻게 생성해야 하는지, 매개변수를 어떻게 넣어줘야하는지 알려줄 수 있음.

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
