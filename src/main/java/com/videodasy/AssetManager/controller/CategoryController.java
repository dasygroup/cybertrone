package com.videodasy.AssetManager.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.videodasy.AssetManager.Dao.CategoryDao;
import com.videodasy.AssetManager.domain.Category;



@Controller
public class CategoryController {

	@Autowired
	private  CategoryDao cateDao;
	
	@GetMapping("/category")
	public String showPage(Model model , @RequestParam(defaultValue="0") int page) {
		
		model.addAttribute("data", cateDao.findAll(new PageRequest(page, 4)));
		model.addAttribute("currentPage", page);
		return "category";
	
}

	
 
	
	@PostMapping("/category/save")
	public String save(Category c, @RequestParam Map<String,String>map,RedirectAttributes redirectAttributes) {
		long categoryId=Long.parseLong(map.get("id"));
		c.setCategoryId(categoryId);
		cateDao.save(c);
		redirectAttributes.addFlashAttribute("msg","Successfully Saved");
		return "redirect:/category";
		
	}
	
	@GetMapping("/category/delete")
	public String deleteDepartment(Long id) {
		
		cateDao.delete(id);
		return "redirect:/category";
		
	}
	
	@GetMapping("/category/findOne")
	@ResponseBody
	public Category findOne(Long id) {
		return  cateDao.findOne(id);
		
	}
	
	
	

}
