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
    }

    public void addDebtor(Person p, double fraction) {
        debtors.put(p, fraction);
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

    public double getTotalCost() {
        return cost;
    }

    public double getDebt(Person p) {
        if (debtors.keySet().contains(p)) {
            return cost * (debtors.get(p));
        } else {
            return 0;
        }
    }
}
