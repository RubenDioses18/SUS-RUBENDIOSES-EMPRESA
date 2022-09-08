package com.idat.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.empresa.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Integer>{
    
}
