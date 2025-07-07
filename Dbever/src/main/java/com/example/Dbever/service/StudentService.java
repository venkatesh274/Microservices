package com.example.Dbever.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dbever.entity.Student;
import com.example.Dbever.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

	public Student findByName(String name) {
		Student updateStudent = studentRepository.findByName(name);
		updateStudent.setBranch("engineer");
		saveStudent(updateStudent);
		return updateStudent;
		
	}
}