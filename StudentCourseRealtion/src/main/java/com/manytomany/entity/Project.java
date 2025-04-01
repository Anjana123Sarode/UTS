package com.manytomany.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="projects")
public class Project {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
	private int pid;
	private String projectname;
	
	private int teamSize;
	
	public Project(String projectname, int teamSize) {
		super();
		this.projectname = projectname;
		this.teamSize = teamSize;
		
	}
@ManyToMany(cascade=CascadeType.ALL,mappedBy="projects")
	private Set<Student>stud=new HashSet<>();
	
	
	
}
