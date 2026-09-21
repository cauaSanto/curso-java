public class Burger {
    private String bun = "no Bun";  
    private String meat = "no Meat";
    private String salad = "no Salad";
    private String cheese = "no Cheese";
    private String sauce = "no Sauce";

    public void setBun(String bun){
        this.bun = bun;
    }
    public void setMeat(String meat){
        this.meat = meat;
    }
    public void setSalad(String salad){
        this.salad = salad;
    }
    public void setCheese(String cheese){
        this.cheese = cheese;
    }
    public void setSauce(String sauce){
        this.sauce = sauce;
    }

    public void print(){
        System.out.println(
            "burger is finished! " + "n" + "Bun: " + bun +
             " - Meat: " + meat + 
             " - Cheese: " + cheese + 
             " - Salad: " + salad + 
             " - Sauce: " + sauce
        );
    }

}
