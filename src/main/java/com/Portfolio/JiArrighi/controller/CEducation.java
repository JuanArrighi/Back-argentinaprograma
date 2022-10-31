/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Portfolio.JiArrighi.controller;

import com.Portfolio.JiArrighi.Dto.dtoEducation;
import com.Portfolio.JiArrighi.Security.Controller.Mensaje;
import com.Portfolio.JiArrighi.entity.Education;
import com.Portfolio.JiArrighi.service.SEducation;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/education")
@CrossOrigin(origins = {"http://localhost:4200","https://jiafrontend.web.app"})

public class CEducation {
    @Autowired
    SEducation sEducation;
    
     
     
    @GetMapping("/lista")
    public ResponseEntity<List<Education>> list(){
        List<Education>list = sEducation.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    
        @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") int id) {
        if (!sEducation.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        Education education = sEducation.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }
    
    
    @PostMapping("/create")
    public ResponseEntity<?> create (@RequestBody dtoEducation dtoedu){
        if(StringUtils.isBlank(dtoedu.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sEducation.existsByNombreE(dtoedu.getNombreE()))
            return new ResponseEntity (new Mensaje("Esa educación existe"), HttpStatus.BAD_REQUEST);
                
        Education education = new Education(dtoedu.getNombreE(), dtoedu.getInstitucionE(), dtoedu.getDescripcionE(), dtoedu.getInicioE(), dtoedu.getFinE(), dtoedu.getLogoE() ); 
        sEducation.save(education);
        return new ResponseEntity(new Mensaje("Educación agregada"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducation dtoedu){
        
        if(!sEducation.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if (sEducation.existsByNombreE(dtoedu.getNombreE()) && sEducation.getByNombreE(dtoedu.getNombreE()).get().getId() != id)
            return new ResponseEntity (new Mensaje("Esa educación ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoedu.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Education education = sEducation.getOne(id).get();
        education.setNombreE(dtoedu.getNombreE());
        education.setInstitucionE(dtoedu.getInstitucionE());
        education.setDescripcionE(dtoedu.getDescripcionE());
        education.setInicioE(dtoedu.getInicioE());
        education.setFinE(dtoedu.getFinE());
        education.setLogoE(dtoedu.getLogoE());
        
        sEducation.save(education);
        return new ResponseEntity(new Mensaje("Educación actualizada"), HttpStatus.OK);
        
    }
    
     @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        
        if(!sEducation.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sEducation.delete(id);
        
        return new ResponseEntity(new Mensaje("Educación eliminada con exito"), HttpStatus.OK);
    }
}
