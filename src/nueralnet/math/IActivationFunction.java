/*
 * This code is based off the Packt book Neural Network Programming in Java
 * by Fabio Soares and Alan Souza
 * Code may be similar to that found in the book.
 * No copyright infringement intended
 */
package nueralnet.math;

/**
 *
 * @author Michael Anderson
 */
public interface IActivationFunction {
    public double calc(double d);
    public enum activationFunctionENUM {
        STEP, LINEAR, SIGMOID, HYPERTAN
    }
}
