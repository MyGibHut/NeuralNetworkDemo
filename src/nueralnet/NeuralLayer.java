/*
 * This code is based off the Packt book Neural Network Programming in Java
 * by Fabio Soares and Alan Souza
 * Code may be similar to that of the code found in the book.
 * No copyright infringement intended
 */
package nueralnet;

import java.util.ArrayList;
import nueralnet.math.IActivationFunction;

/**
 *
 * @author Michael Anderson
 */
public abstract class NeuralLayer {
    protected int neuronsInLayer;
    private ArrayList<Neuron> neuron;
    protected IActivationFunction activationFnc;
    protected NeuralLayer previousLayer;
    protected NeuralLayer nextLayer;
    protected ArrayList<Double> input;
    protected ArrayList<Double> output;
    protected int numOfInputs;
    public NeuralLayer(int numberofneurons) {
        this.neuronsInLayer = numberofneurons;
        neuron = new ArrayList<>(numberofneurons);
        output = new ArrayList<>(numberofneurons);
    }
    public NeuralLayer(int numberofneurons, IActivationFunction af) {
        this.neuronsInLayer = numberofneurons;
        neuron = new ArrayList<>(numberofneurons);
        output = new ArrayList<>(numberofneurons);
        activationFnc = af;
    }
    public int getNeuronsInLayer() {
        return neuronsInLayer;
    }
    public ArrayList<Neuron> getListOfNeurons() {
        return neuron;
    }
    public NeuralLayer getPreviousLayer() {
        return previousLayer;
    }
    public void setPreviousLayer(NeuralLayer pl) {
        previousLayer = pl;
    }
    public NeuralLayer getNextLayer() {
        return nextLayer;
    }
    public void setNextLayer(NeuralLayer nl) {
        nextLayer = nl;
    }
    public void init() {
        if(neuronsInLayer >= 0) {
            for(int i=0; i<neuronsInLayer; i++) {
                try {
                    neuron.get(i).setActivationFunction(activationFnc);
                    neuron.get(i).init();
                } catch(IndexOutOfBoundsException ioobe) {
                    neuron.add(new Neuron(numOfInputs, activationFnc));
                    neuron.get(i).init();
                }
            }
        }
    }
    protected void setInputs(ArrayList<Double> inputs) {
        this.numOfInputs=inputs.size();
        this.input = inputs;
    }
    protected ArrayList<Double> getOutputs() {
        return output;
    }
    protected void calc() {
        if(input != null && neuron != null) {
            for(int i=0; i<neuronsInLayer; i++) {
                neuron.get(i).setInputs(this.input);
                neuron.get(i).calc();
                try {
                    output.set(i, neuron.get(i).getOutput());
                } catch(IndexOutOfBoundsException ioobe) {
                    output.add(neuron.get(i).getOutput());
                }
            }
        }
    }
    protected Neuron getNeuron(int i) {
        return neuron.get(i);
    }
    protected void setNeuron(int i, Neuron _neuron) {
        try {
            this.neuron.set(i, _neuron);
        } catch(IndexOutOfBoundsException ioobe) {
            this.neuron.add(_neuron);
        }
    }
}
