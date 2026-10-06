package main.Dao.generics;




import main.anotacao.TipoChave;
import main.domain.Persistente;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

public abstract class GenericDao<T extends Persistente> implements IgenericDao<T>{


    //private SingletonMap singletonMap; vai trocar o map

    protected SingletonMap singletonMap;

    public abstract Class<T> getTipoClasse();

    public abstract void atualizarDados(T entity, T entityCadastrado);

    public GenericDao(){
        this.singletonMap = SingletonMap.getInstance();
    }

    public Long getChave(T entity){
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields){
            if (field.isAnnotationPresent(TipoChave.class)){
                TipoChave tipoChave = field.getAnnotation(TipoChave.class);
                String nomeMetodo = tipoChave.value();
                try {
                    Method method = entity.getClass().getMethod(nomeMetodo);
                    Long value = (Long) method.invoke(entity);
                    return value;
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }

            }
        }
        return null;
    }

    @Override
    public boolean cadastrar(T entity) {
//        Map<Long, T> mapaIterno = this.map.get(getTipoClasse());
        Map<Long, T> mapaIterno = (Map<Long, T>) this.singletonMap.getMap().get(getTipoClasse());
        Long chave = getChave(entity);
        if(mapaIterno.containsKey(chave)){
            return false;
        }

        mapaIterno.put(chave, entity);
        return true;


    }

    @Override
    public void excluir(Long codigo) {
//        Map<Long, T> mapaIterno = this.map.get(getTipoClasse());
        Map<Long, T> mapaIterno = (Map<Long, T>) this.singletonMap.getMap().get(getTipoClasse());
        T objetoCadastrado = mapaIterno.get(codigo);

      if(objetoCadastrado != null){
          mapaIterno.remove(codigo, objetoCadastrado);
        }
    }

    @Override
    public void alterar(T entity) {
//        Map<Long, T> mapaIterno = this.map.get(getTipoClasse());
        Map<Long, T> mapaIterno = (Map<Long, T>) this.singletonMap.getMap().get(getTipoClasse());
        Long chave = getChave(entity);
        T objetoCadastrado = mapaIterno.get(chave);
         if(objetoCadastrado != null){
           atualizarDados(entity, objetoCadastrado);

         }
    }

    @Override
    public T consultar(Long codigo) {
//        Map<Long, T> mapaIterno = this.map.get(getTipoClasse());
        Map<Long, T> mapaIterno = (Map<Long, T>) this.singletonMap.getMap().get(getTipoClasse());
        return mapaIterno.get(codigo);
    }

    @Override
    public Collection<T> buscarTodos() {
//        Map<Long, T> mapaIterno = this.map.get(getTipoClasse());
        Map<Long, T> mapaIterno = (Map<Long, T>) this.singletonMap.getMap().get(getTipoClasse());
        return mapaIterno.values();
    }
}
