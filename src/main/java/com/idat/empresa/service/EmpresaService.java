package com.idat.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.empresa.client.OpenFeignCliente;
import com.idat.empresa.client.OpenFeignEmpresario;
import com.idat.empresa.dto.ClienteDto;
import com.idat.empresa.dto.EmpresarioDto;
import com.idat.empresa.model.Empresa;
import com.idat.empresa.model.EmpresaCliente;
import com.idat.empresa.model.EmpresaClienteFK;
import com.idat.empresa.model.EmpresaEmpresario;
import com.idat.empresa.model.EmpresaEmpresarioFK;
import com.idat.empresa.repository.EmpresaClienteRepository;
import com.idat.empresa.repository.EmpresaEmpresarioRepository;
import com.idat.empresa.repository.EmpresaRepository;

@Service
public class EmpresaService implements IEmpresaService{

    @Autowired
    private EmpresaRepository repository;

    @Autowired
    private OpenFeignEmpresario feignEmpresario;

    @Autowired
    private OpenFeignCliente feignCliente;

    @Autowired
    private EmpresaClienteRepository empresaClienteRepository;

    @Autowired
    private EmpresaEmpresarioRepository empresaEmpresarioRepository;

    @Override
    public void guardar(Empresa empresa) {
        // TODO Auto-generated method stub
        repository.save(empresa);
    }

    @Override
    public void editar(Empresa empresa) {
        // TODO Auto-generated method stub
        repository.saveAndFlush(empresa);
    }

    @Override
    public void eliminar(int id) {
        // TODO Auto-generated method stub
        repository.deleteById(id);
    }

    @Override
    public List<Empresa> listar() {
        // TODO Auto-generated method stub
        return repository.findAll();
    }

    @Override
    public Empresa buscar(int id) {
        // TODO Auto-generated method stub
        return repository.findById(id).orElse(null);
    }

    @Override
    public void asignarEmpresarios(int idEmpresa) throws Exception{
        // TODO Auto-generated method stub
        
        EmpresaEmpresario empresaEmpresario = null;
        EmpresaEmpresarioFK fk = null;

        List<EmpresarioDto> empresarios = feignEmpresario.listarEmpresarios();
        Empresa empresa = buscar(idEmpresa);

        if (empresa!=null) {
            for (EmpresarioDto empresarioDto : empresarios) {
                empresaEmpresario = new EmpresaEmpresario();
                fk = new EmpresaEmpresarioFK();
                fk.setIdEmpresa(empresa.getIdEmpresa());
                fk.setIdEmpresario(empresarioDto.getIdEmpresario());
                empresaEmpresario.setId(fk);
                empresaEmpresarioRepository.save(empresaEmpresario);
            }
        }else{
            throw new Exception("Empresa no Existe");
        }
        
    }

    @Override
    public void asignarClientes(int idEmpresa) throws Exception{
        // TODO Auto-generated method stub
        EmpresaCliente empresaCliente = null;
        EmpresaClienteFK fk = null;

        List<ClienteDto> clientes = feignCliente.listarClientes();
        Empresa empresa = buscar(idEmpresa);
        if (empresa!=null) {
            for (ClienteDto clienteDto : clientes) {
                empresaCliente = new EmpresaCliente();
                fk = new EmpresaClienteFK();
                fk.setIdEmpresa(empresa.getIdEmpresa());
                fk.setIdCliente(clienteDto.getIdCliente());
                empresaCliente.setId(fk);
                empresaClienteRepository.save(empresaCliente);
            }
        }else{
            throw new Exception("Empresa no Existe");
        }
    }
    
}
