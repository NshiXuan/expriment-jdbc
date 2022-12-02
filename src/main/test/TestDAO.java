import com.sx.bean.Favor;
import com.sx.dao.FavorsDao;
import org.junit.Test;
public class TestDAO {
    @Test
    public void testAddFavor(){
        Favor favor = new Favor();
        favor.setGoodId("7");
        favor.setUserId("1");
        FavorsDao dao = new FavorsDao();
        dao.addGood(favor);
        System.out.println(dao.list());
    }
    @Test
    public void testDeleteFavor(){
        Favor favor = new Favor();
        favor.setGoodId("7");
        favor.setUserId("1");
        FavorsDao dao = new FavorsDao();
        dao.deleteGood(favor);
        System.out.println(dao.list());
    }


}
