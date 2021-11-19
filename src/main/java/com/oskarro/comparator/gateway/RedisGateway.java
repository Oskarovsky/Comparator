package com.oskarro.comparator.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/redis")
public class RedisGateway {

    @Autowired
    private RedisTemplate<String, String> template;

    private static final String STRING_KEY_PREFIX = "redi2read:strings:";

    @RequestMapping(method = RequestMethod.POST, value = "/string")
    @ResponseStatus(HttpStatus.CREATED)
    public Map.Entry<String, String> setString(@RequestBody Map.Entry<String, String> kvp) {
        template.opsForValue().set(STRING_KEY_PREFIX + kvp.getKey(), kvp.getValue());
        return kvp;
    }
}
