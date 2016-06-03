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
        Resume[] result = new Resume[size()];
        int j = 0;
        for (int i = 0; i < storage.length; i++) {
             if (storage[i] != null) {
                result[j] = storage[i];
                System.out.println(result[j]);
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

    public String printAll() {
        StringBuffer sb = new StringBuffer();
        for (Resume resume : storage) {
            sb.append(resume);
            sb.append(" ");
        }
        return sb.toString();
    }

}

