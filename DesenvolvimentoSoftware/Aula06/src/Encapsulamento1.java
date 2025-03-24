
class Person {
    private String name;
    private int yearOld;

    public int getYearOld() {
        return yearOld;
    }

    public void setYearOld(int yearOld) {
        if (yearOld >= 0) {
            this.yearOld = yearOld;
        } else {
            System.out.println("Idade Inválida!");
        }
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
}

public class Encapsulamento1 {
    public static void main(String[] args) {

        Person p = new Person();

        p.setYearOld(-5);
        p.setName("Eduardo");
        p.setYearOld(21);

        System.out.printf("%s, tem %d anos de idade!", p.getName(), p.getYearOld());

    }
}
