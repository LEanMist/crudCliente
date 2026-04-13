package br.com.senai.crudCliente.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="clientes")
@Entity(name="Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")

public class Cliente {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private boolean ativo;

    public Cliente(DadosCadastroCliente dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
        this.ativo = true;
    }
    public void atualizarDadosCliente(DadosAtualizarCliente dados) {
        if(dados.nome() != null && !dados.nome().isBlank())
            this.nome = dados.nome();
        if(dados.email() != null && !dados.email().isBlank())
            this.nome = dados.email();
        if(dados.telefone() != null && !dados.telefone().isBlank())
            this.nome = dados.telefone();
    }
    public void excluirCliente() {
        this.ativo = false;
    }
}
