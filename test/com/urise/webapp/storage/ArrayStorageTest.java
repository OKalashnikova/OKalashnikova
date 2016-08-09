package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by O&J on 31.07.2016.
 */
public class ArrayStorageTest extends AbstractArrayStorageTest{
    private Storage storage = new ArrayStorage();
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";




    @Test
    public void getIndex() throws Exception {
    }

    @Test(expected = NullPointerException.class)
    public void save() throws Exception {
        Storage storageTest = new ArrayStorage();
        storageTest.save(new Resume("uuid1"));
        Assert.assertArrayEquals(storage, storageTest);
        fail("ups");
    }




    @Test
    public void delete() throws Exception {

    }

}