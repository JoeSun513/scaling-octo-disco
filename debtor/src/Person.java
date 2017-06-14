/**
 * Created by joesun on 6/12/17.
 */
public class Person {
    private String name;
    private double debt;
    private double credit;

    public Person(String name) {
        this.name = name;
        debt = 0;
        credit = 0;
    }

    public String getName() {
        return name;
    }

    public double getDebt() {
        return debt;
    }

    public double getCredit() {
        return credit;
    }

    public double getDifference() {
        return credit - debt;
    }

    public void addDebt(double amount) {
        debt += amount;
    }

    public void addCredit(double amount) {
        credit += amount;
    }
}
