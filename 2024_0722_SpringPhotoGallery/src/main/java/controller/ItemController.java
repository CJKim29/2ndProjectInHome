package controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.ItemDao;
import vo.ItemVo;
import vo.MemberVo;

@Controller
@RequestMapping("/item/")
public class ItemController {
	
	@Autowired
	ItemDao item_dao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	ServletContext application;

	public ItemController() {
		// TODO Auto-generated constructor stub
		System.out.println("--ItemController()--");
	}
	
	// /photo/list.do
	// /photo/list.do?page=1
	@RequestMapping("list.do")
	public String list(Model model) {
		
		
		List<ItemVo> list = item_dao.selectList();
		
		//request binding
		model.addAttribute("list", list);
		
		return "/item/item_list";
	}
	
	
	
}