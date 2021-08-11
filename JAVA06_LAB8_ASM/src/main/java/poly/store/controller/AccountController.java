package poly.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.store.dao.AccountDAO;
import poly.store.entity.Account;

@CrossOrigin("*")
@Controller
public class AccountController {
	@Autowired
	AccountDAO dao;
	
	@RequestMapping("/account/create")
	public String create(Account item, Model model) {
		dao.save(item);
		model.addAttribute("message", "Đăng ký thành công!");
		return "/security/login";
	}
	
}
