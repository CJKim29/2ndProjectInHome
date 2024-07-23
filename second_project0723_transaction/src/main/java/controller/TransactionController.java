package controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.TransactionDao;
import vo.TransactionVo;

@Controller
@RequestMapping("/transaction/")
public class TransactionController {
	
	@Autowired
	TransactionDao transaction_dao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	ServletContext application;

	public TransactionController() {
		// TODO Auto-generated constructor stub
		//System.out.println("--transactionController()--");
	}
	
	@RequestMapping("list.do")
	public String list(Model model) {
		
		List<TransactionVo> list = transaction_dao.selectList();
		
		//request binding
		model.addAttribute("list", list);
		
		return "/transaction/transaction";
	}
	
	@RequestMapping("transaction_charge.do")
	public String charge(int charge_point, Model model) {
		
		List<TransactionVo> list = transaction_dao.updateIncPoint(charge_point);
		
		//request binding
		model.addAttribute("list", list);
		
		return "redirect:list.do";
	}
	
	@RequestMapping("transaction.do")
	public String transaction(int transaction_point, Model model) {
		
		List<TransactionVo> list = transaction_dao.transaction(transaction_point);
		
		//request binding
		model.addAttribute("list", list);
		
		return "redirect:list.do";
	}
	
}