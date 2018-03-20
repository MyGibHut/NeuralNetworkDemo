/*
 * This code is based off the Packt book Neural Network Programming in Java
 * by Fabio Soares and Alan Souza
 * Code may be similar to that found in the book.
 * No copyright infringement intended
 */
package nueralnet;

import java.util.ArrayList;
import nueralnet.math.IActivationFunction;

/**
 *
 * @author themi
 */
public class NeuralNet {
    private InputLayer inputLayer;
    private ArrayList<HiddenLayer> hiddenLayer;
    private OutputLayer outputLayer;
    private int numberOfHiddenLayers;
    private int numberOfInputs;
    private int numberOfOutputs;
    private ArrayList<Double> input;
    private ArrayList<Double> output;
    
    public NeuralNet(int numberofinputs, int numberofoutputs, 
            int [] numberofhiddenneurons, IActivationFunction[] hiddenAcFnc, 
            IActivationFunction outputAcFnc) {
        numberOfInputs = numberofinputs;
        numberOfOutputs = numberofoutputs;
        numberOfHiddenLayers = numberofhiddenneurons.length;
        if(numberOfHiddenLayers == hiddenAcFnc.length) {
            input = new ArrayList<>(numberOfInputs);
            inputLayer = new InputLayer(numberOfInputs);
            if(numberOfHiddenLayers > 0)
                hiddenLayer = new ArrayList<>(numberOfHiddenLayers);
            for(int i=0; i<numberOfHiddenLayers; i++) { 
                if(i == 0) {
                    try {
                        hiddenLayer.set(i, new HiddenLayer(numberofhiddenneurons[i], hiddenAcFnc[i], inputLayer.getNumberOfNeuronsInLayer()));
                    } catch(IndexOutOfBoundsException uoobe) {
                        hiddenLayer.add(new HiddenLayer(numberofhiddenneurons[i], hiddenAcFnc[i], inputLayer.getNumberOfNeuronsInLayer()));
                    }
                    inputLayer.setNextLayer(hiddenLayer.get(i));
                } else {
                    try {
                        hiddenLayer.set(i, new HiddenLayer(numberofhiddenneurons[i], hiddenAcFnc[i], hiddenLayer.get(i-1).getNeuronsInLayer()));
                    }catch(IndexOutOfBoundsException ioobe) {
                        hiddenLayer.add(new HiddenLayer(numberofhiddenneurons[i], hiddenAcFnc[i], hiddenLayer.get(i-1).getNeuronsInLayer()));
                    }
                    hiddenLayer.get(i-1).setNextLayer(hiddenLayer.get(i));
                }
            }
        }
    }
}
