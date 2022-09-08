package com.idat.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.empresa.model.Empresa;
import com.idat.empresa.service.IEmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    @Autowired
    private IEmpresaService service;

    @GetMapping
    public ResponseEntity<List<Empresa>> listar() {
        List<Empresa> lista = service.listar();
        return new ResponseEntity<>(lista,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Empresa> buscarPorId(@PathVariable("id") int id) {
        return new ResponseEntity<>(service.buscar(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Empresa Empresa) {
        try {
            service.guardar(Empresa);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Empresa> editar(@PathVariable("id") int id, @RequestBody Empresa Empresa) {
        try {
           service.editar(Empresa);
           return new ResponseEntity<Empresa>(HttpStatus.OK); 
        } catch (Exception e) {
        return new ResponseEntity<Empresa>(HttpStatus.BAD_REQUEST); 
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
        try {
            service.eliminar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/asignaclientes/{id}")
    public ResponseEntity<?> asignarClientes(@PathVariable("id") int id){
        try {
            service.asignarClientes(id);
            return new ResponseEntity<>("Clientes Asignados a Empresa", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al asignar",HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/asignaempresarios/{id}")
    public ResponseEntity<?> asignarEmpresarios(@PathVariable("id") int id){
        try {
            service.asignarEmpresarios(id);
            return new ResponseEntity<>("Empresarios Asignados a Empresa", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al asignar",HttpStatus.BAD_REQUEST);
        }
    }
}
