package com.urise.webapp.exception;

/**
 * Created by OK on 11.11.2016.
 */
public class ExistStorageException extends StorageException{
    public ExistStorageException(String uuid) {
        super("Resume " + uuid + " already exist", uuid);
    }
}
