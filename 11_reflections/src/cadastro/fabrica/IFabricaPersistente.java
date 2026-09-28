package cadastro.fabrica;

import cadastro.Domain.Persistente;

public interface IFabricaPersistente {


    Persistente criarObjeto(String dados[]);
}
