package hw2;

public class AntiTheticDecorator {

  double[] AntiTheticVector;

  public AntiTheticDecorator (NormalRandomVectorGenerator gen){
    double[] vector = gen.getVector();
    AntiTheticVector  = new double[vector.length];
    for(int i = 0; i < vector.length ; i++){
      AntiTheticVector[i] = -vector[i];
    }
  }

  public double[] getVector() {
    return AntiTheticVector;
  }

}
