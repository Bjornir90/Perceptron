package neuralnetwork;

public class Perceptron {
	private double [] weights;
	double learningRate;

	public Perceptron(int numberOfInputs, double learningRate) {
		weights = new double[numberOfInputs];
		for(int i = 0; i<numberOfInputs; i++){
			weights[i] = Math.random()*2.0-1.0;//Random weights between -1 and 1
		}
		this.learningRate = learningRate;
	}

	public double compute(double [] inputs){
		if(inputs.length != weights.length){
			System.err.println("Inputs length does not match weights length");
			System.exit(1);
		}
		double sum = 0.0;
		for(int i = 0; i < inputs.length; i++){
			sum += weights[i]*inputs[i];
		}
		return activation(sum);
	}

	public void train(double [] inputs, double expected){
		double guess = compute(inputs);
		double error = expected - guess;
		double correction = error*learningRate;
		for(int i = 0; i < inputs.length; i++){
			weights[i] += correction*inputs[i];
		}
	}

	private double activation(double input){
		if(input <= 0.0) return -1;
		return 1;
	}

	public double getCoef(){
		return -weights[0]/weights[1];
	}

	public double getConst(){
		return -weights[2]/weights[1];
	}
}
