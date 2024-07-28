package controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.RegItemDao;
import dao.TransactionDao;
import vo.RegItemVo;
import vo.TransactionVo;

@Controller
@RequestMapping("/transaction/")
public class TransactionController {
	
	@Autowired
	TransactionDao transaction_dao;
	
	@Autowired
	RegItemDao regitem_dao;
	
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
	
	@RequestMapping("transaction_list.do")
	public String transaction_list(@RequestParam(name = "reg_idx", defaultValue = "0") int reg_idx, Model model) {
		
		List<TransactionVo> list = transaction_dao.selectListTran();
		
		List<RegItemVo> list2 = regitem_dao.selectOneReg(reg_idx);
		
		//request binding
		model.addAttribute("list", list);
		model.addAttribute("list2", list2);
		
		return "/transaction/transaction";
	}
	
	@RequestMapping("auction_list.do")
	public String auction_list(@RequestParam(name = "reg_idx", defaultValue = "0") int reg_idx, Model model) {
		
		List<TransactionVo> list = transaction_dao.selectListTran();
		
		List<RegItemVo> list2 = regitem_dao.selectOneReg(reg_idx);
		
		//request binding
		model.addAttribute("list", list);
		model.addAttribute("list2", list2);
		
		return "/transaction/auction";
	}
	
	@RequestMapping("transaction_charge.do")
	public String charge(int charge_point, Model model) {
		
		List<TransactionVo> list = transaction_dao.updateIncPoint(charge_point);
		
		//request binding
		model.addAttribute("list", list);
		
		return "redirect:transaction_list.do";
	}
	
	@RequestMapping("transaction_charge_auction.do")
	public String transaction_charge_auction(int charge_point, Model model) {
		
		List<TransactionVo> list = transaction_dao.updateIncPoint(charge_point);
		
		//request binding
		model.addAttribute("list", list);
		
		return "redirect:auction_list.do";
	}
	
	@RequestMapping("transaction.do")
	public String transaction(int transaction_point, Model model) {
		
		List<TransactionVo> list = transaction_dao.transaction(transaction_point);
		
		//request binding
		model.addAttribute("list", list);
		
		return "redirect:transaction_list.do";
	}
	
	@RequestMapping("transaction_auction.do")
	public String transaction_auction(int transaction_point, Model model) {
		
		List<TransactionVo> list = transaction_dao.transactionAuction(transaction_point);
		
		//request binding
		model.addAttribute("list", list);
		
		return "redirect:auction_list.do";
	}
	
	@RequestMapping("bidding_auction.do")
	public String bidding_auction(int bidding_point, Model model) {
		
		List<RegItemVo> list = regitem_dao.updateIncBiddingPoint(bidding_point);
		
		//request binding
		model.addAttribute("list", list);
		
		return "redirect:auction_list.do";
	}
	
	@RequestMapping("bidding_auction_button.do")
	public String bidding_auction_button(int bidding_point_button, Model model) {
		
		List<RegItemVo> list = regitem_dao.updateIncBiddingPointButton(bidding_point_button);
		
		//request binding
		model.addAttribute("list", list);
		
		return "redirect:auction_list.do";
	}
}