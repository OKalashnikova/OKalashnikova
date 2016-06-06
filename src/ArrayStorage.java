import java.util.Objects;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[7];
    //int size;


    void clear() {
        int size=size();
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }

    }

    void save(Resume r) {
        int size = size();
        if (size == storage.length) {
            System.out.println("К сожалению, место на сервере для хранения резюме закончилось");
        }
        if (size==0){
            storage[0]=r;
        }else {
            for (int i = 0; i < size; i++) {
                if (storage[i] == null) {
                    storage[i] = r;
                    return;
                }
            }
        }
    }

    Resume get(String uuid) {
        Objects.requireNonNull(uuid, "uuis must not be null");
        for (int i = 0; i < storage.length; i++) {
            Resume resume = storage[i];
            if (resume != null && uuid.equals(resume.uuid)) {
                return resume;
            }
        }
        return null;
    }

    void delete(String uuid) {
        int size = size();
        for (int i = 0; i < size; i++) {
            if (storage[i] != null && uuid.equals(storage[i].uuid)) {
                storage[i] = storage[size()-1];
                storage[size()-1] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] result = new Resume[size()];
        int j = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                result[j] = storage[i];
                j++;
            }
        }
        return result;
    }

    int size() {
        int size = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                size++;
            }
        }
        return size;
    }

}