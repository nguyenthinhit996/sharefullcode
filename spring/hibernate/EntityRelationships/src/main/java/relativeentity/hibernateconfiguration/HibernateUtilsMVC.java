//package relativeentity.hibernateconfiguration;
//
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
//import org.hibernate.cfg.Environment;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//public class HibernateUtils {
//	
//	@Bean
//	public LocalSessionFactoryBean sessionFactory() {		 
//		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//		sessionFactory.setDataSource(dataSource());
//		sessionFactory.setPackagesToScan(new String[] {"relativeentity.entitys"});
//		sessionFactory.setHibernateProperties(getProperties());
//		return sessionFactory;
//	}
//	
//	@Bean 
//	public DataSource dataSource() {
//		Properties pro = getProperties();
//		BasicDataSource datasource = new BasicDataSource();
//		datasource.setDriverClassName(pro.getProperty(Environment.DRIVER));
//		datasource.setUrl(pro.getProperty(Environment.URL));
//		datasource.setUsername(pro.getProperty(Environment.USER));
//		datasource.setPassword(pro.getProperty(Environment.PASS));
//		return datasource;
//	}
//	
//	@Bean
//	PlatformTransactionManager hibernateTransactionManager() {
//		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//		transactionManager.setSessionFactory(sessionFactory().getObject());
//		return transactionManager;
//	}
//
//	private Properties getProperties() {
//		
//		Properties pro = new Properties();
//		pro.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
//		pro.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernatelearningdb");
//		pro.put(Environment.USER, "root");
//		pro.put(Environment.PASS, "123456a");
//		pro.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
//		pro.put(Environment.SHOW_SQL, "true");
//		pro.put(Environment.HBM2DDL_AUTO, "none");
//		
//		// ?
//		pro.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//		
//		return pro;
//	}	 
//	
//	
//}
//
//
// 