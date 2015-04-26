package hw2;

public class StatisticalCollector {

  private long size;
  private double mean;
  private double squareMean;
  private double variance;
  
  StatisticalCollector(){
    size=0;
    mean=0;
    variance=0;
    squareMean=0;
  }
  
  public long getSize(){
    return size;
  }
  public void addValue(double value){
    double temp = (double)size/((double)size+1); 
    mean = mean*temp+ value/(size+1); 
    squareMean = squareMean*temp+Math.pow(value, 2)/(size+1); 
    variance = squareMean - Math.pow(mean, 2); 
    size++;
  }
  
  public double getMean(){
    return mean;
  }
  
  public double getSquareMean(){
    return squareMean;
  }
  
  public double getVariance(){
    return variance;
  }
  
  
  public static void main(String[] args) {
    StatisticalCollector stat = new StatisticalCollector();
    stat.addValue(10);
    System.out.println(stat.getMean());
    System.out.println(stat.getSize());
    stat.addValue(10);
    System.out.println(stat.getMean());
    System.out.println(stat.getSize());
    stat.addValue(10);
    System.out.println(stat.getMean());
    System.out.println(stat.getSize());
  }

}
