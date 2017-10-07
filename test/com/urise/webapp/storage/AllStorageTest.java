package com.urise.webapp.storage;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by OK on 15.01.2017.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                ArrayStorageTest.class,
                SortedArrayStorageTest.class,
                ListStorageTest.class,
                MapUuidStorageTest.class,
                MapResumeStorageTest.class,
                ObjectFileStorageTest.class,
                ObjectPathStorageTest.class,
                XmlPathStorageTest.class,
                JsonPathStorageTest.class,
                DataPathStorageTest.class,
                SqlStorageTest.class
        })
public class AllStorageTest {
}
