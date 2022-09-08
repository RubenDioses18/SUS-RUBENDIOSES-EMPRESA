package com.idat.empresa.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "empresario_empresa")
public class EmpresaEmpresario {
    @EmbeddedId
    private EmpresaEmpresarioFK id;
}
