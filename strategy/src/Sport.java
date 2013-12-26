import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: arshad
 * Date: 25/12/13
 * Time: 11:13 PM
 * To change this template use File | Settings | File Templates.
 */

enum SportName { CRICKET, FOOTBALL, HOCKEY, TENNIS}

public interface Sport {
    public SportName getName();
    public int playerCount();
    public List<Player> getPlayers();
    public void addPlayer(Player player);
    public void removePlayer(Player player);
    class SportFactory {

        private static HashMap<SportName, Sport> sportInstances = new HashMap<SportName, Sport>();

        public static Sport getSportObject(SportName sportName){
            if (!sportInstances.containsKey(sportName)) {
                Sport sport = null;
                switch (sportName) {
                    case CRICKET:
                        sport = new Cricket();
                        break;
                    case FOOTBALL:
                        sport = new Football();
                        break;
                    case HOCKEY:
                        sport = new Hockey();
                        break;
                    case TENNIS:
                        sport = new Tennis();
                        break;
                    default:
                        throw new RuntimeException("Unknown sports!");
                }
                sportInstances.put(sportName, sport);
            }
            return sportInstances.get(sportName);
        }
    }
}



abstract class AbstractSport implements Sport {

    private List<Player> players = new ArrayList<Player>();
    protected SportName sportName;

    @Override
    public SportName getName() {
        return sportName;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int playerCount() {
        return players.size();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Player> getPlayers() {
        return players;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addPlayer(Player player) {
        players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        players.remove(player);
    }
}

class Cricket extends AbstractSport{

    public Cricket() {
        this.sportName = SportName.CRICKET;
    }

}
class Football extends AbstractSport{
    public Football() { this.sportName = SportName.FOOTBALL; }

}
class Hockey extends AbstractSport{
    public Hockey() { this.sportName = SportName.HOCKEY; }

}
class Tennis extends AbstractSport{
    public Tennis() { this.sportName = SportName.TENNIS; }

}