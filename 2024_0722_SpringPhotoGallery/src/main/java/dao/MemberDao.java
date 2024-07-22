package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.MemberVo;

public class MemberDao {
	
	SqlSession sqlSession;

	//Setter Injection
	public void setSqlSession(SqlSession sqlSession) {
		
		this.sqlSession = sqlSession;	//SqlSessionTemplate의 interface
	}
	
	//전체조회
		public List<MemberVo> selectList() {

			return sqlSession.selectList("member.member_list");
		}//end:select()
		
		// mem_idx에 해당되는 1건의 정보를 얻어온다
		public MemberVo selectOne(int mem_idx) {

			return sqlSession.selectOne("member.member_one_idx", mem_idx);
		}//end:selectOne()
		
		// mem_id에 해당되는 1건의 정보를 얻어온다
		public MemberVo selectOne(String mem_id) {

			return sqlSession.selectOne("member.member_one_id", mem_id);
		}//end:selectOne()

		public int insert(MemberVo vo) {

			return sqlSession.insert("member.member_insert", vo);
		}//end:insert()

		public int delete(int mem_idx) {

			return sqlSession.delete("member.member_delete", mem_idx);
		}//end:delete()

		public int update(MemberVo vo) {

			return sqlSession.update("member.member_update", vo);
		}//end:update()
	
}