package com.manytomany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.manytomany.entity.Project;
import com.manytomany.entity.Student;
import com.manytomany.repository.ProjectRepository;
import com.manytomany.repository.StudentRepository;

@SpringBootApplication
public class StudentCourseRealtionApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StudentCourseRealtionApplication.class, args);
		
		
		ProjectRepository pro = context.getBean(ProjectRepository.class);
		StudentRepository srepo = context.getBean(StudentRepository.class);
		// create project object
		Project p1 = new Project();
		p1.setProjectname("Student Management");
		p1.setTeamSize(4);
		
		// Add One skills
		Student s1 = new Student();
		s1.setName("Jhon");
		s1.setAge(15);
		// Add another skills
		Student s2 = new Student();
		s2.setName("Sam");
		s2.setAge(19);
		s1.getProjects().add(p1);
		s2.getProjects().add(p1);
		p1.getStud().add(s2);
		p1.getStud().add(s1);
		
		srepo.save(s1); //we have use CASCADE_ALL 
	
		srepo.findAll();
		
		
	}
		
	}


