import org.junit.Assert;
import org.junit.Test;


/**
 * Created with IntelliJ IDEA.
 * User: arshad
 * Date: 25/12/13
 * Time: 11:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class SportTest {

    @Test
    public void testCricketSport(){
        Sport sport = Sport.SportFactory.getSportObject(SportName.CRICKET);
        Assert.assertTrue(sport.getName() == SportName.CRICKET);
    }
    @Test
    public void testHockeySport(){
        Sport sport = Sport.SportFactory.getSportObject(SportName.HOCKEY);
        Assert.assertTrue(sport.getName() == SportName.HOCKEY);
    }
    @Test
    public void testFootballSport(){
        Sport sport = Sport.SportFactory.getSportObject(SportName.FOOTBALL);
        Assert.assertTrue(sport.getName() == SportName.FOOTBALL);
    }
    @Test
    public void testTennisSport(){
        Sport sport = Sport.SportFactory.getSportObject(SportName.TENNIS);
        Assert.assertTrue(sport.getName() == SportName.TENNIS);
    }
}
