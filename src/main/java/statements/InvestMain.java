package statements;

import java.util.Scanner;

public class InvestMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Investment app");
        System.out.println("Amount of invesment:");
        int fund = scanner.nextInt();
        System.out.println("Investment rate:");
        int interestRate = scanner.nextInt();

        Investment investment = new Investment(fund, interestRate);

        System.out.println("Fund: " + investment.getFund());
        System.out.println("Yield for 50 days: " + investment.getYield(50));
        System.out.println("Amount withdrawn after 80 days: " + investment.close(80));
        System.out.println("Amount withdrawn after 90 days: " + investment.close(90));

    }

}
