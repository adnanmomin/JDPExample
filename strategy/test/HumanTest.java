import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: arshad
 * Date: 26/12/13
 * Time: 12:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class HumanTest {

    @Test
    public void testHumanPlayer(){
        Human human = new Human("Arshad Ansari", 29);
        human.setPlayer(Player.PlayerFactory.createPlayer(SportName.CRICKET));
        Sport sport = Sport.SportFactory.getSportObject(SportName.CRICKET);
        for (Player p : sport.getPlayers()){
            System.out.println((Human) p);
        }
        Assert.assertTrue(human.getSportName() == SportName.CRICKET);
        human.setPlayer(Player.PlayerFactory.createPlayer(SportName.FOOTBALL));
        sport = Sport.SportFactory.getSportObject(SportName.FOOTBALL);
        for (Player p : sport.getPlayers()){
            System.out.println((Human) p);
        }
        Assert.assertTrue(human.getSportName() == SportName.FOOTBALL);
    }
}
