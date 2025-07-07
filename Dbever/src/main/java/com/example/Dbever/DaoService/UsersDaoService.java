package com.example.Dbever.DaoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Dbever.entity.Users;


@Service
public class UsersDaoService {
	
	private static List<Users> users =new ArrayList<>();
	
	static {
		users.add(new Users(1,"venky",LocalDate.now().minusYears(30)));
		users.add(new Users(2,"ram",LocalDate.now().minusYears(10)));
		users.add(new Users(3,"samaptg",LocalDate.now().minusYears(2)));
	}
	
	
	public List<Users> getAllUsers(){
		return users;
	}


	public void creatUser(Users user) {
	    users.add(user);
	}
	
	

}
