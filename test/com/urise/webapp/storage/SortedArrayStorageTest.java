package com.urise.webapp.storage;

/**
 * Created by OK on 12.11.2016.
 */


        // Вызвали конструктор - проинициализировали storage, который будет тестироваться
public class SortedArrayStorageTest extends AbstractArrayStorageTest {

    public SortedArrayStorageTest() {
        super(new SortedArrayStorage());
    }
}