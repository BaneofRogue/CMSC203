import java.util.Scanner;

public class BevShopDriverApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BevShop bevShop = new BevShop();

        System.out.println("The current order in process can have at most " + bevShop.getMaxOrderForAlcohol() + " alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is " + bevShop.getMinAgeForAlcohol());

        while (true) {
            System.out.println("\nStart please a new order:");
            System.out.println("Your Total Order for now is 0.0");
            System.out.print("Would you please enter your name: ");
            String name = scanner.nextLine();

            System.out.print("Would you please enter your age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Please enter the order time (0-23): ");
            int time = Integer.parseInt(scanner.nextLine());

            System.out.print("Please enter the order day (e.g., MONDAY): ");
            Day day = Day.valueOf(scanner.nextLine().toUpperCase());

            bevShop.startNewOrder(time, day, name, age);

            if (bevShop.isValidAge(age)) {
                System.out.println("Your age is above 20 and you are eligible to order alcohol");
            } else {
                System.out.println("Your age is below the minimum for alcohol.");
            }

            boolean ordering = true;
            while (ordering) {
                System.out.println("\nAdd a drink to your order:");
                System.out.println("1. Alcohol");
                System.out.println("2. Coffee");
                System.out.println("3. Smoothie");
                System.out.println("4. Finish order");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        if (!bevShop.isValidAge(age)) {
                            System.out.println("Your Age is not appropriate for alcohol drink!!");
                        } else if (!bevShop.isEligibleForMore()) {
                            System.out.println("You have a maximum alcohol drinks for this order");
                        } else {
                            System.out.print("Enter alcohol drink name: ");
                            String alcoholName = scanner.nextLine();
                            Size alcoholSize = readSize(scanner);
                            bevShop.processAlcoholOrder(alcoholName, alcoholSize);
                            System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getBeverages().size());
                            System.out.println("The Total price on the Order: " + bevShop.getCurrentOrder().calcOrderTotal());
                            System.out.println("Your current alcohol drink order is less than 4");
                        }
                        break;

                    case 2:
                        System.out.print("Enter coffee drink name: ");
                        String coffeeName = scanner.nextLine();
                        Size coffeeSize = readSize(scanner);
                        System.out.print("Extra shot? (true/false): ");
                        boolean extraShot = Boolean.parseBoolean(scanner.nextLine());
                        System.out.print("Extra syrup? (true/false): ");
                        boolean extraSyrup = Boolean.parseBoolean(scanner.nextLine());
                        bevShop.processCoffeeOrder(coffeeName, coffeeSize, extraShot, extraSyrup);
                        System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getBeverages().size());
                        System.out.println("The Total price on the Order: " + bevShop.getCurrentOrder().calcOrderTotal());
                        break;

                    case 3:
                        System.out.print("Enter smoothie name: ");
                        String smoothieName = scanner.nextLine();
                        Size smoothieSize = readSize(scanner);
                        System.out.print("Number of fruits: ");
                        int fruits = Integer.parseInt(scanner.nextLine());
                        if (bevShop.isMaxFruit(fruits)) {
                            System.out.println("You reached a Maximum number of fruits. Capped you out at 5 fruits.");
                            fruits = 5;
                        }
                        System.out.print("Add protein? (true/false): ");
                        boolean addProtein = Boolean.parseBoolean(scanner.nextLine());
                        bevShop.processSmoothieOrder(smoothieName, smoothieSize, fruits, addProtein);
                        System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getBeverages().size());
                        System.out.println("The Total price on the Order: " + bevShop.getCurrentOrder().calcOrderTotal());
                        break;

                    case 4:
                        ordering = false;
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            }

            System.out.println("Total price on this order: " + bevShop.getCurrentOrder().calcOrderTotal());
            System.out.println("Total amount for all Orders so far: " + bevShop.totalMonthlySale());
            System.out.println("#------------------------------------#");
            System.out.print("\nWould you like to start another order? (yes/no): ");
            String again = scanner.nextLine().toLowerCase();
            if (!again.equals("yes")) break;
        }

        scanner.close();
        System.out.println("Total amount for all Orders: " + bevShop.totalMonthlySale());
    }

    private static Size readSize(Scanner scanner) {
        System.out.print("Enter size (SMALL, MEDIUM, LARGE): ");
        return Size.valueOf(scanner.nextLine().toUpperCase());
    }
}
