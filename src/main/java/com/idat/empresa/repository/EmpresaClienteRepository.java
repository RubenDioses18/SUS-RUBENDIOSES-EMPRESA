package com.idat.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.empresa.model.EmpresaCliente;

@Repository
public interface EmpresaClienteRepository extends JpaRepository<EmpresaCliente,Integer>{
    
}
