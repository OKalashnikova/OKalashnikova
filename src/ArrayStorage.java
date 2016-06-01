import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[100000];
    int size;

    void clear() {
    }

    void save(Resume r) {
    }

    Resume get(String uuid) {
        Objects.requireNonNull(uuid, "uuis must not be null");
        for (int i = 0; i < size; i++) {
            Resume resume = storage[i];
            if (uuid.equals(resume.uuid)) {
                return resume;
            }
        }
        return null;
    }

    void delete(String uuid) {
//        for(int i = 0; i<storage.length; i++){
//            if(storage[i] !=null && uuid.equals(storage[i].uuid)){
//                storage[i] = null;
//            }
//        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return new Resume[0];
    }

    int size() {
        return size;
    }
}
