package main.Dao;

import main.Dao.generics.GenericDao;
import main.domain.Cliente;
import main.domain.Persistente;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDao extends GenericDao<Cliente, Long> implements IClienteDao {

   public ClienteDao(){
       super();
   }

    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualizarDados(Cliente entity, Cliente entityCadastrado) {
        entityCadastrado.setCidade(entity.getCidade());
        entityCadastrado.setCpf(entity.getCpf());
        entityCadastrado.setEnd(entity.getEnd());
        entityCadastrado.setEstado(entity.getEstado());
        entityCadastrado.setNome(entity.getNome());
        entityCadastrado.setNumero(entity.getNumero());
        entityCadastrado.setTel(entity.getTel());
    }

    @Override
    protected String getQueryInsercao() {
        StringBuilder sb = new StringBuilder();
        sb.append("insert into tb_cliente ");
        sb.append("(id, nome, cpf, tel, endereco, numero, cidade, estado) ");
        sb.append("values (nextval('sq_cliente'),?,?,?,?,?,?,?)");
        return sb.toString();
    }

    @Override
    protected String getQueryExclusao() {
        return "delete from tb_cliente where cpf =?";
    }

    @Override
    protected String getQueryAtualizacao() {
        StringBuilder sb = new StringBuilder();
        sb.append("update tb_cliente ");
        sb.append("set nome = ?,");
        sb.append("tel = ?,");
        sb.append("endereco = ?,");
        sb.append("numero = ?,");
        sb.append("cidade = ?,");
        sb.append("estado = ?");
        sb.append(" where cpf = ? ");
        return sb.toString();
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Cliente entity)throws SQLException {
        stmInsert.setString(1, entity.getNome());
        stmInsert.setLong(2, entity.getCpf());
        stmInsert.setLong(3, entity.getTel());
        stmInsert.setString(4, entity.getEnd());
        stmInsert.setLong(5, entity.getNumero());
        stmInsert.setString(6, entity.getCidade());
        stmInsert.setString(7, entity.getEstado());
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmDelete, Long valor)throws SQLException {
        stmDelete.setLong(1, valor);
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Cliente entity)throws SQLException {
        stmUpdate.setString(1, entity.getNome());
        stmUpdate.setLong(2, entity.getTel());
        stmUpdate.setString(3, entity.getEnd());
        stmUpdate.setLong(4, entity.getNumero());
        stmUpdate.setString(5, entity.getCidade());
        stmUpdate.setString(6, entity.getEstado());
        stmUpdate.setLong(7, entity.getCpf());
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmSelect, Long valor) throws SQLException {
        stmSelect.setLong(1, valor);
    }
}
