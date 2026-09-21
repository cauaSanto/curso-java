public class ContratosFactory extends Factory{

    Car retrieveCar(String requestGrade){
        if("A".equals(requestGrade)){
            return new CorolaCar(100, "cheio", "azul");
        }else{
            return new CorolaCar(100, "meio", "vermelho");
        }
    }
}
