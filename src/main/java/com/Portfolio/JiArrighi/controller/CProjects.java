/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Portfolio.JiArrighi.controller;

import com.Portfolio.JiArrighi.Dto.dtoProjects;
import com.Portfolio.JiArrighi.Security.Controller.Mensaje;
import com.Portfolio.JiArrighi.entity.Project;
import com.Portfolio.JiArrighi.service.SProject;
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
@RequestMapping("/projects")
@CrossOrigin(origins = {"http://localhost:4200", "https://jiafrontend.web.app"})

public class CProjects {

    @Autowired
    SProject sProject;

    @GetMapping("/lista")
    public ResponseEntity<List<Project>> list() {
        List<Project> list = sProject.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProjects dtopro) {
        if (StringUtils.isBlank(dtopro.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sProject.existsByNombreP(dtopro.getNombreP())) {
            return new ResponseEntity(new Mensaje("Ese proyecto existe"), HttpStatus.BAD_REQUEST);
        }

        Project project = new Project(dtopro.getNombreP(), dtopro.getDescripcionP(), dtopro.getInicioP(), dtopro.getFinP(), dtopro.getLinkP());
        sProject.save(project);
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);

    }
      
    @GetMapping("/detail/{id}")
    public ResponseEntity<Project> getById(@PathVariable("id") int id) {
        if (!sProject.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        Project project = sProject.getOne(id).get();
        return new ResponseEntity(project, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProjects dtopro) {

        if (!sProject.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        if (sProject.existsByNombreP(dtopro.getNombreP()) && sProject.getByNombreP(dtopro.getNombreP()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtopro.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Project project = sProject.getOne(id).get();
        project.setNombreP(dtopro.getNombreP());
        project.setDescripcionP(dtopro.getDescripcionP());
        project.setInicioP(dtopro.getInicioP());
        project.setFinP(dtopro.getFinP());
        project.setLinkP(dtopro.getLinkP());

        sProject.save(project);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {

        if (!sProject.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        sProject.delete(id);

        return new ResponseEntity(new Mensaje("Proyecto eliminado con exito"), HttpStatus.OK);
    }
}
