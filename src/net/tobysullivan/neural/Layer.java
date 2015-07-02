package net.tobysullivan.neural;

public class Layer {
    int numNodes, numInputs;
    double[][] weights;
    double[] baseWeights;

    public Layer(int numNodes, int numInputs) {
        this.numNodes = numNodes;
        this.numInputs = numInputs;
        this.weights = new double[numNodes][numInputs];
        this.baseWeights = new double[numNodes];

        for (int i = 0; i < numNodes; i++) {
            this.baseWeights[i] = 0.0;
            for (int j = 0; j < numInputs; j++) {
                this.weights[i][j] = 0.0;
            }
        }
    }

    public double[] computeOutputs(double[] inputs) {
        double[] output = new double[numNodes];

        for (int i = 0; i < numNodes; i++) {
            output[i] = computeOutput(i, inputs);
        }

        return output;
    }

    private double computeOutput(int node, double[] inputs) {
        double sum = baseWeights[node];
        for(int i = 0; i < numInputs; i++) {
            sum += weights[node][i] * inputs[i];
        }

        // Sigmoid activation function
        return Math.pow((1.0 + Math.pow(Math.E, 0 - sum)), -1);
    }
}
