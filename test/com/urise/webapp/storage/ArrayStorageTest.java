package com.urise.webapp.storage;

import static org.junit.Assert.*;

/**
 * Created by OK on 12.11.2016.
 */
public class ArrayStorageTest extends AbstractArrayStorageTest{

    // Вызвали конструктор - проинициализировали storage, который будет тестироваться
    public ArrayStorageTest() {
        super(new ArrayStorage());
    }
}