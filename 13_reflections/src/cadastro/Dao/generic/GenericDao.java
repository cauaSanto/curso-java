package cadastro.Dao.generic;

import cadastro.Domain.Persistente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class GenericDao<T extends Persistente> implements IgenericDao<T>{

    protected Map<Class, Map<Long, T>> map;

    public abstract Class<T> getTipoClasse();

    public abstract void atualizarDados(T entity, T entityCadastrado);

    public GenericDao(){
        if(this.map == null){
            this.map = new HashMap<>();

        }
    }

    @Override
    public boolean cadastrar(T entity) {
        Map<Long, T> mapaIterno = this.map.get(getTipoClasse());
        if(mapaIterno.containsKey(entity.getCodigo())){
            return false;
        }
        mapaIterno.put(entity.getCodigo(), entity);
        return true;


    }

    @Override
    public void excluir(Long codigo) {
        Map<Long, T> mapaIterno = this.map.get(getTipoClasse());
        T objetoCadastrado = mapaIterno.get(codigo);

      if(objetoCadastrado != null){
          mapaIterno.remove(codigo, objetoCadastrado);
        }
    }

    @Override
    public void alterar(T entity) {
        Map<Long, T> mapaIterno = this.map.get(getTipoClasse());
        T objetoCadastrado = mapaIterno.get(entity.getCodigo());
         if(objetoCadastrado != null){
           atualizarDados(entity, objetoCadastrado);

         }
    }

    @Override
    public T consultar(Long codigo) {
        Map<Long, T> mapaIterno = this.map.get(getTipoClasse());
        return mapaIterno.get(codigo);
    }

    @Override
    public Collection<T> buscarTodos() {
        Map<Long, T> mapaIterno = this.map.get(getTipoClasse());
        return mapaIterno.values();
    }
}
