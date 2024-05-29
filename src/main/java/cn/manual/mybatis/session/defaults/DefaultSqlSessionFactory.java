package cn.manual.mybatis.session.defaults;

import cn.manual.mybatis.binding.MapperRegistry;
import cn.manual.mybatis.session.SqlSession;
import cn.manual.mybatis.session.SqlSessionFactory;



/**
 * @author yangkaixuan
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {


    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
