package com.ysynzehao.spring.redis.service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/5.
 */
public interface JRedisService {

	public boolean set(String key, Object value, long expire);
	
    public boolean set(String key, Object value);

    public String get(String key);

    public <T> T get(String key, Class<T> clz);

    public boolean expire(String key,long expire);

    public <T> boolean setList(String key ,List<T> list);

    public <T> List<T> getList(String key,Class<T> clz);

    public long lpush(String key,Object obj);

    public long rpush(String key,Object obj);

    public String lpop(String key);

}