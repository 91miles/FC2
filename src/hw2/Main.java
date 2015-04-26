package hw2;

public class Main {

  public static void main(String[] args) {

    final double r = 0.0001;    //interest rate
    final double sigma = 0.01;    //stock volatility
    final double price0 = 152.35;    //start price
    final double strikePriceAsian = 164;    //Asian call strike price
    final double strikePriceEuro = 165;    //Euro call strike price

    /////////////////////////////// Asian Call Option ///////////////////////////////
    System.out.println("Pricing an Asian Call Option, with sigma=0.01, r=0.0001, price=152.35, strike price=164 ");
    System.out.println("Please wait. ");
    StatisticalCollector stats1 = new StatisticalCollector();
    StockPathImpl sp1 = new StockPathImpl(r, sigma, price0, new NormalRandomVectorGenerator());
    SimulationManager asianOption = new SimulationManager(sp1,stats1);
    double asianPrice = Math.exp(-r*252) * asianOption.priceOption(new AsianCallPayOut(strikePriceAsian));
    System.out.println("Asian Call Option's price: " + asianPrice);

    System.out.println();
    
    /////////////////////////////// Euro Call Option ///////////////////////////////
    System.out.println("Pricing an Euro Call Option, with sigma=0.01, r=0.0001, price=152.35, strike price=165 ");
    System.out.println("Please wait. ");
    StatisticalCollector stats2 = new StatisticalCollector();
    StockPathImpl sp2 = new StockPathImpl(r, sigma, price0, new NormalRandomVectorGenerator());
    SimulationManager euroOption = new SimulationManager(sp2,stats2);
    double euroPrice = Math.exp(-r*252) * euroOption.priceOption(new EuroCallPayOut(strikePriceEuro));
    System.out.println("Euro Call Option's price: " + euroPrice);

  }

}
