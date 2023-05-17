package com.github.integration;

/**
 * This exception is thrown to indicate that the database can not be called.
 */
public class DatabaseFailureException extends Exception
{
    /**
     * Constructs a new instance indicating that there is an issue with the database server.
     */
    public DatabaseFailureException ()
    {
        super ("ERROR :  Failed to connect with database server.");
    }
}
