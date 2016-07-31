package com.urise.webapp.exception;

/**
 * Created by O&J on 21.07.2016.
 */
public class ExistStorageException extends StorageException{
    public ExistStorageException(String uuid) {
        super("Summary with this uuid " + uuid + " already exist", uuid);
    }
}
