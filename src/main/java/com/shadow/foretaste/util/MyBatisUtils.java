package com.shadow.foretaste.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author sunny
 */
public class MyBatisUtils {
    private static SqlSessionFactory factory = null;
    private static final Logger LOG = Logger.getLogger(MyBatisUtils.class.getName());
    
    //初始化session工厂
    public static void initFactory() throws Exception{
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        factory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    /**
     * 获取sqlSession会话
     * @return 
     */
    public static SqlSession getSession(){
        
        if(null == factory){
            try {
                initFactory();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        LOG.log(Level.INFO, "====factory"+(null==factory));
        return factory.openSession();
    }
}
