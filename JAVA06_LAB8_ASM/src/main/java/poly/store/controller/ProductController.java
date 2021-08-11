package poly.store.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.store.entity.Report;
import poly.store.entity.Product;
import poly.store.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;

	@RequestMapping("/product/list")
	public String list(Model model, @RequestParam("cid") Optional<Integer> cid) {
		System.out.println(cid);

		if (cid.isPresent()) {

			List<Product> list = productService.findByCategoryId(cid.get());

			model.addAttribute("items", list);
		} else {
			List<Product> list = productService.findAll();
			model.addAttribute("items", list);

			List<Report> items = productService.getInventoryByOrder();
			model.addAttribute("hotitems", items);
		}

		return "product/list";
	}

	@RequestMapping("/product/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Product item = productService.findById(id);
		model.addAttribute("item", item);
		return "product/detail";
	}

	@RequestMapping("/product/search")
	public String search(Model model, @RequestParam("name") String id) {
		System.out.println("Name: " + id);
		List<Product> list = productService.findByName(id);
		model.addAttribute("items", list);

		List<Report> items = productService.getInventoryByOrder();
		model.addAttribute("hotitems", items);
		return "product/list";
	}

	@RequestMapping("/product/giamDan")
	public String giamDan(Model model) {
		List<Product> list = productService.sortDesc();
		System.out.println("giảm dần");
		model.addAttribute("items", list);

		List<Report> items = productService.getInventoryByOrder();
		model.addAttribute("hotitems", items);
		return "product/list";
	}

	@RequestMapping("/product/tangDan")
	public String tangDan(Model model) {
		List<Product> list = productService.sortAsc();
		System.out.println("giảm dần");
		model.addAttribute("items", list);

		List<Report> items = productService.getInventoryByOrder();
		model.addAttribute("hotitems", items);
		return "product/list";
	}

	@RequestMapping("/product/searchByPrice")
	public String searchByPrice(Model model, @RequestParam("min") Double min, @RequestParam("max") Double max) {
		System.out.println("Lọc giá");
		List<Product> list = productService.searchByPrice(min, max);
		model.addAttribute("items", list);

		List<Report> items = productService.getInventoryByOrder();
		model.addAttribute("hotitems", items);
		return "product/list";
	}

}
