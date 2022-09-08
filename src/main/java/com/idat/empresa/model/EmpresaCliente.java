package com.idat.empresa.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cliente_empresa")
public class EmpresaCliente {
    @EmbeddedId
    private EmpresaClienteFK id;
}
