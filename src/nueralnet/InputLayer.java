/*
 * This code is based off the Packt book Neural Network Programming in Java
 * by Fabio Soares and Alan Souza
 * Code may be similar to that of the
 code found in the book.
 * No copyright infringement intended
 */
package nueralnet;

/**
 *
 * @author Michael Anderson
 */
public class InputLayer {
    private int numberOfInputs;
    public int getNumberOfInputs() { return numberOfInputs; }
    
    private int numberOfNeuronsInLayer;
    public int getNumberOfNeuronsInLayer() { return numberOfNeuronsInLayer; }
    
    private NeuralLayer nextLayer;
    public NeuralLayer getNextLayer() { return nextLayer; }
    public void setNextLayer(NeuralLayer next) { nextLayer = next; }
    
    
    public InputLayer(int numberofinputs) {
        numberOfInputs = numberofinputs;
    }
    
    
}
