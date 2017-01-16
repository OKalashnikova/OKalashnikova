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
                MapUUIDStorageTest.class,
        }
)

public class AllStorageTest {
}
