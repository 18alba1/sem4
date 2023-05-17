package com.github.view;

/**
 * user interface needs to show an informative message when an exception is caught in the view
 */
public class ErrorMessageHandler
{
    public void errorMessage (Exception exception)
    {
        /**
         * Prints error masager to user
         * @param exception the exception
         */
        System.out.println ("ERROR: " + exception);
    }
}
