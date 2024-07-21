package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.ItemVo;

public class ItemDao {
	
	//Mybatis객체 선언
	SqlSessionFactory factory;
	
	// single-ton pattern : 객체 1개만 생성해서 이용하자
	static ItemDao single = null;

	public static ItemDao getInstance() {

		// 없으면 생성해라
		if (single == null)
			single = new ItemDao();

		return single;
	}

	// 외부에서 객체 생성하지 말아라 -> 다른 클래스에서 Connection conn = new DBService().getConnection(); 적기만 해도 에러
	private ItemDao() {
		//Mybatis 객체정보 얻어온다
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	public List<ItemVo> selectList() {

		List<ItemVo> list = null;

		//1.SqlSession 얻어오기(Mybatis수행객체)
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행                  namespace.mapper_id
		list = sqlSession.selectList("item.item_list");
		
		//3.닫기
		sqlSession.close();

		return list;
	}

	public List<ItemVo> selectListFromCategory(String category) {
		
		List<ItemVo> list = null;

		//1.SqlSession 얻어오기(Mybatis수행객체)
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행                  namespace.mapper_id
		list = sqlSession.selectList("item.item_list_category", category);
		
		//3.닫기
		sqlSession.close();

		return list;
	}

	public List<ItemVo> selectListFromGrade(String grade) {

		List<ItemVo> list = null;

		//1.SqlSession 얻어오기(Mybatis수행객체)
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행                  namespace.mapper_id
		list = sqlSession.selectList("item.item_list_grade", grade);
		
		//3.닫기
		sqlSession.close();

		return list;
	}

	
	public List<ItemVo> selectList(Map<String, Object> map) {

		List<ItemVo> list = null;
		
		//1.SqlSession얻어오기(Mybatis수행객체)
		SqlSession sqlSession = factory.openSession();

		//2.작업수행                  namespace.mapperId         parameter
        list = sqlSession.selectList("item.item_list_condition" , map);
        
		//3.닫기
		sqlSession.close();

		return list;
	}

	public List<ItemVo> selectListSearch(Map<String, String> map) {
		List<ItemVo> list = null;

		//1.SqlSession얻어오기
		SqlSession sqlSession = factory.openSession();	// Connection획득
		
		
		//2.작업수행				namespace
		list = sqlSession.selectList("item.item_list_search", map);
		
		//3.닫기: conn.close()과정포함
		sqlSession.close();

		return list;
	}//end:selectList(map)
	
}