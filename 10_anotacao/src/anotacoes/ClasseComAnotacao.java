package anotacoes;

@PrimeiraAnotacao(value = "Rodrigo", bairros = "teste", numeroCasa = 5)
public class ClasseComAnotacao {

    @PrimeiraAnotacao(value = "Pires", bairros = {"teste", "teste1"}, numeroCasa = 10, valores = 100d)
    private String nome;

    @PrimeiraAnotacao(value = "Rodrigo", bairros = "teste", numeroCasa = 5)
    public ClasseComAnotacao(String nome) {
        this.nome = nome;
    }
}
