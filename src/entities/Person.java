package entities;

public class Person implements Payable, Comparable<Person> {
    private int id;
    private String name;
    private String surname;

    public Person() {}

    public Person(int id, String name, String surname) {
        setId(id);
        setName(name);
        setSurname(surname);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public String getPosition(){
        return "Unemployed";
    }

    @Override
    public String toString() {
        return id + ". " + name + " " + surname;
    }

    @Override
    public double getPaymentAmount() {
        return 0;
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
