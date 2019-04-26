package com.videodasy.AssetManager.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.videodasy.AssetManager.Dao.AssetDao;
import com.videodasy.AssetManager.Dao.RoleDao;
import com.videodasy.AssetManager.Dao.StaffDao;
import com.videodasy.AssetManager.Dao.VendorDao;
import com.videodasy.AssetManager.domain.Asset;
import com.videodasy.AssetManager.domain.Staff;
import com.videodasy.AssetManager.domain.User;
import com.videodasy.AssetManager.domain.Vendor;
import com.videodasy.AssetManager.domain.security.UserRole;
import com.videodasy.AssetManager.service.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService  userService;
	
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private AssetDao assetDao;
	@Autowired
	private StaffDao staffDao;
	@Autowired
	private VendorDao vendorDao;
	@RequestMapping("/")
	public String home() {
		
		return"redirect:/index";
	}
	
	@RequestMapping("/index")
	public String index(@RequestParam Map<String,String>map,HttpSession session) {
		String username=map.get("username");
		session.setAttribute("user", username);
		
		return"index";
	}
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public String signup(Model model) {
		User user=new User();
		model.addAttribute("user", user);
		
		return"signup";
	}
	
	
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public String signupPost(@ModelAttribute("user") User user, Model model) {
	
		if(userService.checkUserExists(user.getUsername(),user.getEmail())) {
			
			if(userService.checkEmailExists(user.getEmail())) {
				model.addAttribute("emailExists", true);
			}
			
			if(userService.checkUsernameExists(user.getUsername())) {
				model.addAttribute("usernameExists", true);
			}
			return"signup";
		}else {
			
			Set<UserRole>userRoles=new HashSet<>();
			userRoles.add(new UserRole(user,roleDao.findByName("ROLE_USER")));
			
			userService.createUser(user,userRoles);
			
			return"redirect:/";
		}
		
		
	}
	
	@RequestMapping("/userFront")
	public String userFront(Principal principal ,Model model, HttpSession session) {
		session.setAttribute("user", "Abdoul"); 
		User user=userService.findByUsername(principal.getName());
		List<Asset>assets=assetDao.findAll();
		List<Staff>staffs=staffDao.findAll();
		List<Vendor>vendors=vendorDao.findAll();
		int assetCount =assets.size();
		int staffcount=staffs.size();
		int vend=vendors.size();
		model.addAttribute("count", assetCount);
		model.addAttribute("stafc", staffcount);
		model.addAttribute("staf", staffs);
		model.addAttribute("vend", vend);
		return"userFront";
		
		
	}
	
	
	
}
