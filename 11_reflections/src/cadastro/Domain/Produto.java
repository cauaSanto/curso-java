package cadastro.Domain;

import cadastro.anotacao.TipoChave;

public class Produto implements Persistente{

    @TipoChave("getCodigo")
    private Long codigo;

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String toString() {
        return "Produto{" + "nome=" + nome + '\'' + ", codigo=" + codigo + "}";
    }
}
