package com.videodasy.AssetManager.controller;


import java.util.Date;
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
import com.videodasy.AssetManager.domain.Department;
import com.videodasy.AssetManager.domain.Staff;
import com.videodasy.AssetManager.domain.Vendor;

@Controller
public class AssetController {

	@Autowired
	private CategoryDao cateDao;
	@Autowired
	private StaffDao staffDao;
	@Autowired
	private VendorDao vendorDao;
	
	@Autowired
	private AssetDao assetDao;
	@Autowired
	private TemplateEngine templateEngine;
	@RequestMapping("/newAsset")
	public String showPage(Model model) {
		
		List<Category>list=cateDao.findAll();
		List<Staff>all=staffDao.findAll();
		List<Vendor>vendorlist=vendorDao.findAll();
		List<Asset>assets=assetDao.findAll();
		
		
		
		model.addAttribute("cat", list);
		model.addAttribute("vend", vendorlist);
		model.addAttribute("data", all);
		model.addAttribute("asset", assets);
		return "NewAsset";
	
}
	
	@PostMapping("/newAsset/save")
	public String save(Asset as, @RequestParam Map<String,String>map,RedirectAttributes redirectAttributes) {
		long assetid=Long.parseLong(map.get("id"));
		long catId=Long.parseLong(map.get("categoryId"));
		long vendId=Long.parseLong(map.get("vendorId"));
		
		Category category = cateDao.findOne(catId);
		Vendor vend=vendorDao.findOne(vendId);
		
		String type=map.get("type");
		String brand=map.get("brand");
		String des=map.get("description");
		String status=map.get("status");
		as.setDescription(des);
		as.setAssetId(assetid);
		as.setAssetType(type);
		as.setBrand(brand);
		as.setStatus(status);
		as.setCategory(category);
		as.setVendor(vend);
	
		
		assetDao.save(as);
		redirectAttributes.addFlashAttribute("msg","Successfully Saved");
		return "redirect:/newAsset";
		
	}
	
	@GetMapping("/newAsset/delete")
	public String deleteStaff(Long id) {
		
		assetDao.delete(id);
		return "redirect:/newAsset";
		
	}
	
	@GetMapping("/newAsset/findOne")
	@ResponseBody
	public Asset findOne(Long id) {
		return  assetDao.findOne(id);
		
	}
	
	@GetMapping("/printReport")
	public void report() {
		
		List<Asset>assets=assetDao.findAll();
		Context c=new Context();
		c.setVariable("asset", assets);
		String text= templateEngine.process("Report", c);
	
	}
	
	
}
