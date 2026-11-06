import java.util.Scanner;

enum Coin { ONE, TWO, FIVE, TEN }
public class VendingMachine {
    public static void main(String[] args) {
        final int price = 15;
        int total = 0;
        try (Scanner sc = new Scanner(System.in)) {
            while (total < price) {
                System.out.print("Enter coin (ONE, TWO, FIVE, TEN): ");
                Coin coin = Coin.valueOf(sc.next().toUpperCase());
                int value = switch (coin) {
                    case ONE -> 1; case TWO -> 2; case FIVE -> 5; case TEN -> 10;
                };
                total += value;
                System.out.println("Total so far: " + total);
            }
            System.out.println("Paid. Change: " + (total - price));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid coin name. Run again and enter a valid coin.");
        }
    }
}
