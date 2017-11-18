/**
 * Created by joesun on 6/12/17.
 */
public class Person {
    private String name;
    private double debt;
    private double credit;

    /**
     * Creates a new person with a name.
     * @param name the name of the person
     */
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

    /**
     * adds amount debt
     * @param amount the amount of debt to be added
     */
    public void addDebt(double amount) {
        debt += amount;
    }

    /**
     * adds amount credit
     * @param amount the amount of credit to be added
     */
    public void addCredit(double amount) {
        credit += amount;
    }

    public boolean inDebt() {
        return this.debt > this.credit;
    }
}
