/*
 * This code is based off the Packt book Neural Network Programming in Java
 * by Fabio Soares and Alan Souza
 * Code may be similar to that found in the book.
 * No copyright infringement intended
 */
package nueralnet;

import java.util.ArrayList;
import nueralnet.math.IActivationFunction;
import nueralnet.math.RandomNumberGenerator;

/**
 *
 * @author Michael Anderson
 */
public class Neuron {
    protected ArrayList<Double> weight;
    private ArrayList<Double> input;
    private Double output;
    private Double outputBeforeActivation;
    private int numberOfInputs = 0;
    protected Double bias = 1.0;
    private IActivationFunction activationFunction;
    
    public Neuron(int inputs, IActivationFunction af) {
        numberOfInputs = inputs;
        weight = new ArrayList<>(inputs+1);
        input = new ArrayList<>(inputs);
        activationFunction = af;
    }
    
    public void init() {
        for(int i=0; i<numberOfInputs; i++) {
            double newWeight = RandomNumberGenerator.GenerateNext();
            try {
                this.weight.set(i, newWeight);
            } catch(IndexOutOfBoundsException ioobe) {
                this.weight.add(newWeight);
            }
        }
    }
    
    public void calc() {
        outputBeforeActivation = 0.0;
        if(numberOfInputs > 0) {
            if(input != null && weight != null) {
                for(int i=0; i<numberOfInputs; i++) {
                    outputBeforeActivation += (i==numberOfInputs?bias:input.get(i))*weight.get(i);
                }
            }
        }
        output = activationFunction.calc(outputBeforeActivation);
    }
    
    public void setActivationFunction(IActivationFunction af) {
        this.activationFunction = af;
    }
    public void setInputs(ArrayList<Double> inputs) {
        this.input = inputs;
    }
    public Double getOutput() {
        return output;
    }
}
