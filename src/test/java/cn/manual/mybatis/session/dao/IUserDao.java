package cn.manual.mybatis.session.dao;

public interface IUserDao {
    String queryUserName(String uId);

    Integer queryUserAge(String uId);
}
