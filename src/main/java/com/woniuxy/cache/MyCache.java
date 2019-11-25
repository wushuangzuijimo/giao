package com.woniuxy.cache;

import org.apache.ibatis.cache.Cache;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @version 1.0
 * @auther wushuang
 *
 * 用redis替代了mybatis的二级缓存,核心代码是clear整个db清空
 * @date 2019/11/4 14:03
 */
public class MyCache implements Cache{
    private RedisTemplate redisTemplate;

    RedisAutoConfiguration dAutoConfiguration;

    private final String id;

    public MyCache(String id) {
        System.out.println("当前二级缓存的id是 "+id);
        System.out.println("开始获取redisTemplate");
        redisTemplate = (RedisTemplate)ApplicationContextHolder.getBean("redisTemplate");
        System.out.println("获取redisTemplate"+redisTemplate);
        this.id = id;
    }

    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return id;
    }


    @Override
    public void putObject(Object key, Object value) {
        // TODO Auto-generated method stub
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public Object getObject(Object key) {
        // TODO Auto-generated method stub
        Object obj = redisTemplate.opsForValue().get(key);
        return obj;
    }

    @Override
    public Object removeObject(Object key) {
        // TODO Auto-generated method stub
        return redisTemplate.delete(key);
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        //insert update delete都会调用clear.原理的clear只清空当前namespace下的数据
        //坚决禁止的写法  跨过spring 直接使用 redis的connection
        //Session sessionFactory
        // Mybatis  JPA Hibernate  TopLink EclipseLink OpenJpa
        //  HiberateTemplate  JdbcTemplate  JPATempldate
        //如果非要跨过模板，想使用底层的数据 必须使用回调函数
        //redisTemplate.getConnectionFactory().getConnection().flushDb();

        redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                // TODO Auto-generated method stub
                connection.flushDb();//清空当前数据库
                return null;
            }
        });
    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        Object size = redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                // TODO Auto-generated method stub

                return connection.dbSize();
            }
        });
        return Integer.parseInt(size.toString());
    }

}