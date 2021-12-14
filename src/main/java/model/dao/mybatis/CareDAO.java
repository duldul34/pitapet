package model.dao.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import model.dao.mybatis.mapper.CareMapper;
import model.dto.Care;

public class CareDAO {
	private SqlSessionFactory sqlSessionFactory;
	
	public CareDAO() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	/* 보호자 및 특정 돌보미의 돌봄 스케쥴 조회 */
	public List<Care> findCareSchedules(String memberId, String sitterId) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			List<Care> careList = sqlSession.getMapper(CareMapper.class).findCareSchedules(memberId, sitterId);
			return careList;
		} finally {
			sqlSession.close();
		}
	}
	
	/* 돌봄 예약내역 조회 */
	public Care findReservation(int careId) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			Care care = sqlSession.getMapper(CareMapper.class).findReservation(careId);
			return care;
		} finally {
			sqlSession.close();
		}
	}
	
	/* 보호자-돌보미 간 돌봄 완료 내역 반환 */
	public List<Care> findCareList(String memberId, String sitterId) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			List<Care> careList = sqlSession.getMapper(CareMapper.class).findCareList(memberId, sitterId);
			return careList;
		} finally {
			sqlSession.close();
		}
	}
	
	/* 돌봄 내역 생성 */
	public int createCare(Care care) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			return sqlSession.getMapper(CareMapper.class).createCare(care);
		} finally {
			sqlSession.close();
		}
	}
	
	public int deleteCare(int careId) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			return sqlSession.getMapper(CareMapper.class).deleteCare(careId);
		} finally {
			sqlSession.close();
		}
	}
	
	public String getCheckInfo(String rcvId) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			String check = sqlSession.getMapper(CareMapper.class).getCheckInfo(rcvId);
			return check;
		} finally {
			sqlSession.close();
		}
	}
}
