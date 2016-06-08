import java.util.Objects;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    //int size;


    void clear() {
        int size = size();
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
    }


//    void save(Resume r) {
//        if (size() == storage.length) {
//            System.out.println("К сожалению, место на сервере для хранения резюме закончилось");
//        }
//                storage[size()] = r;
//        }

    void save(Resume r) {
        if (size() == storage.length) {
            System.out.println("К сожалению, место на сервере для хранения резюме закончилось");
        }
        for (int i = 0; i < size(); i++) {
            if (r.equals(storage[i].uuid)) {
                System.out.println("drugoy id");
                break;
            }
        }
        storage[size()] = r;
    }

    Resume get(String uuid) {
        int size = size();
        Objects.requireNonNull(uuid, "uuis must not be null");
        for (int i = 0; i < size; i++) {
            if (storage[i] != null && uuid.equals(storage[i].uuid)) {
                return storage[i];
            }
        }
        System.out.println("К сожалению, резюме такого нет");
        return null;
    }

    void delete(String uuid) {
        int size = size();
        for (int i = 0; i < size; i++) {
            if (storage[i] != null && uuid.equals(storage[i].uuid)) {
                storage[i] = storage[size() - 1];
                storage[size() - 1] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int size = size();
        Resume[] result = new Resume[size()];
        int j = 0;
        for (int i = 0; i < size; i++) {
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