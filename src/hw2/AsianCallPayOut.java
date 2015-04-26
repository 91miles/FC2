package hw2;

import java.util.List;

import org.apache.commons.math3.util.Pair;
import org.joda.time.DateTime;

public class AsianCallPayOut implements PayOut{

  final private double strikePrice;
  //private final int days = 252;
  
  public AsianCallPayOut(double strikePrice){
    this.strikePrice = strikePrice;
  }
  
  @Override
  public double getPayout(StockPath path) {
    double sum = 0.0;
    List<Pair<DateTime, Double>> stockPath = path.getPrices();
    
    for(int i=0;i<stockPath.size();i++) {
      sum += stockPath.get(i).getValue();
    }
    double avg = sum/(double)stockPath.size();
    return Math.max(avg-strikePrice, 0);
  }

  
  public static void main(String[] args) {
    StockPathImpl sp = new StockPathImpl(0.0001, 0.01, 152.35, new NormalRandomVectorGenerator());
    // List<Pair<DateTime, Double>> list = sp.getPrices();
    AsianCallPayOut payOut = new AsianCallPayOut(164);
    System.out.println(payOut.getPayout(sp));
  }
  
}
