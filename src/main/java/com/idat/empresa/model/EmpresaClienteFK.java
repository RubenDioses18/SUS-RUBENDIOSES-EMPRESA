package com.idat.empresa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class EmpresaClienteFK implements Serializable{
    @Column(name = "id_cliente",nullable = false)
    private int idCliente;
    @Column(name = "id_empresa",nullable = false)
    private int idEmpresa;
}
