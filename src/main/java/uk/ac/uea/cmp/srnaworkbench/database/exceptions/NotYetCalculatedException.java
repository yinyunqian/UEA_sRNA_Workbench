/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.uea.cmp.srnaworkbench.database.exceptions;

/**
 * Throw this if something in the database wasn't calculated when you needed it and
 * probably indicates that something was set up wrong in the programming of the pipeline.
 * i.e. this only recoverable through reprogramming to calculate some values before now.
 * @author Matthew Beckers
 */
public class NotYetCalculatedException extends DatabaseRuntimeException {

    public NotYetCalculatedException(String string) {
        super(string);
    }
    
}