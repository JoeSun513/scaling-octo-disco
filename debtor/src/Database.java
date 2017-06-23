import java.util.HashMap;

/**
 * Created by alexyang on 6/22/17.
 */
public class Database {

    private HashMap<String, Group> groups;
    private int numGroups;

    public Database() {
        groups = new HashMap<>();
        numGroups = 0;
    }

    public Database(Group g) {
        groups = new HashMap<>();
        groups.put(g.getTitle(), g);
        numGroups++;
    }

    public void addGroup(Group g) {
        groups.put(g.getTitle(), g);
        numGroups++;
    }

    public int getNumGroups() {
        return numGroups;
    }

    public Group search(String title) {
        return groups.get(title);
    }
}

