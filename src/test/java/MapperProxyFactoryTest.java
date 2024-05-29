import cn.manual.mybatis.binding.MapperProxyFactory;
import dao.IUserDao;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapperProxyFactoryTest {

    @Test
    public void test_MapperProxyFactory() throws Exception {
        MapperProxyFactory<IUserDao> proxyFactory = new MapperProxyFactory<>(IUserDao.class);
        Map<String, String> sqlSession = new HashMap<>();

        sqlSession.put("dao.IUserDao.queryUserName", "模拟执行 Mapper.xml SQL 语句的操作：查询用户姓名");
        sqlSession.put("dao.IUserDao.queryUserAge", "模拟执行 Mapper.xml SQL 语句的操作：查询用户年龄");

//        IUserDao iUserDao = proxyFactory.newInstance(sqlSession);

//        String res = iUserDao.queryUserName("1001");
//        System.out.println(res);


    }
}
