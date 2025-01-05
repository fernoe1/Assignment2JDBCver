import entities.Payable;
import entities.Person;

import utils.DBManager;

import java.util.ArrayList;
import java.util.Collections;

public class MainApplication {
    public static void main(String[] args) {
        String connectionUrl = "jdbc:postgresql://localhost:1987/simpledb";
        DBManager dbManager = new DBManager();
        dbManager.connect(connectionUrl, "postgres", "130924");
        ArrayList<Person> people = new ArrayList<>();

        people.addAll(dbManager.getEmployees());
        people.addAll(dbManager.getStudents());

        Collections.sort(people);
        ArrayList<Payable> payables = new ArrayList<>(people);
        printData(payables);
    }

    public static void printData(Iterable <Payable> payables) {
        for (Payable payable : payables) {
            System.out.println(payable + " earns " + payable.getPaymentAmount() + " tenge");
        }
    }
}
