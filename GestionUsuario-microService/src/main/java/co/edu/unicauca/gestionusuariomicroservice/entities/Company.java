/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.gestionusuariomicroservice.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="COMPANY")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Company {

    @Id
    private String nit;
    private String name;
    private String phone;
    private String pageWeb;
    private SectorCompany sector;
    private String email;
    private String password;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    private List<Project> projects = new ArrayList<>();


    public void addProject(Project project) {
        projects.add(project);
        project.setCompany(this);
    }

    public void removeProject(Project project) {
        projects.remove(project);
        project.setCompany(null);

    }


    }