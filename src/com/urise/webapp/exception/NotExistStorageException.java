package com.urise.webapp.exception;


/**
 * Created by OK on 11.11.2016.
 */
public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String uuid) {
        super("Resume " + uuid + " not exist", uuid);
    }
}
