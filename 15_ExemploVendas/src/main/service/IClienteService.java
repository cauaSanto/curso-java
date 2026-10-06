package main.service;

import main.domain.Cliente;

public interface IClienteService {


    boolean salvar(Cliente cliente);

    Cliente buscarPorCpf(Long cpf);

    void excluir(Long cpf);

    void alterar(Cliente cliente);
}
