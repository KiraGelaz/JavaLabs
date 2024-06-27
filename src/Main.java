import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.setStrategy(new Run());
        System.out.println("Choose strategy for your hero: Fly, Fly by dragon, Run, Drive by car");
        Scanner strategy_input = new Scanner(System.in);
        String strategy = strategy_input.nextLine();
        while (!strategy.equals("exit")) {
            switch (strategy) {
                case "Fly":
                    hero.setStrategy(new Fly());
                    break;
                case "Fly by dragon":
                    hero.setStrategy(new DragonFly());
                    break;
                case "Run":
                    hero.setStrategy(new Run());
                    break;
                case "Drive by car":
                    hero.setStrategy(new Drive());
                    break;
                default:
                    System.out.println("no strategy like this, try again");
                    break;
            }
            System.out.println("Enter two points");
            Scanner input = new Scanner(System.in);
            int x = input.nextInt();
            int y = input.nextInt();
            hero.move(x, y);
            input.nextLine();
            System.out.println("Choose strategy for your hero: Fly, Fly by dragon, Run, Drive by car");
            strategy = strategy_input.nextLine();
        }
    }
}