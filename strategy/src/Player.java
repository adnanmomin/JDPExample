import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: arshad
 * Date: 25/12/13
 * Time: 11:10 PM
 * To change this template use File | Settings | File Templates.
 */


public interface Player{

    SportName getSportName();
    void addScore(float score);
    float totalScore();
    float matchesPlayed();
    class PlayerFactory {
        public static Player createPlayer(SportName sportName){
            switch (sportName) {
                case CRICKET:
                    return new CricketPlayer();
                case FOOTBALL:
                    return new FootballPlayer();
                case HOCKEY:
                    return new HockeyPlayer();
                case TENNIS:
                    return new TennisPlayer();
                default:
                    throw new RuntimeException("Unknown sports!");
            }
        }
    }
}

class Human implements Player{
    private String name;
    private int age;
    private String[] history;
    private Player player;

    public Human(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return this.name +": " + this.player.getSportName();
    }
    @Override
    public SportName getSportName() {
        return player.getSportName();
    }

    @Override
    public void addScore(float score) {
        player.addScore(score);
    }

    @Override
    public float totalScore() {
        return player.totalScore();
    }

    @Override
    public float matchesPlayed() {
        return player.matchesPlayed();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        Sport sport = null;
        if(this.player != null){
            sport = Sport.SportFactory.getSportObject(
                    this.player.getSportName());
            sport.removePlayer(this);
        }

        this.player = player;
        sport = Sport.SportFactory.getSportObject(
                this.player.getSportName());
        sport.addPlayer(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getHistory() {
        return history;
    }

    public void setHistory(String[] history) {
        this.history = history;
    }
}

abstract class AbstractPlayer implements Player{

    final protected Sport sport;
    protected List<Float> scores = new ArrayList<Float>();

    public AbstractPlayer(SportName sportName){
        this.sport = Sport.SportFactory.getSportObject(sportName);
    }

    @Override
    public SportName getSportName() {
        return sport.getName();
    }

    @Override
    public void addScore(float score) {
        scores.add(score);
    }

    @Override
    public float totalScore() {
        float average = 0f, sum = 0f;
        for(Float score : scores){
            sum += score;
        }
        average = sum / scores.size();
        return average;
    }

    @Override
    public float matchesPlayed() {
        return scores.size();
    }
}


class CricketPlayer extends AbstractPlayer {

    public CricketPlayer(){
        super(SportName.CRICKET);
    }
}
class FootballPlayer extends AbstractPlayer {
    public FootballPlayer(){
        super(SportName.FOOTBALL);
    }
}
class HockeyPlayer extends AbstractPlayer {
    public HockeyPlayer(){
        super(SportName.HOCKEY);
    }
}
class TennisPlayer extends AbstractPlayer {
    public TennisPlayer(){
        super(SportName.TENNIS);
    }
}