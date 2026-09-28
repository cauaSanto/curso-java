package cadastro.fabrica;

import cadastro.Domain.Persistente;
import cadastro.Domain.Produto;

public class ProdutoFabrica implements IFabricaPersistente{

    @Override
    public Persistente criarObjeto(String[] dados) {
        Produto produto = new Produto();
        produto.setCodigo(Long.parseLong(dados[0].trim()));
        produto.setNome(dados[1]);
        return produto;
    }
}
