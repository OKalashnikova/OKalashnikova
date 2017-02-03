package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.List;


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
    // Return sorted by name
    // List<Resume> getAllSorted;

    int getSize();

}