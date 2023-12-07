package com.emanuel.cursomc.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emanuel.cursomc.domain.Cliente;
import com.emanuel.cursomc.repositories.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository repo;

    public Cliente buscar(Integer id){
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName(), obj
        ));
    }
}
