import java.util.HashMap;
/**
 * Created by joesun on 6/12/17.
 */
public class Payment {
    private String paymentType;
    private String description;
    private String payer;
    private double cost;
    private HashMap<String, Double> debtors;

    public Payment(String paymentType, String description, String payer, double cost) {
        this.paymentType = paymentType;
        this.description = description;
        this.payer = payer;
        this.cost = cost;
        debtors = new HashMap<>();
    }

    public void addDebtor(String p, double fraction) {
        debtors.put(p, fraction);
    }

    public String getType() {
        return paymentType;
    }

    public String getDescription() {
        return description;
    }

    public String getPayer() {
        return payer;
    }

    public double getTotalCost() {
        return cost;
    }

    public double getDebt(String p) {
        if (debtors.keySet().contains(p)) {
            return cost * (debtors.get(p));
        } else {
            return 0;
        }
    }
}
