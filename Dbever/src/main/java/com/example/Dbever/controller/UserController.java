package com.example.Dbever.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dbever.DaoService.UsersDaoService;
import com.example.Dbever.entity.Student;
import com.example.Dbever.entity.Users;
import com.example.Dbever.repository.StudentRepository;
import com.example.Dbever.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/Student")

@Tag(name = "User Controller", description = "User services")
public class UserController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private UsersDaoService usersDaoService;

	@GetMapping("/get")
	@Operation(summary = "Welcome to Application", description = "Welcome to Application")
	public String example() {
		return "Welcome to Spring application";
	}
	
	@GetMapping("/get-bean")
	@Operation(summary = "Welcome to Bean ", description = "Welcome to Bean")
	public Hellowbean HelloBean() {
		return new Hellowbean("Hello Bean");
	}
	
	@GetMapping("/get-Users")
	@Operation(summary = "get All Users", description = "Get All users")
	public List<Users> getAllUsers() {
		return usersDaoService.getAllUsers();
	}
	
	@PostMapping("/create-Users")
	@Operation(summary = "create Users", description = "Create users")
	public void createUser(@RequestBody Users user) {
		 usersDaoService.creatUser(user);
		 System.out.println("User added successfully to the list...");
	}

	@PostMapping("/insertStudent")
	@Operation(summary = "Insert Student Record into db", description = "Insert Student Record into db")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		Student createdStudent = studentService.saveStudent(student);
		return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
	}

	@GetMapping("/getStudentById")
	@Operation(summary = "Get Student record y id", description = "Get Student record y id")
	public Student getStudent(@RequestParam Long id) {
		Optional<Student> byId = studentRepository.findById(id);
		if (byId.isPresent()) {
			return byId.get();
		}else {
			return null;
		}
	}
	
	@PutMapping("/updateStudentByName")
	@Operation(summary = "Update Student record", description = "Update Student record")
	public Student updateStudent(@RequestParam String name) {
		Student byName = studentService.findByName(name);
		return byName;
		
	}
	
}
