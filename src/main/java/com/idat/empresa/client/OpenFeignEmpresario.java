package com.idat.empresa.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.idat.empresa.dto.EmpresarioDto;

@FeignClient(name = "idat-empresario",url = "localhost:8089",path = "/empresario")
public interface OpenFeignEmpresario {
    @GetMapping
    public List<EmpresarioDto> listarEmpresarios();
}
