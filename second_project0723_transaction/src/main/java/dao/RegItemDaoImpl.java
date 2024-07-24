package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.RegItemVo;

@Repository("regitem_dao")
public class RegItemDaoImpl implements RegItemDao {

	@Autowired
	SqlSession sqlSession;
	
	
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public List<RegItemVo> selectList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("regitem.reg_item_list");
	}

}
