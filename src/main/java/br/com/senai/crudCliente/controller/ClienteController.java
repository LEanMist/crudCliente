package br.com.senai.crudCliente.controller;

import br.com.senai.crudCliente.cliente.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
public class ClienteController {

    @Autowired
    private final ClienteRepository repository;

    @GetMapping
    public

    @PostMapping
    @Transactional
    public void cadastrarCliente(@RequestBody @Valid DadosCadastroCliente dados) {
        repository.save(new Cliente(dados));
    }


}
