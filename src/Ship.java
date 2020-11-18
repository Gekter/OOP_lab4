abstract class Ship {
    public float speed;
    public String name;
    public String type;
    public int cost;

    public String getShipInfo() {
        return String.format("\nНазвание корабля: %s\nСкорость корабля - %s узл.\nТип корабля - %s\nСтоимость - %s$", name, speed, type, cost);
    }

    public abstract String getShipFeatures();
}
