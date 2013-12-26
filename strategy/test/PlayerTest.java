import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: arshad
 * Date: 25/12/13
 * Time: 11:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlayerTest {

    @Test
    public void testCricketPlayer(){
        Player player = Player.PlayerFactory.createPlayer(SportName.CRICKET);
        Assert.assertTrue(player.getSportName() == SportName.CRICKET);
    }

    @Test
    public void testFootballPlayer(){
        Player player = Player.PlayerFactory.createPlayer(SportName.FOOTBALL);
        Assert.assertTrue(player.getSportName() == SportName.FOOTBALL);
    }
    @Test
    public void testTennisPlayer(){
        Player player = Player.PlayerFactory.createPlayer(SportName.TENNIS);
        Assert.assertTrue(player.getSportName() == SportName.TENNIS);
    }
    @Test
    public void testHockeyPlayer(){
        Player player = Player.PlayerFactory.createPlayer(SportName.HOCKEY);
        Assert.assertTrue(player.getSportName() == SportName.HOCKEY);
    }
}
