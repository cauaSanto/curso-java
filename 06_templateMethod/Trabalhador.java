public abstract class Trabalhador{

    public void executar(){
        iniciarRotina();
        levantar();
        irAoTrabalho();
        trabalhar();
        voltarParaCasa();
    }

    private void iniciarRotina(){
        System.out.println("iniciando Rotina");
    }

    private void levantar(){
        System.out.println("levantando da cama");
    }

    private void irAoTrabalho(){
        System.out.println("Indo trabalhar");
    }

    protected abstract void trabalhar();

    private void voltarParaCasa(){
        System.out.println("voltando para casa");
    }
}