package com.urise.webapp.exception;

/**
 * Created by OK on 11.11.2016.
 */
public class StorageException extends RuntimeException {
    private final String uuid;

    public StorageException(String message, String uuid) {
        super(message);
        this.uuid = uuid;
        }


    public String getUuid() {
        return uuid;
    }
}
