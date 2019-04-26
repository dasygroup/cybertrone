package com.videodasy.AssetManager.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.videodasy.AssetManager.Dao.DepartmentDao;
import com.videodasy.AssetManager.Dao.StaffDao;
import com.videodasy.AssetManager.domain.Category;
import com.videodasy.AssetManager.domain.Department;
import com.videodasy.AssetManager.domain.Staff;

@Controller
public class StaffController {

	@Autowired
	private  DepartmentDao departmentDao;
	@Autowired
	private StaffDao staffDao;
	@RequestMapping("/newStaff")
	public String showPage(Model model) {
		
		List<Department>list=departmentDao.findAll();
		List<Staff>all=(List<Staff>) staffDao.findAll();
		/*
		Department d=new Department();
		d.setName("HR");
		
		Department d1=new Department();
		d1.setName("IT");
		
		Department d2=new Department();
		d2.setName("Marketing");
		
		list.add(d1);
		list.add(d);
		list.add(d2);
	*/
		model.addAttribute("dep", list);
		model.addAttribute("data", all);
		return "NewStaff";
	
}
	
	@PostMapping("/newStaff/save")
	public String save(Staff s, @RequestParam Map<String,String>map,RedirectAttributes redirectAttributes) {
		Long staffid=Long.parseLong(map.get("id"));
		long depId=Long.parseLong(map.get("depId"));
		Department department = departmentDao.findOne(depId);
		String fname=map.get("firstname");
		String lname=map.get("lastname");
		String title=map.get("title");
		String d=map.get("dob");
		s.setStaffId(staffid);
		s.setJobTitle(title);
		s.setLastName(lname);
		s.setDepartment(department);
		s.setFirstName(fname);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date date = sdf.parse(d);
			s.setDob(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(d);
//		
		staffDao.save(s);
		redirectAttributes.addFlashAttribute("msg","Successfully Saved");
		return "redirect:/newStaff";
		
	}
	
	@GetMapping("/newStaff/delete")
	public String deleteStaff(Long id) {
		
		staffDao.delete(id);
		return "redirect:/newStaff";
		
	}
	
	@GetMapping("/newStaff/findOne")
	@ResponseBody
	public Staff findOne(Long id) {
		return  staffDao.findOne(id);
		
	}
	
	
	
	
	
	
}
