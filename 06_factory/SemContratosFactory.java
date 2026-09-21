public class SemContratosFactory extends Factory{
    
    Car retrieveCar(String requestGrade){
        if("A".equals(requestGrade)){
            return new BrasiliaCar(100, "cheio", "azul");
        }else{
            return new BrasiliaCar(100, "meio", "vermelho");
        }
    }
}
