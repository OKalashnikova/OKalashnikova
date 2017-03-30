package com.urise.webapp.storage;

/**
 * Created by OK on 10.12.2016.
 */
public class ObjectStreamStorageTest extends AbstractStorageTest {

    public ObjectStreamStorageTest() {
        super(new ObjectStreamStorage(STORAGE_DIR));
    }
}