package edu.upc.dsa.queue;

public class FullQueueException extends RuntimeException {
    public FullQueueException(String message){
        super(message);
    }
}