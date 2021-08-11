package poly.store.service;

import java.util.List;

import poly.store.entity.Product;
import poly.store.entity.Report;

public interface ProductService {
	List<Product> findAll();

	Product findById(Integer id);

	List<Product> findByCategoryId(Integer cid);

	Product create(Product product);

	Product update(Product product);

	void delete(Integer id);

	List<Product> findByName(String id);

	List<Product> sortDesc();

	List<Product> sortAsc();

	List<Product> searchByPrice(Double min, Double max);

	List<Report> getInventoryByOrder();

	List<Report> getInventoryByCategory();

	List<Report> getInventoryByOrder1();
}
