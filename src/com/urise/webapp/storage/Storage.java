package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


/**
 * Array based storage for Resumes
 */
public interface Storage {
    //int size = 0;

    void clear();

    Object getSearchKey(String uuid);

    void update(Resume r);


    void save(Resume r);


    Resume get(String uuid);


    void delete(String uuid);

    List<Resume> getAllSorted();
    //Resume[] getAll();
    // Return sorted by name
    // List<Resume> getAllSorted;

    int getSize();

}