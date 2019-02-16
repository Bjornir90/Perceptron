package neuralnetwork;

public class DataPoint {
	private double [] data;
	private double label;

	public DataPoint(double x, double y, double label) {
		data = new double[3];
		data[0] = x;
		data[1] = y;
		data[2] = 1.0;
		this.label = label;
	}

	public double[] getData() {
		return data;
	}

	public double getLabel() {
		return label;
	}
}
