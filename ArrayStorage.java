package URise.HomeWork1;


public class ArrayStorage {
    private Resume[] resumeMas = new Resume[10000];

    public void addResume(Resume resume) {
        for (int i = 0; i < resumeMas.length; i++) {
            Resume r = resumeMas[i];
            if (r == null) { // esli yacheyka massiva ravna null
                resumeMas[i] = resume; // Mi ey prisvaivaem znachenie v klasse Test. Po umolchaniyu massiv pustoy, poetomu zapolnyatsa budet s samogo nachala
                return;
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Resume resume : resumeMas) {
            sb.append(resume);
            sb.append(" ");
        }
        return sb.toString();
    }
}
