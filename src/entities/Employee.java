package entities;

public class Employee extends Person {
    private String position;
    private double salary;

    public Employee(int id, String name, String surname, String position, Double salary) {
        super(id, name, surname);
        setPosition(position);
        setSalary(salary);
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String getPosition() {
        return position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee: " + super.toString();
    }

    @Override
    public double getPaymentAmount(){
        return salary;
    }

    @Override
    public int compareTo(Person o) {
        if (this.getPaymentAmount() > o.getPaymentAmount()) {
            return 1;
        } else if (this.getPaymentAmount() < o.getPaymentAmount()) {
            return -1;
        } else {
            return 0;
        }
    }
}
