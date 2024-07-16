import java.util.*;

class Stock {
    private final String name;
    private final int numShares;
    private final double sharePrice;

    public Stock(String name, int numShares, double sharePrice) {
        this.name = name;
        this.numShares = numShares;
        this.sharePrice = sharePrice;
    }

    public double calculateValue() {
        return numShares * sharePrice;
    }

    @Override
    public String  toString() {
        return String.format("%s: %d shares at $%.2f per share", name, numShares, sharePrice);
    }
}

class StockPortfolio {
    private final ArrayList<Stock> stocks;

    public StockPortfolio() {
        this.stocks = new ArrayList<>();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public double calculatePortfolioValue() {
        double totalValue = 0;
        for (Stock stock : stocks) {
            totalValue += stock.calculateValue();
        }
        return totalValue;
    }

    public void generateReport() {
        System.out.println("Stock Report");
        System.out.println("-------------");
        for (Stock stock : stocks) {
            System.out.println(stock);
            System.out.printf("Value: $%.2f%n", stock.calculateValue());
            System.out.println("-------------");
        }
        double totalPortfolioValue = calculatePortfolioValue();
        System.out.printf("Total Portfolio Value: $%.2f%n", totalPortfolioValue);
    }
}

public class StockManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockPortfolio portfolio = new StockPortfolio();

        System.out.print("Enter the number of stocks: ");
        int numStocks = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= numStocks; i++) {
            System.out.printf("\nEnter details for stock %d:%n", i);
            System.out.print("Enter stock name: ");
            String name = scanner.nextLine();
            System.out.print("Enter number of shares: ");
            int numShares = scanner.nextInt();
            System.out.print("Enter share price: ");
            double sharePrice = scanner.nextDouble();
            scanner.nextLine();

            Stock stock = new Stock(name, numShares, sharePrice);
            portfolio.addStock(stock);
        }

        System.out.println("\nGenerating Stock Report...\n");
        portfolio.generateReport();

        scanner.close();
    }
}

