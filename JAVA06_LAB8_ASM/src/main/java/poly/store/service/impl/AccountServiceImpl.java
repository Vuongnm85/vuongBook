package poly.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.AccountDAO;
import poly.store.entity.Account;
import poly.store.service.*;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountDAO adao;

	@Override
	public Account findById(String username) {
		// TODO Auto-generated method stub
		return adao.findById(username).get();
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return adao.findAll();
	}

	@Override
	public List<Account> getAdministrators() {
		// TODO Auto-generated method stub
		return adao.getAdministrators();
	}

	@Override
	public Account create(Account account) {
		// TODO Auto-generated method stub
		return adao.save(account);
	}

	@Override
	public Account update(Account account) {
		// TODO Auto-generated method stub
		return adao.save(account);
	}

	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		adao.deleteById(username);
	}

}
