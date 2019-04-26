package com.videodasy.AssetManager.UserServiceImpl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.videodasy.AssetManager.Dao.RoleDao;
import com.videodasy.AssetManager.Dao.UserDao;
import com.videodasy.AssetManager.domain.User;
import com.videodasy.AssetManager.domain.security.UserRole;
import com.videodasy.AssetManager.service.StaffService;
import com.videodasy.AssetManager.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	
	private static final Logger LOG=LoggerFactory.getLogger(UserService.class);
	@Autowired
	   UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private StaffService staffService;
		
		public void save(User user) {
			userDao.save(user);
		}
		
		public User findByUsername(String username) {
			return userDao.findByUsername(username);
		}
		

		public User findByEmail(String email) {
		return	userDao.findByEmail(email);
		}
		
		
		
		public User createUser(User user,Set<UserRole>userRoles) {
			
			User localUser =userDao.findByUsername(user.getUsername());
			
			if(localUser!=null) {
				LOG.info("User with username{} already exist. Nothing will be done.",user.getUsername());
			}else {
				
				String encryptedPassword=passwordEncoder.encode(user.getPassword());
				user.setPassword(encryptedPassword);
				
				for(UserRole ur:userRoles) {
					roleDao.save(ur.getRole());
				}
				user.getUserRoles().addAll(userRoles);
				user.setStaff(staffService.createStaff());
				
				localUser=userDao.save(user);
			}
			return localUser;
		}
		
		
		
		public boolean checkUserExists(String username,String email) {
			if(checkUsernameExists(username)||checkEmailExists(email)) {
				return true;
			}else {
				return false;
			}
		}
		
		public boolean checkUsernameExists(String username) {
			if(null!=findByUsername(username)) {
				return true;
			}
			return false;
		}
		
		public boolean checkEmailExists(String email) {
			if(null!=findByUsername(email)) {
				return true;
			}
			return false;
		}
}
