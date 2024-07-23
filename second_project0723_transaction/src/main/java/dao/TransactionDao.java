package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.ItemVo;
import vo.TransactionVo;

public class TransactionDao {
	
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<TransactionVo> selectList() {

		return sqlSession.selectList("transaction.transaction_list");
	}

	public List<TransactionVo> updateIncPoint(int charge_point) {

		return sqlSession.selectList("transaction.updateInc_point", charge_point);
	}

	public List<TransactionVo> transaction(int transaction_point) {

		return sqlSession.selectList("transaction.transaction_point", transaction_point);
	}

	
}