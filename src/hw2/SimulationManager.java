package hw2;

import org.apache.commons.math3.distribution.NormalDistribution;

public class SimulationManager {

  private StockPath path;
  private StatisticalCollector stats;
  final double accuracy;
  final double probability;

  //Use NormalDistribution in Commons Math to calculate y
  NormalDistribution nd; 
  final double y;

  public SimulationManager(StockPath path,StatisticalCollector stats) {
    this.path = path;
    this.stats = stats; 
    accuracy = 0.01;
    probability = 0.99;
    nd = new NormalDistribution();
    y = nd.inverseCumulativeProbability((probability + 1) / 2);
  }

  public double priceOption(PayOut payout) {
    long N;
    double variance;
    double error = 10;
    //When the estimated error is smaller than accuracy, stop simulation
    while (Math.abs(error - accuracy) > 0.001) {
      double price = payout.getPayout(path);
      stats.addValue(price);
      variance = stats.getVariance();
      N = stats.getSize();
      error = y*Math.sqrt(variance)/Math.sqrt(N);
    }
    System.out.println("Simulated " + stats.getSize() + " times.");

    return stats.getMean();
  }
}
