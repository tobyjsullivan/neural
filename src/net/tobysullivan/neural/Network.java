package net.tobysullivan.neural;

public class Network {
    Layer[] layers;

    public Network(int[] nodesPerLayer) {
        layers = new Layer[nodesPerLayer.length];

        // Skip first layer which is just input layer
        for (int i = 1; i < nodesPerLayer.length; i++) {
            layers[i] = new Layer(nodesPerLayer[i], nodesPerLayer[i - 1]);
        }
    }
}
