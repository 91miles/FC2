package hw2;

import java.util.List;
import org.apache.commons.math3.util.Pair;
import org.joda.time.DateTime;

public class EuroCallPayOut implements PayOut {

  final private double strikePrice;
  private final int days = 252; 
  
  public EuroCallPayOut(double strikePrice){
    this.strikePrice = strikePrice;
  }

  @Override
  public double getPayout(StockPath path) {
    double payout = path.getPrices().get(path.getPrices().size()-1).getValue();
    return Math.max(payout-strikePrice, 0);
  }


  public static void main(String[] args) {
    StockPathImpl sp = new StockPathImpl(0.0001, 0.01, 152.35, new NormalRandomVectorGenerator());
    EuroCallPayOut payOut = new EuroCallPayOut(165);
    System.out.println(payOut.getPayout(sp));
  }


}
