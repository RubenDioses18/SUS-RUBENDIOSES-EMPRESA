package com.idat.empresa.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.idat.empresa.dto.ClienteDto;

@FeignClient(name = "idat-cliente",url = "localhost:8088",path = "/cliente")
public interface OpenFeignCliente {
    @GetMapping
    public List<ClienteDto> listarClientes();
}
