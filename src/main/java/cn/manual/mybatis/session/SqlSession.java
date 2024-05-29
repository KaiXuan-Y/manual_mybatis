package cn.manual.mybatis.session;

/**
 * @author yangkaixuan
 */
public interface SqlSession {
    /**
     * 根据sqlID获取一条记录的封装对象
     * @param statement
     * @return
     * @param <T>
     */
    <T> T selectOne(String statement);


    <T> T selectOne(String statement, Object parameter);


    <T> T getMapper(Class<T> type);
}
