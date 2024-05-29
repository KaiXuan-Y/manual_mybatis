package cn.manual.mybatis.session;

import cn.hutool.log.Log;
import cn.manual.mybatis.binding.MapperProxyFactory;
import cn.manual.mybatis.binding.MapperRegistry;
import cn.manual.mybatis.session.dao.IUserDao;
import cn.manual.mybatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


public class MapperProxyFactoryTest {

//    @Test
//    public void test_MapperProxyFactory() throws Exception {
//        MapperProxyFactory<IUserDao> proxyFactory = new MapperProxyFactory<>(IUserDao.class);
//        Map<String, String> sqlSession = new HashMap<>();
//
//        sqlSession.put("dao.IUserDao.queryUserName", "模拟执行 Mapper.xml SQL 语句的操作：查询用户姓名");
//        sqlSession.put("dao.IUserDao.queryUserAge", "模拟执行 Mapper.xml SQL 语句的操作：查询用户年龄");
//
////        IUserDao iUserDao = proxyFactory.newInstance(sqlSession);
//
////        String res = iUserDao.queryUserName("1001");
////        System.out.println(res);
//
//
//    }


    @Test
    public void test_MapperProxyFactory() throws Exception {
        MapperRegistry mapperRegistry = new MapperRegistry();
        mapperRegistry.addMappers("cn.manual.mybatis.session.dao");

        DefaultSqlSessionFactory defaultSqlSessionFactory = new DefaultSqlSessionFactory(mapperRegistry);
        SqlSession sqlSession = defaultSqlSessionFactory.openSession();


        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        String s = mapper.queryUserName("10001");
        System.out.println(s);
    }
}
