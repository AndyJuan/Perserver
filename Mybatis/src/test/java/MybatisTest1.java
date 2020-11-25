import dao.IUserDao;
import entities.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest1 {
//    /**
//     * 入门案例
//     * @param args
//     */
//    public static void main(String[] args)throws Exception {
//        //1.读取配置文件
//        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        //2.创建SqlSessionFactory工厂
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory factory = builder.build(in);
//        //3.使用工厂生产SqlSession对象
//        SqlSession session = factory.openSession();
//        //4.使用SqlSession创建Dao接口的代理对象
//        IUserDao userDao = session.getMapper(IUserDao.class);
//        //5.使用代理对象执行方法
//        List<User> users = userDao.findAll();
//        for(User user : users){
//            System.out.println(user);
//        }
//        //6.释放资源
//        session.close();
//        in.close();
//    }

    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before//用于在测试方法执行之前执行
    public void init() throws Exception {
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession();
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy() throws Exception {
        //提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindOne() {
        User user = userDao.findById(2);
        System.out.println(user);
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("modify User property");
        user.setAddress("北京市顺义区");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.saveUser(user);
        System.out.println("保存操作之前：" + user); //5.执行保存方法 userDao.saveUser(user); System.out.println("保存操作之后："+user);// }
    }

    /**
     * 测试删除操作
     */
    @Test
    public void testDelete() {
        //5.执行删除方法
        userDao.deleteUser(48);
    }

    /**
     * 模糊查询
     */
    @Test
    public void testFindByname() {
        List<User> users = userDao.findByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }


    /**
     * 测试模糊查询操作
     */
    @Test
    public void testFindByName() {
        //5.执行查询一个方法
        //  List<User> users = userDao.findByName("%王%");
        List<User> users = userDao.findByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试查询总记录条数
     */
    @Test
    public void testFindTotal(){
        //5.执行查询一个方法
        int count = userDao.findTotal();
        System.out.println(count);
    }


}
