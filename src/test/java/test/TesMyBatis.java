package test;


import com.shadow.foretaste.util.MyBatisUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author sunny
 */
public class TesMyBatis {

    private static final Logger LOG = Logger.getLogger(TesMyBatis.class.getName());
    
    @Test
    public void testMyBatis() throws FileNotFoundException, IOException{

        SqlSession session = MyBatisUtils.getSession();
        assertNotNull(session);
        if(session != null){
            session.close();
        }
    }
}
