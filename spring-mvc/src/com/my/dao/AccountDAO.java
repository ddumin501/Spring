package com.my.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AccountDAO {

	@Autowired
	private SqlSession sqlSession;

	@Transactional(propagation = Propagation.REQUIRED)
	public void deposit() {

		HashMap<String, Object> map = new HashMap<>();
		//map.put("no", "102");
		map.put("no", "999");
		map.put("amount", 10);
		// 내부에서 unchecked exception발생 -> 내부 자동 rollback
		int rowCnt2 = sqlSession.update("com.my.vo.Account.deposit", map);
		if (rowCnt2 == 0) {
			throw new RuntimeException("입금오류");
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void withdraw() {

		HashMap<String, Object> map = new HashMap<>();
		map.put("no", "101");
		map.put("amount", 10);
		int rowCnt1 = sqlSession.update("com.my.vo.Account.withdraw", map);
		if (rowCnt1 == 0) {
			throw new RuntimeException("출금오류");
		}
	}

}
