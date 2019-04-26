package com.videodasy.AssetManager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.videodasy.AssetManager.Dao.AssetDao;
import com.videodasy.AssetManager.Dao.CategoryDao;
import com.videodasy.AssetManager.Dao.StaffDao;
import com.videodasy.AssetManager.Dao.VendorDao;
import com.videodasy.AssetManager.domain.Asset;
import com.videodasy.AssetManager.domain.Category;
import com.videodasy.AssetManager.domain.Staff;
import com.videodasy.AssetManager.domain.Vendor;

@Controller
public class AssignController {

	@Autowired
	private CategoryDao cateDao;
	@Autowired
	private StaffDao staffDao;
	@Autowired
	private VendorDao vendorDao;
	
	@Autowired
	private AssetDao assetDao;
	
	@RequestMapping("/newAssign")
	public String showPage(Model model) {
		
		List<Category>list=cateDao.findAll();
		List<Staff>all=staffDao.findAll();
		List<Vendor>vendorlist=vendorDao.findAll();
		List<Asset>assets=assetDao.findAll();
		
		
		model.addAttribute("cat", list);
		model.addAttribute("vend", vendorlist);
		model.addAttribute("data", all);
		model.addAttribute("asset", assets);
		return "Assign";
	
}
	
	@PostMapping("/newAssign/save")
	public String save(Asset as, @RequestParam Map<String,String>map,RedirectAttributes redirectAttributes) {
		long assetid=Long.parseLong(map.get("assetId"));
		long staffid=Long.parseLong(map.get("staffId"));
		
	    Staff s=staffDao.findOne(staffid);
	    Asset a=assetDao.findOne(assetid);
	   
		a.setStaff(s);
		assetDao.save(a);
		redirectAttributes.addFlashAttribute("msg","Successfully Saved");
		return "redirect:/newAssign";
		
	}
	
}
