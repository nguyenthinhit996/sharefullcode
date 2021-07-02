package hibernatebasic.B2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.engine.spi.EntityEntry;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.service.ServiceRegistry;

import hibernatebasic.entity.FootballPlayer;

public class HibernateLifecycleUtil {

	private static SessionFactory sessionfatory;
	private static Connection connection;

	/**
	 * @return the sessionfatory
	 */
	public static SessionFactory getSessionfatory() {
		return sessionfatory;
	}

	/**
	 * @param sessionfatory the sessionfatory to set
	 */
	public static void setSessionfatory(SessionFactory sessionfatory) {
		HibernateLifecycleUtil.sessionfatory = sessionfatory;
	}

	/**
	 * @return the connection
	 */
	public static Connection getConnection() {
		return connection;
	}

	/**
	 * @param connection the connection to set
	 */
	public static void setConnection(Connection connection) {
		HibernateLifecycleUtil.connection = connection;
	}

	public static void init() throws ClassNotFoundException, FileNotFoundException, IOException, SQLException {

		Properties pro = getPropertiesHibernate();
		
		String url = pro.getProperty("hibernate.connection.url");
		String username = pro.getProperty("hibernate.connection.username");
		String password = pro.getProperty("hibernate.connection.password");
		Class.forName(pro.getProperty("hibernate.connection.driver-class-name"));
		connection = DriverManager.getConnection(url, username, password);

		ServiceRegistry serviceRegistry = configurationServiceRegistry();

		sessionfatory = getSessionFactoryBuilder(serviceRegistry).applyInterceptor(new DirtyDataInspector()).build();
	}

	private static ServiceRegistry configurationServiceRegistry() throws FileNotFoundException, IOException {
		Properties properties = getPropertiesHibernate();
		return new StandardServiceRegistryBuilder().applySettings(properties).build();
	}

	private static Properties getPropertiesHibernate() throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		URL propertiesURL = Thread.currentThread().getContextClassLoader().getResource("test.properties");
		try (FileInputStream input = new FileInputStream(propertiesURL.getFile())) {
			properties.load(input);
		}
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		return properties;
	}

	private static SessionFactoryBuilder getSessionFactoryBuilder(ServiceRegistry serviceregistry) {
		MetadataSources metadatasource = new MetadataSources(serviceregistry);
		metadatasource.addAnnotatedClass(FootballPlayer.class);

		Metadata metadata = metadatasource.buildMetadata();
		return metadata.getSessionFactoryBuilder();
	}

	public static void tearDown() throws SQLException {
		sessionfatory.close();
		connection.close();
	}

	public static List<EntityEntry> getManagedEntities(Session session) {
		Map.Entry<Object, EntityEntry>[] entries = ((SessionImplementor) session).getPersistenceContext()
				.reentrantSafeEntityEntries();
		return Arrays.stream(entries).map(e -> e.getValue()).collect(Collectors.toList());
	}
	
	public static Transaction startTransaction(Session s) {
		Transaction tran = s.beginTransaction();
		return tran;
	}
	
	public static int queryCount(String sql) throws SQLException {
		ResultSet resultSet = connection.createStatement().executeQuery(sql);
		  if(resultSet.next()) {
			  resultSet.getInt(1);
		  }
		  return 0;
	}
}
