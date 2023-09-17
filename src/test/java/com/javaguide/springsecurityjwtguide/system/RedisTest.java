package com.javaguide.springsecurityjwtguide.system;

import com.javaguide.springsecurityjwtguide.SpringSecurityJwtGuideApplicationTest;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest extends TestCase {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void redis() {
        stringRedisTemplate.opsForValue().set("key", "value");
        System.out.println(stringRedisTemplate.opsForValue().get("key"));
        assertEquals(stringRedisTemplate.opsForValue().get("key"), "value");
    }
}
