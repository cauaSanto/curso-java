public class TesteBurger {
    public static void main(String[] args) {
        //Gerente gerente = new Gerente(new CheeseBurgerBuilder()); 
        Gerente gerente = new Gerente();
        gerente.setBuilder(new CheeseBurgerBuilder());
        Burger burger =gerente.buildBurger();
        burger.print();

        //Gerente gerente1 = new Gerente(new VeganBurgerBuilder()); 
        gerente.setBuilder(new VeganBurgerBuilder());
        Burger burger1 =gerente.buildBurger();
        burger1.print();
    }    
}
