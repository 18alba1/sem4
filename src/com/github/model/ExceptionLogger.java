package com.github.model;

/**
 * An error report for developers, logs errors when caught.
 */
public class ExceptionLogger 
{
    /**
     * Logs error message
     * 
     * @param exception the excpetion that was caught
     */
    public void errorLog (Exception exception)
    {
        System.out.println ("Developer error: " + exception);
    }
}
