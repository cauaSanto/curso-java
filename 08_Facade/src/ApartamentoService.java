public class ApartamentoService implements  IApartamentoService{

    public boolean cadastrarApartamento(Apartamento apartamento){
        boolean isCadastrado = isApartamentoCadastrado(apartamento);
        boolean isCamposvalidos = isCamposValidos(apartamento);
        if(isCadastrado && !isCamposvalidos){
            return false;
        }

        return cadastrarNoBanco(apartamento);
    };


    private boolean cadastrarNoBanco(Apartamento apartamento){
        //logica de cadastro

        return true;
    };

    private boolean isApartamentoCadastrado(Apartamento apartamento){
        //ir no banco e verificar se esta cadastrado
        return false;
    };

    private Boolean isCamposValidos(Apartamento apartamento){
        return true;
    }

    @Override

}
