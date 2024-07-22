package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDao;
import vo.ItemVo;

/**
 * Servlet implementation class SawonListAction
 */
@WebServlet("/item/list_search.do")
public class ItemListSearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// /sawon/list.do
		// /sawon/list.do?deptno=0
		// /sawon/list.do?deptno=10
		// /sawon/list.do?deptno=20
		
		//0.수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//1.parameter받기
		String search_text	= request.getParameter("search_text");
		
		
		//검색조건을 담을 맵
		Map<String, String> map = new HashMap<String, String>();
		
			map.put("search_text", search_text);
		
		//방명록 데이터 가져오기
		List<ItemVo> list = ItemDao.getInstance().selectListSearch(map);
		
		request.setAttribute("list", list);

		//Dispatcher형식으로 호출
		String forward_page = "item_list2.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}