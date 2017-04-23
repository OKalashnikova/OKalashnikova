package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.serializer.StreamSerializer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by OK on 22.02.2017.
 */
public class FileStorage extends AbstractStorage<File> {

    private File directory;
    private StreamSerializer streamSerializer;

    //protected abstract void doWrite(Resume r, OutputStream os) throws IOException;
   // protected abstract Resume doRead(InputStream is) throws IOException;

    protected FileStorage(File directory, StreamSerializer streamSerializer) {
        Objects.requireNonNull(directory, "directory must not be null");

        this.streamSerializer = streamSerializer;
        if(!directory.isDirectory()){
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if(!directory.canRead() || !directory.canWrite()){
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
        this.directory = directory;
    }

    @Override
    public void clear() {
        File[] files = directory.listFiles();
        if(files != null) {
            for (File file : files){
                doDelete(file);
            }
        }

    }

    @Override
    public int getSize()
    {
        String[] list = directory.list();
        if (list == null){
            throw new StorageException("Directory read arror");
        }
        return list.length;
    }

    @Override
    public File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected void doUpdate(Resume r, File file) {
        try {
            streamSerializer.doWrite(r, new BufferedOutputStream(new FileOutputStream(file)));
        } catch (IOException e) {
            throw new StorageException("File write error", r.getUuid(), e);
        }
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected void doSave(Resume r, File file) {
        try {
            file.createNewFile();
        } catch (IOException e) {
           throw new StorageException("Couldn't create file " + file.getAbsolutePath(), file.getName(), e);
        }
        doUpdate(r, file);
    }



    @Override
    protected void doDelete(File file) {
        if(!file.delete()){
            throw new StorageException("File delete error", file.getName());
        }
    }

    @Override
    protected Resume doGet(File file) {
        try {
            return streamSerializer.doRead(new BufferedInputStream(new FileInputStream(file)));
        } catch (IOException e) {
            throw new StorageException("File write error", file.getName(), e);
        }
    }

    @Override
    protected List<Resume> doCopyAll()
    {
        File[] files = directory.listFiles();
        if (files == null){
            throw new StorageException("Directory read error");
        }
        List<Resume> list = new ArrayList<>(files.length);
        for( File file : files){
            list.add(doGet(file));
        }
        return list;
    }
}
