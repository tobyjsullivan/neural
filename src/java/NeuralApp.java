class NeuralApp {

    public static void main(String[] args) {
        System.out.println("Starting app...");

        Neuron myNeuron = new Neuron(4);

        System.out.println("Starting training...");
        for (int k = 0; k < 1000; k++) {
            System.out.print(".");

            for (boolean[] vector : trainingSet) {
                double d = vector[vector.length - 1] ? 0.9 : 0.1;
                double[] x = new double[vector.length - 1];
                for (int i = 0; i < x.length; i++) {
                    x[i] = vector[i] ? 0.9 : 0.1;
                }

                double y = myNeuron.f(x);

                for (int i = 0; i < x.length; i++) {
                    myNeuron.retrain(i, x[i], d, y);
                }
            }
        }
        System.out.println();
        System.out.println("Training complete.");
        System.out.println("Starting evaluation...");

        int score = 0;
        for (boolean[] vector : evaluationSet) {
            boolean d = vector[vector.length - 1];
            double[] x = new double[vector.length - 1];
            for (int i = 0; i < x.length; i++) {
                x[i] = vector[i] ? 0.9 : 0.1;
            }

            double y = myNeuron.f(x);
            int confidence = (int)((Math.abs(y - 0.5) / 0.5) * 100);

            System.out.println("Expected: " + d + ", received: " + y + ". Confidence: "+confidence+"%");

            if (y >= 0.5 == d) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong.");
            }
        }

        System.out.println("Evaluation complete. Score: "+score+"/"+evaluationSet.length);

        System.out.println("Done!");
    }



    private static boolean[][] trainingSet = new boolean[][] {
            // hasLegs, hasFace, hasEars, hasTail, hasFaceNotTail
            {false, false, false, false, false},
            {false, false, false, true, false},
            {false, false, true, false, false},
            {false, false, true, true, false},
            {false, true, false, false, true},
            {true, false, false, false, false},
            {true, false, false, true, false},
            {true, false, true, true, false},
            {true, true, false, false, true},
            {true, true, false, true, false},
            {true, true, true, false, true}
    };

    private static boolean[][] evaluationSet = new boolean[][] {
            // hasLegs, hasFace, hasEars, hasTail, hasFace
            {false, false, false, false, false},
            {false, false, false, true, false},
            {false, false, true, false, false},
            {false, false, true, true, false},
            {false, true, false, false, true},
            {false, true, false, true, false},
            {false, true, true, false, true},
            {false, true, true, true, false},
            {true, false, false, false, false},
            {true, false, false, true, false},
            {true, false, true, false, false},
            {true, false, true, true, false},
            {true, true, false, false, true},
            {true, true, false, true, false},
            {true, true, true, false, true},
            {true, true, true, true, false}
    };
}
