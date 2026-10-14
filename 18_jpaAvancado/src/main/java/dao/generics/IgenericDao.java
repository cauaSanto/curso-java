package dao.generics;

public interface IgenericDao<T> {

    public T cadastrar(T dados);
}
