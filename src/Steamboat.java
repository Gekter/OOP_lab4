public class Steamboat extends Ship {
    private int amountOfCoal;

    public Steamboat(int amountOfCoal, String name){
        this.type = "Steamboat";
        this.amountOfCoal = amountOfCoal;
        this.cost = 400;
        this.speed = (float) 17.7;
        this.name = name;
    }

    @Override
    public String getShipFeatures() {
        return String.format("Сейчас на корабле %s тонн угля\n", amountOfCoal);
    }
}
