package com.sbs.board;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sbs.board.mapper.ArticleMapper;

public class MyBatis {
	
	String resource = "com/sbs/config/mybatis-config.xml";
	private SqlSessionFactory sqlSessionFactory;
	
	public MyBatis() {
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	public void getAllArticles() {
		
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		List<Article> articles = mapper.getAllArticles();
		
		for(Article a : articles) {
			System.out.println(a.getTitle());
			System.out.println(a.getBody());
		}
	}
}
