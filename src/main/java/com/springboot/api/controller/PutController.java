package com.springboot.api.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.dto.MemberDto;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
    
    // @RequestBody와 Map을 활용한 PUT 메서드
    // Path : https://springboot-gwbpo.run.goorm.app/api/v1/put-api/member
    @PutMapping(value = "/member")
    public String putMember(@RequestBody Map<String, Object> putData) {
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n" );
        });

        return sb.toString();
    }

    // DTO 객체를 활용한 PUT 메서드 구현
    // Path : https://springboot-gwbpo.run.goorm.app/api/v1/put-api/member1
    @PutMapping(value = "/member1")
    public String putMemberDto1(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }


    // Path : https://springboot-gwbpo.run.goorm.app/api/v1/put-api/member2
    @PutMapping(value = "/member2")
    public MemberDto putMemberDto2(@RequestBody MemberDto memberDto) {
        return memberDto;
    }

    // ResponseEntity를 활용한 PUT 메서드
    // Path : https://springboot-gwbpo.run.goorm.app/api/v1/put-api/member3
    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDto> putMemberDto3(@RequestBody MemberDto memberDto) {
        return ResponseEntity
            .status(HttpStatus.ACCEPTED)
            .body(memberDto);
    }
}
