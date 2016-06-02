import java.util.Objects;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[100000];
    //int size;


    void clear() {
        for (int i = 0; i < storage.length; i++) {
            storage[i] = null;
        }

    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                return;
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
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && uuid.equals(storage[i].uuid)) {
                storage[i] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int sizeGetAll = size();
        Resume[] result = new Resume[sizeGetAll];
        for (int i = 0; i < sizeGetAll; i++) {
            if (storage[i] != null) {
                result[i] = storage[i];
            }
//            if (storage[i] == null) {
//                break;
//            }
            System.out.println(result[i]);
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

    public String printAll() {
        StringBuffer sb = new StringBuffer();
        for (Resume resume : storage) {
            sb.append(resume);
            sb.append(" ");
        }
        return sb.toString();
    }


}

