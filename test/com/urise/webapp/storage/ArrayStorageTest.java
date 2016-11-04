package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.Storage;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Created by O&J on 31.07.2016.
 */
public class ArrayStorageTest extends AbstractArrayStorageTest{
    private Storage storage = new ArrayStorage();
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";



//http://stackoverflow.com/questions/22976404/how-to-test-an-array-of-objects-with-junit
    @Test
    public void getIndex() throws Exception {
    }

    @Test(expected = NullPointerException.class)

    public void get() throws Exception {
        Storage storageTest = new ArrayStorage();
        storageTest.save(new Resume("uuid1"));
        storageTest.save(new Resume("uuid2"));
        storageTest.save(new Resume("uuid3"));
        Assert.assertEquals(storage.getIndex("uuid1"), storageTest.getIndex("uuid1"));
        fail("ups");
    }




    @Test
    public void delete() throws Exception {

    }

}