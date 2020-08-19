package com.wyd.dao;

import com.wyd.pojo.User;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.util.List;

public interface IUserDao {

    /**
     * 查询所有用户
     */
    List<User> selectList() throws Exception;

    /**
     * 根据条件进行用查询
     */
    User selectOne(User user) throws Exception;

    int update(User user) throws Exception;

    int delete(User user) throws Exception;

    int save(User user) throws Exception;

}
