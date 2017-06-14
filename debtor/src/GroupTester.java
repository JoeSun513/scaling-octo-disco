import java.util.HashMap;
/**
 * Created by joesun on 6/13/17.
 */
public class GroupTester {
    public static void main(String[] args) {
        Group g = new Group(1, "Test");

        g.addMember("Joe");
        g.addMember("Ashley");
        g.addMember("Alice");

        Person joe = g.getMember(0);
        Person ashley = g.getMember(1);
        Person alice = g.getMember(2);

        HashMap<Person, Double> debtorMap1 = new HashMap<>();
        debtorMap1.put(joe, 1.0 / 3);
        debtorMap1.put(alice, 1.0 / 3);
        debtorMap1.put(ashley, 1.0 / 3);

        g.addPayment("Transport", "gas", joe, 30, debtorMap1);

        HashMap<Person, Double> debtorMap2 = new HashMap<>();
        debtorMap2.put(joe, 1.0 / 3);
        debtorMap2.put(alice, 1.0 / 3);
        debtorMap2.put(ashley, 1.0 / 3);

        g.addPayment("Housing", "hotel", ashley, 120, debtorMap1);

        HashMap<Person, Double> debtorMap3 = new HashMap<>();
        debtorMap3.put(joe, 0.0);
        debtorMap3.put(alice, 0.5);
        debtorMap3.put(ashley, 0.5);

        g.addPayment("Food", "cake", alice, 10, debtorMap3);

        HashMap<Person, Double> differenceMap = g.getDifferenceMap();

        for (Person p : differenceMap.keySet()) {
            System.out.println(p.getName() + ", " + differenceMap.get(p));
        }
    }
}
