package com.urise.webapp.storage;

import com.urise.webapp.Config;


/**
 * Created by OK on 10.12.2016.
 */
public class SqlStorageTest extends AbstractStorageTest {

    public SqlStorageTest() {
        super(Config.get().getStorage());
    }
}