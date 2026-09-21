public abstract class Car {
    
    private int horsePower;
    private String fuelSource;
    private String color;

    public Car(int horsePower, String fuelSource, String color){
        this.horsePower = horsePower;
        this.fuelSource = fuelSource;
        this.color = color;
    }

    public void startEngine(){
        System.out.println(getClass().getSimpleName());
        System.out.println("The " + fuelSource + " engine has been satarted, and is ready to utilize " + horsePower + " horserpowers.n");
    }

    public void clean(){
        System.out.println("Car has been cleaned, and the " + color.toLowerCase() + " color shines");
    }

    public void mechanicCheck(){
        System.out.println("Car has been checked by the  mechanick. Everything looks good!");
    }

    public void fuelCar(){
        System.out.println("car is being filled with " + fuelSource.toLowerCase());
    }

}
