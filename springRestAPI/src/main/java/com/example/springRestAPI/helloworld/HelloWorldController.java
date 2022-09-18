package com.example.springRestAPI.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    // GET
    // /hello-world -> endpoint
    // 이전 방식
    // @RequestMapping(method=RequestMethod.GET, path="/hello-world")
    @GetMapping(path = "/hello-world")
    public String helloWorld() {

        return "Hello World";
    }

    // json 반환
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello world");
    }

    // springboot 동작 원리
    // yaml에 debug설정을 통해 빈등록 부터 확인할수있다.
    // DispatcherServlet : 사용자 요청을 처리하기위한 게이트 웨이라고 생각하면 편함
    // 클라이언트의 모든 요청을 한곳으로 받아서 처리,, 요청에 맞는 Handler로 요청 전달, Handler의 샐행 결과를 Http Response 형태로 만들어서 반환
    // 사용자 요청 -> 비즈니스로직 -> 호출한 요청에 결과값 리턴

    // json 반환
    @GetMapping(path = "/hello-world-bean/path-variable/{value}")
    public HelloWorldBean helloWorldBean(@PathVariable(value = "value") String name) {
        return new HelloWorldBean(String.format("Hello world, %s", name));
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage("greeting.message", null, locale);
    }

}
