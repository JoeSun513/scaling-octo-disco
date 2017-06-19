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

    /**
     * Constructs a group with people and payments
     * @param id a unique identifier for the group
     * @param title denotes the name of the group
     */
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

    /**
     * Adds a new member to the group
     * @param name the new person to be added
     */
    public void addMember(String name) {
        Person newMember = new Person(name);
        members.add(newMember);
    }

    /**
     * gets the member of a group by his/her position in the list
     * @param position the index to get in the list of members
     * @return a member corresponding to the position in the list
     */
    public Person getMember(int position) {
        return members.get(position);
    }

    /**
     * Adds a new payment to the group
     * @param paymentType the category the payment is for, ex. food, entertainment, rent
     * @param description the description of the payment
     * @param payer the Person object that corresponds to the person paying
     * @param cost the payment cost
     * @param debtorMap a map of Person objects to debt/credit in the group
     */
    public void addPayment(String paymentType, String description, Person payer, double cost,
                           HashMap<Person, Double> debtorMap) {
        Payment newPayment = new Payment(paymentType, description, payer, cost);
        newPayment.addDebtors(debtorMap);
        payments.add(newPayment);
    }

    /**
     * gets the debt of a member
     * @param position the index to get in the list of members
     * @return the debt of a member
     */
    private double getDebt(int position) {
        return members.get(position).getDebt();
    }

    /**
     * gets the credit of a member
     * @param position the index to get in the list of members
     * @return the credit of a member
     */
    private double getCredit(int position) {
        return members.get(position).getCredit();
    }

    /**
     * gets the net debt/credit of a member
     * @param position the index to get in the list of members
     * @return the net debt/credit of a member, positive if
     * does not owe, negative if owes, 0 otherwise
     */
    private double getDifference(int position) {
        return members.get(position).getDifference();
    }

    /**
     * gets the differences of all members in the group
     * @return a map of Person objects to the difference
     * in credit and debt of each member
     */
    public HashMap<Person, Double> getDifferenceMap() {
        HashMap<Person, Double> differenceMap = new HashMap<>();
        for (Person p : members) {
            differenceMap.put(p, p.getDifference());
        }
        return differenceMap;
    }
}
