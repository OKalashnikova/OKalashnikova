package com.urise.webapp.storage;

/**
 * Created by OK on 12.11.2016.
 */
public class ArrayStorageTest extends AbstractStorageTest {

    // Вызвали конструктор - проинициализировали storage, который будет тестироваться
    public ArrayStorageTest() {
        super(new ArrayStorage());
    }
}