public class Corvette extends Ship{
    private int amountOfGuns;
    private int amountOfFuel;

    public Corvette(int amountOfGuns, int amountOfFuel, String name){
        this.amountOfFuel = amountOfFuel;
        this.amountOfGuns = amountOfGuns;
        this.name = name;
        this.speed = (float) 27;
        this.cost = 500;
        this.type = "Corvette";
    }

    @Override
    public String getShipFeatures() {
        return String.format("Количество орудий на борту - %s\nКоличество топлива - %s\n", amountOfGuns, amountOfFuel);
    }
}
