/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Portfolio.JiArrighi.repository;

import com.Portfolio.JiArrighi.entity.Project;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RProject extends JpaRepository<Project, Integer>{
    public Optional<Project> findByNombreP(String nombreP);
    public boolean existsByNombreP (String nombreP);
    
    
}
