package com.urise.webapp.storage;


import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by OK on 12.11.2016.
 */
public abstract class AbstractArrayStorageTest extends  AbstractStorageTest{
    protected AbstractArrayStorageTest(Storage storage){
        super(storage);
    }

    //TODO remain only for Arrays implementations
    @Test(expected = StorageException.class)
    public void saveOverFlow() throws Exception {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("Name" + i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        storage.save(new Resume("Overflow"));
    }
}