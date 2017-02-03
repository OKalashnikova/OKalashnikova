package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OK on 20.11.2016.
 */
public class ListStorage extends AbstractStorage<Integer>{

    private List<Resume> list = new ArrayList<>();

    @Override
    public Integer getSearchKey(String uuid) {
        for(int i = 0; i<list.size(); i++){
            if(list.get(i).getUuid().equals(uuid)){
                return  i;
            }
        }
        return  null;
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey !=null;
    }

    @Override
    protected void doUpdate(Resume r, Integer searchKey) {
        list.set(searchKey, r);
    }

    @Override
    protected void doSave(Resume r, Integer searchKey) {
        list.add(r);
    }

    @Override
    protected Resume doGet(Integer searchKey) {
        return list.get(searchKey);
    }

    @Override
    protected void doDelete(Integer searchKey) {
        list.remove(searchKey.intValue());
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override

//    public Resume[] getAll() {
//        return list.toArray(new Resume[list.size()]); // пустой массив заполняет нашими значениями
//    }
    public List<Resume> doCopyAll(){
        return new ArrayList<>(list);
    }

    @Override
    public int getSize() {
        return list.size();
    }













//    private final static String UUID_1 = "uuid1";
//    private static final Resume RESUME_1 = new Resume(UUID_1);
//
//    private final static String UUID_2 = "uuid2";
//    private static final Resume RESUME_2 = new Resume(UUID_2);
//
//    private final static String UUID_3 = "uuid3";
//    private static final Resume RESUME_3 = new Resume(UUID_3);
//
//    private final static String UUID_4 = "uuid4";
//    private static final Resume RESUME_4 = new Resume(UUID_4);
//
//    public static void main(String[] args) {
//        List listStorage = new ArrayList<>();
//        listStorage.add(RESUME_1);
//        listStorage.add(RESUME_2);
//        listStorage.add(RESUME_3);
//        listStorage.add(RESUME_4);
//
//        System.out.println(listStorage.toString());
//
//        listStorage.remove(RESUME_3);
//        System.out.println(listStorage.toString());
//
//        System.out.println(listStorage.indexOf(RESUME_4));
//    }


}
