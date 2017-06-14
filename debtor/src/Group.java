import java.util.ArrayList;
import java.util.HashMap;
/**
 * Created by joesun on 6/12/17.
 */
public class Group {
    private int id;
    private String title;
    private ArrayList<Person> members;
    private ArrayList<Payment> payments;

    public Group(int id, String title) {
        this.id = id;
        this.title = title;
        members = new ArrayList<>();
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
        members.add(newMember);
    }

    public Person getMember(int position) {
        return members.get(position);
    }

    public void addPayment(String paymentType, String description, Person payer, double cost,
                           HashMap<Person, Double> debtorMap) {
        Payment newPayment = new Payment(paymentType, description, payer, cost);
        newPayment.addDebtors(debtorMap);
        payments.add(newPayment);
    }

    private double getDebt(int position) {
        return members.get(position).getDebt();
    }

    private double getCredit(int position) {
        return members.get(position).getCredit();
    }

    private double getDifference(int position) {
        return members.get(position).getDifference();
    }

    public HashMap<Person, Double> getDifferenceMap() {
        HashMap<Person, Double> differenceMap = new HashMap<>();
        for (Person p : members) {
            differenceMap.put(p, p.getDifference());
        }
        return differenceMap;
    }
}
