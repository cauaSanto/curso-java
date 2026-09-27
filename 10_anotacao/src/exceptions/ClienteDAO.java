package exceptions;

public class ClienteDAO {
    public static void consultarCliente(String codigo) throws ClienteNaoEncontradoException{
        //buscar no banco
        boolean isCadastrado = false;

        if(!isCadastrado){
            throw new ClienteNaoEncontradoException("Cliente não foi encontrado");
        }
    };
}
