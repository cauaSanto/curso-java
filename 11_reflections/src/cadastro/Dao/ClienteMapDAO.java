package cadastro.Dao;

import cadastro.Dao.generic.GenericDao;
import cadastro.Domain.Cliente;

import java.util.HashMap;
import java.util.Map;

public class ClienteMapDAO extends GenericDao<Cliente> implements IClienteDAO {

    public ClienteMapDAO(){
        super();
        Map<Long, Cliente> mapaInterno = this.map.get(getTipoClasse());
        if(mapaInterno == null){
            mapaInterno = new HashMap<>();
            this.map.put(getTipoClasse(), mapaInterno);
        }
    }

    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualizarDados(Cliente entity, Cliente entityCadastrado) {
           entityCadastrado.setNome(entity.getNome());
           entityCadastrado.setTel(entity.getTel());
           entityCadastrado.setNumero(entity.getNumero());
           entityCadastrado.setEnd(entity.getEnd());
           entityCadastrado.setCidade(entity.getCidade());
           entityCadastrado.setEstado(entity.getEstado());
    }

    //    private Map<Long, Cliente> map;
//
//    public ClienteMapDAO(){
//        this.map = new HashMap<>();
//    }
//
//    public boolean cadastrar(Cliente cliente){
//        if(this.map.containsKey(cliente.getCpf())){
//            return false;
//        }
//        this.map.put(cliente.getCpf(), cliente);
//        return true;
//    };
//    public  void excluir(Long cpf){
//        Cliente clienteCadastrado = this.map.get(cpf);
//
//      if(clienteCadastrado != null){
//            this.map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
//        }
//    };
//
//    public void alterar(Cliente cliente){
//         Cliente clienteCadastrado = this.map.get(cliente.getCpf());
//         if(clienteCadastrado != null){
//           clienteCadastrado.setNome(cliente.getNome());
//           clienteCadastrado.setTel(cliente.getTel());
//           clienteCadastrado.setNumero(cliente.getNumero());
//           clienteCadastrado.setEnd(cliente.getEnd());
//           clienteCadastrado.setCidade(cliente.getCidade());
//           clienteCadastrado.setEstado(cliente.getEstado());
//
//         }
//
//    };
//
//    public Cliente consultar(Long cpf){
//        return this.map.get(cpf);
//    };
//
//    public Collection<Cliente> buscarTodos(){
//        return this.map.values();
//    };

}
