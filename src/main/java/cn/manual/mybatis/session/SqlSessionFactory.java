package cn.manual.mybatis.session;

import cn.manual.mybatis.session.SqlSession;

/**
 * @author yangkaixuan
 */
public interface SqlSessionFactory {

    SqlSession openSession();


}
