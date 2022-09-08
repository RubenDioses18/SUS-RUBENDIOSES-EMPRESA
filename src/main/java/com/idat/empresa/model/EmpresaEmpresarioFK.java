package com.idat.empresa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class EmpresaEmpresarioFK implements Serializable{
    @Column(name = "id_empresa",nullable = false)
    private int idEmpresa;
    @Column(name = "id_empresario",nullable = false)
    private int idEmpresario;
}
