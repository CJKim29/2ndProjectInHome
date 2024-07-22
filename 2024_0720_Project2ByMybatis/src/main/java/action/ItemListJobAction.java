package action;

import java.io.IOException;
import java.util.List;

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
@WebServlet("/item/list_grade.do")
public class ItemListJobAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// /sawon/list_job.do
		// /sawon/list_job.do?sajob=all
		// /sawon/list_job.do?sajob=부장
		// /sawon/list_job.do?sajob=과장
		
		//0.수신인코딩
		request.setCharacterEncoding("utf-8");
		
		String grade = request.getParameter("grade");
		
		if(grade==null || grade.isEmpty()) {	// sajob.isEmpty() <==> sajob.equals("")
			grade = "all";
		}
		
		
		
		//사원목록 가져오기
		List<ItemVo> list = null;
		
		if(grade.equals("all")) {
			//전체조회
			list = ItemDao.getInstance().selectList();
			
		} else {
			//직급별 조회
			list = ItemDao.getInstance().selectListFromGrade(grade);
		}
		
		//request binding
		request.setAttribute("list", list);

		//Dispatcher형식으로 호출
		String forward_page = "item_list2.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}