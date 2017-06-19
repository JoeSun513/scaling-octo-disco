import java.util.HashMap;
/**
 * Created by joesun on 6/12/17.
 */
public class Payment {
    private String paymentType;
    private String description;
    private Person payer;
    private double cost;
    private HashMap<Person, Double> debtors;

    /**
     * Creates a payment and updates credit of payer.
     * @param paymentType the category the payment is for, ex. food, entertainment, rent
     * @param description the description of the payment
     * @param payer the Person object that corresponds to the person paying
     * @param cost the payment cost
     */
    public Payment(String paymentType, String description, Person payer, double cost) {
        this.paymentType = paymentType;
        this.description = description;
        this.payer = payer;
        this.cost = cost;
        debtors = new HashMap<>();
        payer.addCredit(cost);
    }

    /**
     * adds a new person to the payment
     * @param p the Person too add to the payment
     * @param fraction the fraction of the cost p bears
     */
    private void addDebtor(Person p, double fraction) {
        debtors.put(p, fraction);
        p.addDebt(cost * fraction);
    }

    /**
     * Adds the debt of each person involved in the payment, excluding payer
     * @param debtorMap map of Person objects to the fraction of the cost they bear
     */
    public void addDebtors(HashMap<Person, Double> debtorMap) {
        for (Person p : debtorMap.keySet()) {
            addDebtor(p, debtorMap.get(p));
        }
    }

    public String getType() {
        return paymentType;
    }

    public String getDescription() {
        return description;
    }

    public Person getPayer() {
        return payer;
    }

    public String getPayerName() {
        return payer.getName();
    }

    public double getCost() {
        return cost;
    }
}
