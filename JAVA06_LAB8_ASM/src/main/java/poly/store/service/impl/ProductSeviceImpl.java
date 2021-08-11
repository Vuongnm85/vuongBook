package poly.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.ProductDAO;
import poly.store.entity.Product;
import poly.store.entity.Report;
import poly.store.service.ProductService;

@Service
public class ProductSeviceImpl implements ProductService {
	@Autowired(required=true)
	ProductDAO pdao;

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return pdao.findAll();
	}

	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return pdao.findById(id).get();
	}

	@Override
	public List<Product> findByCategoryId(Integer cid) {
		// TODO Auto-generated method stub
		return pdao.findByCategoryId(cid);
	}

	
	public Product create(Product product) {
		// TODO Auto-generated method stub
		return pdao.save(product);
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return pdao.save(product);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		 pdao.deleteById(id);
	}

	@Override
	public List<Product> findByName(String id) {
		// TODO Auto-generated method stub
		return pdao.findByName(id);
	}

	@Override
	public List<Product> sortDesc() {
		// TODO Auto-generated method stub
		return pdao.sortDesc();
	}

	@Override
	public List<Product> sortAsc() {
		// TODO Auto-generated method stub
		return pdao.sortAsc();
	}

	@Override
	public List<Product> searchByPrice(Double min, Double max) {
		// TODO Auto-generated method stub
		return pdao.searchByPrice(min,max);
	}

	@Override
	public List<Report> getInventoryByOrder() {
		// TODO Auto-generated method stub
		return pdao.getInventoryByOrder();
	}

	@Override
	public List<Report> getInventoryByCategory() {
		// TODO Auto-generated method stub
		return pdao.getInventoryByCategory();
	}

	@Override
	public List<Report> getInventoryByOrder1() {
		// TODO Auto-generated method stub
		return pdao.getInventoryByOrder1();
	}



}
