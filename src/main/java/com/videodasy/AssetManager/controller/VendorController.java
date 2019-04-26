package com.videodasy.AssetManager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.videodasy.AssetManager.Dao.VendorDao;
import com.videodasy.AssetManager.domain.Department;
import com.videodasy.AssetManager.domain.Vendor;






@Controller
public class VendorController {
	
	@Autowired
	private VendorDao vendorDao;
	@GetMapping("/vendor")
	public String showPage(Model model ,@RequestParam(defaultValue="0") int page) {
		
		model.addAttribute("data", vendorDao.findAll(new PageRequest(page, 4)));
		model.addAttribute("currentPage", page);
		
		return "NewVendor";
	
}	
	
@PostMapping("/vendor/save")
	
	public String save(Vendor v, @RequestParam Map<String,String>map) {
		long vendorId=Long.parseLong(map.get("id"));
		String fname=map.get("firstname");
		String lname=map.get("lastname");
		v.setFirstName(fname);
		v.setVendorId(vendorId);
		v.setLastName(lname);
		vendorDao.save(v);
		return "redirect:/vendor";
		
	}


@GetMapping("/vendor/delete")
public String deleteVendor(Long id) {
	
	vendorDao.delete(id);
	return "redirect:/vendor";
	
}

@GetMapping("/vendor/findOne")
@ResponseBody
public Vendor findOne(Long id) {
	return  vendorDao.findOne(id);
	
}

@GetMapping("/vendor/findAll")
public List<Vendor> findAll() {
	return  vendorDao.findAll();
	
}


	
	
	
}
