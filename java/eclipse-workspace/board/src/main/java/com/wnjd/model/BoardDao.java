package com.wnjd.model;


import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class BoardDao {
	private static SqlSessionFactory sessionFactory = null;

	public static SqlSessionFactory getInstance() {
		if (sessionFactory == null) {
			try {
				String resource = "mybatis-config.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
	
	public List<NoticeboardDto> selectAllArticles() {
		sessionFactory = getInstance();
		SqlSession session = sessionFactory.openSession();
		List<NoticeboardDto> articleList = session.selectList("mapper.notice.selectAllArticles");
		session.close();
		return articleList;
	}
	
	public void insertArticle(NoticeboardDto article) {
		sessionFactory = getInstance();
		SqlSession session = sessionFactory.openSession();
		//MyBatis 쿼리문 호출
		session.insert("mapper.notice.insertArticle", article);
		//데이터베이스 데이터 변경하는 작업은 session.commit(); 무조건 하기
		session.commit();
	}
	
	public NoticeboardDto selectArticle(int articleNo) {
		sessionFactory = getInstance();
		SqlSession session = sessionFactory.openSession();
		NoticeboardDto article = session.selectOne("mapper.notice.selectArticle", articleNo);
		session.close();
		return article;
	}
	
	public void updateArticle(NoticeboardDto article) {
		sessionFactory = getInstance();
		SqlSession session = sessionFactory.openSession();
		session.update("mapper.notice.updateArticle", article);
		session.commit();
	}
	
	public void deleteArticle (int articleNo) {
		sessionFactory = getInstance();
	    SqlSession session = sessionFactory.openSession();
	    session.delete("mapper.notice.deleteArticle", articleNo);
	    session.commit();
	}
}
