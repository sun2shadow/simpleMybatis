package test;


import com.shadow.foretaste.entity.Account;
import com.shadow.foretaste.entity.UserInfo;
import com.shadow.foretaste.util.MyBatisUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.session.SqlSession;
import static org.junit.Assert.*;
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
    
    @Test
    public void testInsertOne(){
        SqlSession sqlSession = MyBatisUtils.getSession();
        UserInfo userInfo = new UserInfo();
        userInfo.setNickname("sunny");
        userInfo.setPhoneNum("18936896033");
        sqlSession.insert("insertUser", userInfo);
        sqlSession.commit();
        LOG.log(Level.INFO, "userId:"+userInfo.getId());
        sqlSession.close();
    }
    @Test
    public void testgetUserInfoById(){
        SqlSession sqlSession = MyBatisUtils.getSession();
        UserInfo userInfo = sqlSession.selectOne("getUserInfoById", 10);
        assertTrue(userInfo != null);
        LOG.log(Level.INFO, userInfo.getNickname());
    }
    @Test
    public void testgetPhoneNum(){
        SqlSession sqlSession = MyBatisUtils.getSession();
        String phone_num = sqlSession.selectOne("getPhoneNum", 10);
        LOG.log(Level.INFO, phone_num);
        assertFalse(phone_num.isEmpty());
    }
    @Test
    public void testgetInfoAndAccount(){
        SqlSession sqlSession = MyBatisUtils.getSession();
        UserInfo userInfo = sqlSession.selectOne("getInfoAndAccount", 9);
        assertNotNull(userInfo);
        Account account = userInfo.getAccount();
//        assertNotNull(account);
        LOG.log(Level.INFO, "userInfo{0}:account{1}", new Object[]{userInfo, account.getId()});
    }
    
    @Test
    public void testinsertAccount(){
        SqlSession sqlSession = MyBatisUtils.getSession();
        Account account = new Account();
        account.setUserId(9);
        account.setMoney(BigDecimal.valueOf(25));
        int accountId = sqlSession.insert("insertAccount", account);
        sqlSession.commit();
        LOG.log(Level.INFO, "accountId:" + accountId);
    }
}
