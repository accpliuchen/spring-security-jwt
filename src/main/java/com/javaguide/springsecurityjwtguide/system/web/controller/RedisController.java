package com.javaguide.springsecurityjwtguide.system.web.controller;


import com.javaguide.springsecurityjwtguide.system.service.UserService;
import com.javaguide.springsecurityjwtguide.system.web.representation.UserRepresentation;
import com.javaguide.springsecurityjwtguide.system.web.request.UserRegisterRequest;
import com.javaguide.springsecurityjwtguide.system.web.request.UserUpdateRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/redis")
@Api(tags = "Redis")
public class RedisController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping("/stringTest")
    @ApiOperation("string test redis")
    public String stringTest() {
        this.redisTemplate.delete("name");
        this.redisTemplate.opsForValue().set("name", "A");
        String name = this.redisTemplate.opsForValue().get("name");

        return name;
    }

    @RequestMapping("/listTest")
    @ApiOperation("list test redis")
    public List<String> listTest(){

        this.redisTemplate.delete("names");

        this.redisTemplate.opsForList().rightPushAll("names", "Apple", "IBM", "Google", "Meta"); 
        List<String> courses = this.redisTemplate.opsForList().range("names", 0, -1);
        return courses;
    }

    @RequestMapping("setTest")
    public Set<String> setTest() {
        this.redisTemplate.delete("courses");
        this.redisTemplate.opsForSet().add("courses", "java", "spring", "springboot");
        Set<String> courses = this.redisTemplate.opsForSet().members("courses");
        return courses;
    }

    @RequestMapping("hashTest")
    public Map<Object, Object> hashTest() {
        this.redisTemplate.delete("userMap");
        Map<String, String> map = new HashMap<>();
        map.put("name", "Peter");
        map.put("age", "30");
        this.redisTemplate.opsForHash().putAll("userMap", map);
        Map<Object, Object> userMap = this.redisTemplate.opsForHash().entries("userMap");
        return userMap;
    }
    @RequestMapping("zsetTest")
    public Set<String> zsetTest() {
        this.redisTemplate.delete("languages");
        this.redisTemplate.opsForZSet().add("languages", "java", 100d);
        this.redisTemplate.opsForZSet().add("languages", "c", 95d);
        this.redisTemplate.opsForZSet().add("languages", "php", 70);
        Set<String> languages = this.redisTemplate.opsForZSet().range("languages", 0, -1);
        return languages;
    }
}
