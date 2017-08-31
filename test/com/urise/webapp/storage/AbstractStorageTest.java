package com.urise.webapp.storage;


import com.urise.webapp.Config;
import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.*;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static com.urise.webapp.TestData.*;
import static org.junit.Assert.*;


/**
 * Created by OK on 12.11.2016.
 */
public abstract class AbstractStorageTest {
    protected static final File STORAGE_DIR = Config.get().getStorageDir();
    protected Storage storage;



    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(R1);
        storage.save(R2);
        storage.save(R3);
    }

    @Test
    public void getSize() throws Exception {
        assertSize(3);
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void get() throws Exception {
        assertGet(R1);
        assertGet(R2);
        assertGet(R3);
    }


    @Test
    public void getAllSorted() throws Exception {
        List<Resume> list = storage.getAllSorted();
        assertEquals(3, list.size());
        List<Resume> sortedResumes = Arrays.asList(R1, R2, R3);
        Collections.sort(sortedResumes);
        assertEquals(sortedResumes, list);
    }


    @Test
    public void update() throws Exception {
        Resume newResume = new Resume(UUID_1, "New Name");
        R1.addContact(ContactType.MAIL, "mail@google.com");
        R1.addContact(ContactType.SKYPE, "NewSkype");
        R1.addContact(ContactType.MOBILE, "+3 8097 9797979");
        storage.update(newResume);
        assertTrue(newResume.equals(storage.get(UUID_1)));
    }

    @Test
    public void save() throws Exception {
        storage.save(R4);
        assertSize(4);
        assertGet(R4);
        //       assertEquals(RESUME_4, storage.get(UUID_4));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_1);
        assertSize(2);
        storage.get(UUID_1);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        storage.save(R1);
    }


//    @Test(expected = NotExistStorageException.class)
//    public void updateNotExist() throws Exception {
//        storage.save(RESUME_1);
//    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete("dummy");
    }

    private void assertSize(int size) {
        assertEquals(size, storage.getSize());
    }

    private void assertGet(Resume r) {
        assertEquals(r, storage.get(r.getUuid()));
    }


}