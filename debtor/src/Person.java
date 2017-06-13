import java.util.ArrayList;
/**
 * Created by joesun on 6/12/17.
 */
public class Person {
    private String name;
    private ArrayList<Payment> debtList;
    private ArrayList<Payment> creditList;
    private double debt;
    private double credit;

    public Person(String name) {
        this.name = name;
        debtList = new ArrayList<>();
        creditList = new ArrayList<>();
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

    public void addDebt(Payment p) {
        debtList.add(p);
        debt += p.getDebt(name);
    }

    public void addCredit(Payment p) {
        creditList.add(p);
        credit += p.getTotalCost();
    }
}
