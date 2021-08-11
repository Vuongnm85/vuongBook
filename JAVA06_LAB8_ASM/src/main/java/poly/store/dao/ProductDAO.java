package poly.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.store.entity.Product;
import poly.store.entity.Report;

public interface ProductDAO extends JpaRepository<Product, Integer> {

	@Query("SELECT p FROM Product p WHERE p.category.id=?1")
	List<Product> findByCategoryId(Integer cid);

	@Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
	List<Product> findByName(String id);

	@Query("SELECT p FROM Product p order by p.price DESC")
	List<Product> sortDesc();

	@Query("SELECT p FROM Product p order by p.price ASC")
	List<Product> sortAsc();

	@Query("SELECT p FROM Product p WHERE p.price BETWEEN  ?1 AND ?2")
	List<Product> searchByPrice(Double min, Double max);

	// so san pham ban nhieu nhat
	@Query("SELECT new Report(o.product, sum(o.price), sum(o.quantity)) " 
	        + " FROM OrderDetail o "
			+ " GROUP BY o.product"
			+ " HAVING sum(o.quantity) > 20" 
	        + " ORDER BY sum(o.quantity) DESC")
	List<Report> getInventoryByOrder();
	
	@Query("SELECT new Report(o.product, sum(o.price), sum(o.quantity)) " 
	        + " FROM OrderDetail o "
			+ " GROUP BY o.product"
	        + " ORDER BY sum(o.quantity) DESC")
	List<Report> getInventoryByOrder1();
	
	@Query("SELECT new Report(o.category, sum(o.price), count(o)) " + " FROM Product o " + " GROUP BY o.category"
			+ " ORDER BY sum(o.price) DESC")
	List<Report> getInventoryByCategory();
}
