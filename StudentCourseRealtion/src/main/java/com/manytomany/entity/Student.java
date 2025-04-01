package com.manytomany.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Students")
public class Student {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
	private int sid;
	
	private String name;
	
	private int age;
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		
	}
@ManyToMany(cascade=CascadeType.ALL)
@JoinTable(name="stud_project",
joinColumns= {@JoinColumn(name="stud_id")},
inverseJoinColumns= {@JoinColumn(name="proj_id")})
		
	private Set<Project> projects=new HashSet<>();
}
