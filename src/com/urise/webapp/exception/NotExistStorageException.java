package com.urise.webapp.exception;

/**
 * Created by O&J on 21.07.2016.
 */
public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String uuid) {
        super("Summary with this uuid " + uuid + " doesn't exist", uuid);
    }
}
