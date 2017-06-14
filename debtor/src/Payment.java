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

    public Payment(String paymentType, String description, Person payer, double cost) {
        this.paymentType = paymentType;
        this.description = description;
        this.payer = payer;
        this.cost = cost;
        debtors = new HashMap<>();
        payer.addCredit(cost);
    }

    private void addDebtor(Person p, double fraction) {
        debtors.put(p, fraction);
        p.addDebt(cost * fraction);
    }

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

    public double getTotalCost() {
        return cost;
    }
}
