package br.com.senai.crudCliente.cliente;

import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record DadosAtualizarCliente(
        Long id,

        @Size(min = 3, max = 100)
        @Column(unique = true)
        String nome,

        @Email
        String email,

        @Size(min = 11, max = 11)
        String cpf,

        @Size(max = 20)
        String telefone
) {
}
