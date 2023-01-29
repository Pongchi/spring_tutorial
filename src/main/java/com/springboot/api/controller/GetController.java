package com.springboot.api.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.dto.MemberDto;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
    
    // @RequestMapping 으로 구현하기
    // Path : https://springboot-gwbpo.run.goorm.app/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        return "Hello, World!";
    }

    // 스프링 4.3 버전 이후로 는 @RequestMapping 은 사용하지 않고, @GetMapping, @PostMapping, @PutMapping, @DeleteMapping 을 사용
    // Path : https://springboot-gwbpo.run.goorm.app/api/v1/get-api/name
    @GetMapping(value = "/name")
    public String getName() {
        return "Pongchi";
    }

    // @PathVariable 을 활용한 GET 메서드
    // Path : https://springboot-gwbpo.run.goorm.app/api/v1/get-api/variable1/{String}
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }

    // @PathVariable 변수명 매핑하기
    // Path : https://springboot-gwbpo.run.goorm.app/api/v1/get-api/variable2/{String}
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    // @RequestParam 을 이용한 GET 메서드
    // Path : https://springboot-gwbpo.run.goorm.app/api/v1/get-api/request1?name=value1&email=value2&organization=value3
    @GetMapping(value = "/request1")
    public String getRequestParam1(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String organization) {
            return name + " " + email + " " + organization;
    }

    // 쿼리스트링에 어떤 값이 들어올지 모른다면, Map 객체 활용 가능
    // Path : https://springboot-gwbpo.run.goorm.app/api/v1/get-api/request2?key1=value1&key2=value2
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> params) {
        StringBuilder sb = new StringBuilder();

        params.entrySet().forEach(param -> { 
            sb.append(param.getKey() + " : " + param.getValue() + "\n");
        });

        return sb.toString();
    }

    // DTO 객체를 활용한 GET 메서드
    // Path https://springboot-gwbpo.run.goorm.app/api/v1/get-api/request3?name=value1&email=value2&organization=value3
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDto) {
        return memberDto.toString();
    }
}