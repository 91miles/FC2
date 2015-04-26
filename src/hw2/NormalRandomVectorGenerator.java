package hw2;

import org.apache.commons.math3.random.GaussianRandomGenerator;
import org.apache.commons.math3.random.JDKRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;

public class NormalRandomVectorGenerator implements RandomVectorGenerator {

  private final int days = 252;

  @Override
  public double[] getVector() {
    double arr[]=new double[days];
    RandomGenerator rg = new JDKRandomGenerator();
    rg.setSeed(System.currentTimeMillis());
    GaussianRandomGenerator grg = new GaussianRandomGenerator(rg);
    for(int i=0; i<days; i++){
      arr[i]=grg.nextNormalizedDouble();
    }
    return arr;
  }


  public static void main(String[] args) {
    NormalRandomVectorGenerator gen = new NormalRandomVectorGenerator();
    for(int i=0; i<gen.getVector().length; i++){
      System.out.println(gen.getVector()[i]);
    }
  }

}
