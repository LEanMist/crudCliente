package br.com.senai.crudCliente.controller;

import br.com.senai.crudCliente.cliente.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteRepository repository;

    @GetMapping
    public Page<DadosListagemCliente> listarClientes(
            @PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        return repository.findAllByAtivoTrue(pageable)
                .map(DadosListagemCliente::new);
    }

    @GetMapping("/{id}")
    public DadosDetalhamentoCliente detalharCliente(@PathVariable Long id) {
        Cliente cliente = repository.findByIdAndAtivoTrue(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        return new DadosDetalhamentoCliente(cliente);
    }

    @PostMapping
    @Transactional
    public void cadastrarCliente(@RequestBody @Valid DadosCadastroCliente dados) {
        if (repository.existsByEmail(dados.email())) {
            throw new RuntimeException("Email já cadastrado");
        }

        if (repository.existsByCpf(dados.cpf())) {
            throw new RuntimeException("CPF já cadastrado");
        }

        repository.save(new Cliente(dados));
    }

    @PutMapping
    @Transactional
    public void atualizarCliente(@RequestBody @Valid DadosAtualizarCliente dados) {
        Cliente cliente = repository.findByIdAndAtivoTrue(dados.id())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        cliente.atualizarDadosCliente(dados);
    }

    // 🔹 DELETE - DELETE LÓGICO (PRECISA)
    @DeleteMapping("/{id}")
    @Transactional
    public void excluirCliente(@PathVariable Long id) {
        Cliente cliente = repository.findByIdAndAtivoTrue(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        cliente.excluirCliente();
    }
}
