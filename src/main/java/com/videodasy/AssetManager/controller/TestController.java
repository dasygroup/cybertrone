package com.videodasy.AssetManager.controller;



import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.videodasy.AssetManager.domain.Staff;

@RestController
@RequestMapping("/staff")
public class TestController {
	
	
	@RequestMapping(value="/byId/{id}",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Object find_staff_byID(@PathVariable("id")String id) throws Exception { 
		Staff staff=new Staff();
		/*ObjectMapper mapper=new ObjectMapper();
		String m=mapper.writeValueAsString(staff);
		
		return m;
		*/
		
		return staff;
	}
	

}
