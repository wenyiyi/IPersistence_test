package com.wyd;

import com.wyd.dao.IUserDao;
import com.wyd.io.Resources;
import com.wyd.pojo.User;
import com.wyd.sqlSession.SqlSession;
import com.wyd.sqlSession.SqlSessionFactory;
import com.wyd.sqlSession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class IPersistenceTest {

    @Test
    public void test() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 生成一个代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> users = userDao.selectList();
        users.forEach(user-> System.out.println(user));

        User user = new User();
        user.setId(1);
        user.setUsername("wyd");
        User user1 = userDao.selectOne(user);
        System.out.println(user1);

    }
    
}
