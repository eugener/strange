/*
 * BSD 3-Clause License
 *
 * Copyright (c) 2018, 2019, Gluon Software
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * * Neither the name of the copyright holder nor the names of its
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.gluonhq.strange;

/**
 *
 * @author johan
 */
public class Qubit {

    private Complex alpha;
    private Complex beta;

    private double theta = 0;
    private double phi = 0;
    
    private boolean measured = false;
    private boolean measuredValue;
    
    private double prob;

    /**
     * Creates a qubit. The qubit will be in the |0> state
     */
    public Qubit() {
        this.alpha = Complex.ONE;
        this.beta = Complex.ZERO;
    }

    /**
     * Creates a qubit with an initial value for alpha.
     * The initial state of the qubit is ralpha |0> + (1-ralpha^2)^(1/2) |1>
     * @param ralpha the real part of the alpha coefficient in alfa |0> + beta |1>
     */
    public Qubit (double ralpha) {
        this.alpha = new Complex(ralpha,0);
        this.beta = new Complex(Math.sqrt(1 - ralpha*ralpha), 0);
    }

    private double calculate0() {
        return Math.cos(theta/2);
    }
    
    private Complex calculate1() {
        double s = Math.sin(theta/2);
        return new Complex(Math.cos(phi)*s, Math.sin(phi)*s);
    }
    
    public void setProbability(double p) {
        this.prob = p;
    }
    
    /**
     * Performs a measurement on this qubit.
     * @return <code>0</code> or <code>1</code>
     */
    public int measure() {
//        if (measured) {
//            throw new IllegalStateException("Can't measure an already-measured qubit");
//        }
//        measured = true;
//        measuredValue = Math.random()< prob;
        return measuredValue ? 1 : 0;
    }
    
    public void setMeasuredValue (boolean v) {
        this.measuredValue = v;
    }
    
    public double getProbability() {
        return this.prob;
    }
    
    
    
    
}
