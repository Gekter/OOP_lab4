import java.util.ArrayList;
import java.util.Scanner;

public class Fleet {
    protected static ArrayList<Ship> ships = new ArrayList<>();
    protected static int budget = 1200;
    private static Scanner input = new Scanner(System.in);

    public static void menu() {
        int choice;
        do{
            // Меню
            {
                System.out.println("\t\tМеню");
                System.out.println("1 - Купить корабль");
                if (ships.size() > 0) {
                    System.out.println("2 - Продать корабль");
                    System.out.println("3 - Вывести список кораблей");
                    System.out.println("4 - Информация о корабле по названию");
                }
                System.out.println("5 - Баланс");
                System.out.println("6 - Запросить материальную помощь");
                System.out.println("0 - Выйти из программы");
                System.out.println("------------------------------------------");
                System.out.print("Выберите пункт меню: ");
            }
            choice = inputChoice();

            switch (choice){
                case 1:
                    buyShip();
                    break;
                case 2:
                    for (int i = 0; i < ships.size(); i++) {
                        System.out.println(i + 1 + ") " + ships.get(i).name + " " + ships.get(i).cost + "$");
                    }
                    System.out.print("Введите номер корабля, который хотите продать: ");
                    int index = inputChoice();
                    sellShip(index - 1);

                    break;
                case 3:
                    printFleet();

                    break;
                case 4:
                    System.out.print("Введите название корабля: ");
                    search(input.nextLine());

                    break;
                case 5:
                    System.out.println("Баланс - " + budget);
                    break;
                case 6:
                    System.out.print("Введите сумму, которую хотите запросить: ");
                    addBudget(inputChoice());
                    break;
                case 0:

                    break;
                default:
                    System.out.println("Введите цифру от 0 до 6");
            }



        }while (choice != 0);

    }

    private static void addBudget(int money) {
        if (money < 0) {
            System.out.println("Вы хотите чтобы у вас забрали деньги?");
            return;
        }
        budget += money;
        System.out.println("Деньги переведены");
    }

    private static void search(String searchName) {
        boolean check = false;
        for (Ship i: ships) {
            if (i.name.startsWith(searchName)) {
                System.out.println(i.getShipInfo() + "\n" + i.getShipFeatures());
                check = true;
            }
        }
        if (!check) {
            System.out.println("Корабль с таким именем не найден");
        }
    }

    private static void printFleet() {
        for (Ship i: ships) {
            System.out.println(i.getShipInfo() + "\n" + i.getShipFeatures());
        }
    }

    private static void sellShip(int index) {
        if (index >= ships.size() | index < 0) {
            System.out.println("Такого номера корабля нет");
            return;
        }
        budget += ships.get(index).cost;
        ships.remove(index);
        System.out.println("Корабль продан");
    }

    private static void buyShip() {
        System.out.print("Введите название корабля: ");
        String name = input.nextLine();
        switch (choiceType()) {


            case "Sailboat":
                if (budget < 300) {
                    System.out.println("Недостаточно " + (300-budget) + "$ для покупки");
                    return;
                }
                budget -= 300;
                System.out.print("Введите кол-во мачт: ");
                ships.add(new Sailboat(inputChoice(), name));
                break;


            case "Steamboat":
                if (budget < 400) {
                    System.out.println("Недостаточно " + (400-budget) + "$ для покупки");
                    return;
                }
                budget -= 400;
                System.out.print("Введите кол-во угля на борту в тоннах: ");
                ships.add(new Steamboat(inputChoice(), name));
                break;


            case "Corvette":
                if (budget < 500) {
                    System.out.println("Недостаточно " + (500-budget) + "$ для покупки");
                    return;
                }
                budget -= 500;
                System.out.print("Введите кол-во топлива на борту: ");
                int temp = inputChoice();
                System.out.print("Введите кол-во орудий на борту: ");

                ships.add(new Corvette(inputChoice(), temp, name));
                break;
        }
    }

    private static String choiceType() {
        int choice;

        System.out.println("\t1 - Парусник");
        System.out.println("\t2 - Пароход");
        System.out.println("\t3 - Корвет");
        do {
            System.out.print("Выберите тип коробля: ");
            choice = inputChoice();
            switch (choice) {
                case 1:
                    return "Sailboat";
                case 2:
                    return "Steamboat";
                case 3:
                    return "Corvette";
                default:
                    System.out.println("Введите числа от 1 до 3");
            }
        } while (choice < 1 | choice > 3);
        return "Error";
    }

    private static int inputChoice() {
        int choice;
        try {
            choice = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.print("Введите число: ");
            choice = inputChoice();
        }
        return choice;
    }
}
