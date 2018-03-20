/*
 * This code is based off the Packt book Neural Network Programming in Java
 * by Fabio Soares and Alan Souza
 * Code may be similar to that of the code found in the book.
 * No copyright infringement intended
 */
package nueralnet;

import nueralnet.math.IActivationFunction;

/**
 *
 * @author Michael Anderson
 */
public class HiddenLayer extends NeuralLayer{
    private int numberOfHiddenNeurons;
    
    public HiddenLayer(int numberofhiddenneurons, IActivationFunction activationFunction, int neuronsInLayer) {
        super(neuronsInLayer);
        this.activationFnc = activationFunction;
        numberOfHiddenNeurons = numberofhiddenneurons;
    }

    public HiddenLayer(int numberofneurons) {
        super(numberofneurons);
    }
    
    /*
    public HiddenLayer(int a, IActivationFunction activationFnc, int neuronsInLayer) {
        
    }*/
}
