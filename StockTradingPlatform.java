import java.util.*;

class Stock {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Portfolio {
    Map<String, Integer> holdings = new HashMap<>();
    double balance = 10000; // starting money

    void buy(Stock stock, int quantity) {
        double cost = stock.price * quantity;
        if (cost > balance) {
            System.out.println("Not enough balance to buy.");
        } else {
            balance -= cost;
            holdings.put(stock.name, holdings.getOrDefault(stock.name, 0) + quantity);
            System.out.println("Bought " + quantity + " of " + stock.name);
        }
    }

    void sell(Stock stock, int quantity) {
        int held = holdings.getOrDefault(stock.name, 0);
        if (held < quantity) {
            System.out.println("You don't own enough stocks to sell.");
        } else {
            balance += stock.price * quantity;
            holdings.put(stock.name, held - quantity);
            System.out.println("Sold " + quantity + " of " + stock.name);
        }
    }

    void showPortfolio() {
        System.out.println("\n--- Portfolio ---");
        System.out.println("Balance: $" + balance);
        holdings.forEach((stock, qty) -> System.out.println(stock + ": " + qty + " shares"));
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Portfolio user = new Portfolio();

        List<Stock> market = List.of(
            new Stock("TCS", 3300),
            new Stock("INFY", 1500),
            new Stock("RELIANCE", 2800)
        );

        while (true) {
            System.out.println("\n--- Stock Market ---");
            for (int i = 0; i < market.size(); i++) {
                System.out.println((i + 1) + ". " + market.get(i).name + " - ₹" + market.get(i).price);
            }

            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();

            if (option >= 1 && option <= 3) {
                Stock stock = market.get(option - 1);
                System.out.print("Buy(1) or Sell(2)? ");
                int action = sc.nextInt();
                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();

                if (action == 1)
                    user.buy(stock, qty);
                else if (action == 2)
                    user.sell(stock, qty);
            } else if (option == 4) {
                user.showPortfolio();
            } else {
                break;
            }
        }

        sc.close();
    }
}
