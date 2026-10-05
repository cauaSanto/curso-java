package testes.dao;

public class ContratoDao implements IContratoDao{

    @Override
    public void salvar() {
        throw new UnsupportedOperationException("não funciona o banco de dados");
    }
}
