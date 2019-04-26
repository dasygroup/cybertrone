package com.videodasy.AssetManager.UserServiceImpl;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videodasy.AssetManager.Dao.StaffDao;
import com.videodasy.AssetManager.domain.Staff;
import com.videodasy.AssetManager.service.StaffService;
import com.videodasy.AssetManager.service.UserService;

@Service
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	private StaffDao staffDao;
	
	@Autowired
	private UserService userService;
	
	public Staff createStaff() {
		Staff staff=new Staff();
		staff.setFirstName("abdoul");
		staff.setLastName("sulaiman");
		staff.setJobTitle("manager");
		staff.setGender("male");
		staffDao.save(staff);
		
		return staffDao.findByStaffId(staff.getStaffId());
	}

}
