package cn.manual.mybatis.binding;

import cn.manual.mybatis.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 代理mapper
 *
 * @author yangkaixuan
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {


    private static final long serialVersionUID = -6430539691155168121L;

    private SqlSession sqlSession;

    private final Class<T> mapperInterface;

    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        }else {
            return sqlSession.selectOne(method.getName(), args);
        }
    }
}
