package cadastro.fabrica;

import cadastro.Domain.Cliente;
import cadastro.Domain.Persistente;

public class ClienteFabrica implements IFabricaPersistente{

    @Override
    public Persistente criarObjeto(String[] dadosSeparados) {
        return new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2], dadosSeparados[3], dadosSeparados[4], dadosSeparados[5], dadosSeparados[6]);
    }
}
