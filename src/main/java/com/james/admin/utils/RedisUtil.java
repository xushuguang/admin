package com.james.admin.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class RedisUtil {

    @Autowired
    private JedisPool jedisPool;


    public void setString(String key,String value){

        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            jedis.set(key,value);
        }catch (Exception e){

        }finally {
            jedis.close();
        }
    }


    public String getString(String key){

        Jedis jedis = null;
        String result = null;
        try{
            jedis = jedisPool.getResource();
            result = jedis.get(key);
        }catch (Exception e){

        }finally {
            jedis.close();
        }
        return result;
    }


}
