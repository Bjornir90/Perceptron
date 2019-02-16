import neuralnetwork.DataPoint;
import neuralnetwork.Perceptron;


public class Main {

    public static double line(double x){
        return 2.1*x+3.1;
    }

    public static void main(String[] args) {
        //Initialisation of datas
        DataPoint points[] = new DataPoint[5000];
        double maxX = 400.0, maxY = 400.0;
        for(int pointIndex = 0; pointIndex < points.length; pointIndex++){
            double x = Math.random()*maxX;
            double y = Math.random()*maxY;
            double label = 1.0;
            if(y <= line(x)) label = -1.0;
            points[pointIndex] = new DataPoint(x, y, label);
        }
        //Actual computations
        Perceptron pc = new Perceptron(3, 0.001);
        for(int trainingIteration = 0; trainingIteration<10; trainingIteration++) {
            for (int iteration = 0; iteration < points.length; iteration++) {
                pc.train(points[iteration].getData(), points[iteration].getLabel());
            }
        }
        double totalError = 0.0;
        for(int iteration = 0; iteration<points.length; iteration++){
            if(pc.compute(points[iteration].getData()) != points[iteration].getLabel()){
                System.out.println("Perceptron made a mistake");
                totalError++;
            }
        }
        System.out.println("Final result : "+pc.getCoef()+"*x + "+pc.getConst());
        System.out.println("Error percentage : "+totalError/(double)points.length+"%");
    }
}
