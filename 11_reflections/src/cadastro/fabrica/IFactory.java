package cadastro.fabrica;

public interface IFactory {

    public IFabricaPersistente criarFabrica(String opcaoMenuGeral);
}
