package com.videodasy.AssetManager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.videodasy.AssetManager.Dao.DepartmentDao;
import com.videodasy.AssetManager.domain.Department;


@Controller
public class DepartmentController {

	@Autowired
	private  DepartmentDao departmentDao;

	@GetMapping("/department")
	public String showPage(Model model , @RequestParam(defaultValue="0") int page) {
		
		model.addAttribute("data", departmentDao.findAll(new PageRequest(page, 4)));
		model.addAttribute("currentPage", page);
		return "department";
	
}
	
	
	@PostMapping("/department/save")
	
	public String save(Department d, @RequestParam Map<String,String>map) {
		long deptId=Long.parseLong(map.get("id"));
		d.setDeptId(deptId);
		departmentDao.save(d);
		return "redirect:/department";
		
	}
	
	@GetMapping("/department/delete")
	public String deleteDepartment(Long id) {
		
		departmentDao.delete(id);
		return "redirect:/department";
		
	}
	
	@GetMapping("/department/findOne")
	@ResponseBody
	public Department findOne(Long id) {
		return  departmentDao.findOne(id);
		
	}
	
	@GetMapping("/department/findAll")
	public List<Department> findAll() {
		return  departmentDao.findAll();
		
	}
	
	
	
	
	
}
