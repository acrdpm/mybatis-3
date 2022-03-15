package org.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.test.entity.Blog;
import org.test.mapper.BlogMapper;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {

  public static void main(String[] args) throws IOException {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {
      BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
      Blog blog = mapper.selectByBlogId(1);
      System.out.println(blog);
    } finally {
      sqlSession.close();
    }

  }
}
