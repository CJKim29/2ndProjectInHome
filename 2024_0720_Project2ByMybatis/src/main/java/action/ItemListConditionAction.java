package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.ItemDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.ItemVo;

/**
 * Servlet implementation class SawonListConditionAction
 */
@WebServlet("/item/list_condition.do")
public class ItemListConditionAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// item/list_condition.do
		// item/list_condition.do?category1=무기&category2=방어구&grade=등급
		
		//0.수신인코딩
		request.setCharacterEncoding("utf-8");
		
		String category1 = request.getParameter("category1");
		if(category1==null) category1="all";
		
		String category2 = request.getParameter("category2");
		if(category2==null) category2="all";
		
		String grade = request.getParameter("grade");
		if(grade==null) grade="all";
		
		
		//검색할 조건을 전달할 Map
		Map<String, Object> map = new HashMap<String, Object>();
		
		//전체가 아니면
		if(!category1.equals("all")) { 
			map.put("category1", category1);
		}

		//전체가 아니면
		if(!category2.equals("all")) { 
			map.put("category2", category2);
		}
		
		//전체가 아니면
		if(!grade.equals("all")) { 
			map.put("grade", grade);
		}	
		
		//사원목록 가져오기
		List<ItemVo> list = ItemDao.getInstance().selectList(map);
		
		
		//request binding
		request.setAttribute("list", list);

		//Dispatcher형식으로 호출
		String forward_page = "item_list2.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}