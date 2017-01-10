package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import org.junit.Assert;

/**
 * Created by OK on 10.12.2016.
 */
public class ListStorageTest extends AbstractStorageTest {

    public ListStorageTest() {
        super(new ListStorage());
    }
}