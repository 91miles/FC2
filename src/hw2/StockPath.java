package hw2;

import java.util.List;

import org.apache.commons.math3.util.Pair;
import org.joda.time.DateTime;

public interface StockPath{
  
  public List<Pair<DateTime,Double>> getPrices();
  
}