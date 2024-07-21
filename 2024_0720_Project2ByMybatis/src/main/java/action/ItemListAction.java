package action;

import java.io.IOException;
import java.util.List;

import dao.ItemDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.ItemVo;

/**
 * Servlet implementation class SawonListAction
 */
@WebServlet("/item/list.do")
public class ItemListAction extends HttpServlet {
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
		
		/*
		 * int category = 0;
		 * 
		 * try { category = Integer.parseInt(request.getParameter("category")); } catch
		 * (Exception e) { // TODO: handle exception }
		 */
		
		String category = request.getParameter("category");
		
		if(category==null || category.isEmpty()) {	// sajob.isEmpty() <==> sajob.equals("")
			category = "all";
		}
		
		//사원목록 가져오기
		List<ItemVo> list = null;
		
		
		if(category.equals("all")) {
			//전체조회
			list = ItemDao.getInstance().selectList();
			
		} else {
			//직급별 조회
			list = ItemDao.getInstance().selectListFromCategory(category);
		}
		
		/*
		 * if(category==0) { //전체조회 list = ItemDao.getInstance().selectList();
		 * 
		 * } else { //부서별 조회 list =
		 * ItemDao.getInstance().selectListFromDeptno(category); }
		 */
		
		//request binding
		request.setAttribute("list", list);

		//Dispatcher형식으로 호출
		String forward_page = "item_list2.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}