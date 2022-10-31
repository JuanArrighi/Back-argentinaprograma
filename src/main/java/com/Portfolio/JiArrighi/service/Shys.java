/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Portfolio.JiArrighi.service;

import com.Portfolio.JiArrighi.entity.hys;
import com.Portfolio.JiArrighi.repository.Rhys;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class Shys {
    @Autowired
    Rhys rhys;
    
            
    public List<hys> list(){
        return rhys.findAll();
        
    }
    
    public Optional<hys> getOne(int id){
        return rhys.findById(id);
        
    }
    
    public Optional<hys> getByNombreE(String nombre) {
        return rhys.findByNombre(nombre);
        
    }
    
    public void save(hys skill){
        rhys.save(skill);
        
    }
    
    public void delete(int id){
        rhys.deleteById(id);
        
    }
    
    public boolean existsById(int id){
        return rhys.existsById(id);
        
    }
    
    public boolean existsByNombreE (String nombre){
        return rhys.existsByNombre(nombre);
        
    }
    
}
