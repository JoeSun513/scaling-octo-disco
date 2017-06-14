import java.util.ArrayList;
import java.util.HashMap;
/**
 * Created by joesun on 6/12/17.
 */
public class Group {
    private int id;
    private String title;
    private HashMap<String, Person> members;
    private ArrayList<Payment> payments;

    public Group(int id, String title) {
        this.id = id;
        this.title = title;
        members = new HashMap<>();
        payments = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void addMember(String name) {
        Person newMember = new Person(name);
        members.put(name, newMember);
    }

    public void addPayment(String paymentType, String description, Person payer, double cost,
                           HashMap<Person, Double> debtorMap) {
        Payment newPayment = new Payment(paymentType, description, payer, cost);
        newPayment.addDebtors(debtorMap);
        payments.add(newPayment);
    }

    private double getDebt(String name) {
        return members.get(name).getDebt();
    }

    private double getCredit(String name) {
        return members.get(name).getCredit();
    }

    private double getDifference(String name) {
        return members.get(name).getDifference();
    }

    public HashMap<Person, Double> getDifferenceMap() {
        HashMap<Person, Double> differenceMap = new HashMap<>();
        for (Person p : members.values()) {
            differenceMap.put(p, p.getDifference());
        }
        return differenceMap;
    }
}
