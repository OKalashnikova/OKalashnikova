package com.urise.webapp.storage;

import com.urise.webapp.storage.serializer.JsonStreamSerializer;


/**
 * Created by OK on 10.12.2016.
 */
public class JsonPathStorageTest extends AbstractStorageTest {

    public JsonPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new JsonStreamSerializer() ));
    }
}