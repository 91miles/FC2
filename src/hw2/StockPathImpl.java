package hw2;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.util.Pair;
import org.joda.time.DateTime;

public class StockPathImpl implements StockPath {

  private double r;
  private double sigma;
  private double price0;
  private RandomVectorGenerator rvg; 
  private final int days = 252;
  private DateTime today;

  // constructor
  public StockPathImpl(double r, double sigma, double price0, RandomVectorGenerator rvg) {
    this.r = r;
    this.sigma = sigma;
    this.price0 = price0;
    this.rvg = rvg;
    this.today = new DateTime();
  }

  @Override
  public List<Pair<DateTime, Double>> getPrices() {
    
    double[] vector = rvg.getVector();
    List<Pair<DateTime,Double>> stockpath = new ArrayList<Pair<DateTime,Double>>();
    double price = price0;
    DateTime dateTime = today;
    for (int i=0;i<days;i++) {
      Double d = new Double(price);
      stockpath.add(new Pair<DateTime,Double>(dateTime, d));
      //Stock prices model
      price = price*Math.exp((r-sigma*sigma/2) + sigma*vector[i]);
      dateTime = getNextWorkDay(dateTime);
    }
    return stockpath;
  }

  public static DateTime getNextWorkDay(DateTime dateTime) {
    DateTime res = dateTime.plusDays(1);
    while(res.getDayOfWeek()>5){
      res =res.plusDays(1);
    }
    return res;
  }

  public static void main(String[] args) {
    //    DateTime dateTime = new DateTime();
    //    dateTime = dateTime.plusDays(-1);
    //    DateTime res = dateTime;
    //    for(int i=0; i<252; i++){
    //      res = getNextWorkDay(res);
    //    }
    //    System.out.println(res.getYear()+"-"+res.getMonthOfYear()+"-"+res.getDayOfMonth()+", Day of "+res.getDayOfWeek());

    StockPath sp = new StockPathImpl(0.0001, 0.01, 152.35, new NormalRandomVectorGenerator());
        List<Pair<DateTime, Double>> list = sp.getPrices();
        // System.out.println(list.size());
        for (Pair<DateTime, Double> pair : list){
          //System.out.println(pair.getKey());
          System.out.println(pair.getValue());
          //System.out.println("------------");
        }
  }


}
