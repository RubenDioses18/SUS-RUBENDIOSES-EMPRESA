package com.idat.empresa.service;

import java.util.List;

import com.idat.empresa.model.Empresa;

public interface IEmpresaService {
    public void guardar(Empresa empresa);
    public void editar(Empresa empresa);
    public void eliminar(int id);
    public List<Empresa> listar();
    public Empresa buscar(int id);
    public void asignarEmpresarios(int idEmpresa) throws Exception;
    public void asignarClientes(int idEmpresa)throws Exception;
}
