package URise.HomeWork1;

public class MainArray {
    public static void main(String[] args) {
        ArrayStorage resumeStorage = new ArrayStorage();
        resumeStorage.addResume(new Resume(1, " Первый"));
        resumeStorage.addResume(new Resume(2, " Второй"));
        resumeStorage.addResume(new Resume(3, " Третий"));
        resumeStorage.addResume(new Resume(4, " Четвертый"));

        System.out.println(resumeStorage);
    }
}