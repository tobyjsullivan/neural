package net.tobysullivan.neural;

public class Neuron {
    private int inputCount;
    private double[] w;
    private double b = 0.0;
    private double learningRate = 0.001;

    public Neuron(int inputCount) {
        this.inputCount = inputCount;
        this.w = new double[inputCount + 1];

        for(int i = 0; i < inputCount + 1; i++) {
            this.w[i] = 0.0;
        }
    }

    public double f(double[] in) {
        if(in.length != inputCount) {
            throw new IllegalArgumentException("Unexpected number of inputCount. Expected: "+ inputCount +", received: "+in.length);
        }

        double sum = w[0];
        for(int i = 0; i < inputCount; i++) {
            sum += w[i+1] * in[i];
        }

        // Sigmoid activation function
        double y = Math.pow((1.0 + Math.pow(Math.E, 0 - sum)), -1);

        return y;
    }

    public void retrain(int i, double input, double expectedOut, double actualOut) {
        double adjustment = learningRate * (expectedOut - actualOut) * input;
        w[i + 1] = w[i + 1] + adjustment;
    }

}
