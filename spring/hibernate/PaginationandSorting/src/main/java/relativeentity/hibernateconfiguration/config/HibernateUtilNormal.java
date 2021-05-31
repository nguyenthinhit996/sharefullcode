package relativeentity.hibernateconfiguration.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtilNormal {
	
    private static SessionFactory sessionFactory;

    private HibernateUtilNormal() {
    }

    public static SessionFactory getSessionFactory() {
        return buildSessionFactory();
    }

    private static SessionFactory buildSessionFactory() {
        try {
            ServiceRegistry serviceRegistry = configureServiceRegistry();

            MetadataSources metadataSources = new MetadataSources(serviceRegistry);

            metadataSources.addAnnotatedClass(relativeentity.hibernateconfiguration.entitys.CompositeStudent.class);
            metadataSources.addAnnotatedClass(relativeentity.hibernateconfiguration.entitys.CompositeCourse.class);
            metadataSources.addAnnotatedClass(relativeentity.hibernateconfiguration.entitys.Student_Course_NewID.class);
             
            
            Metadata metadata = metadataSources.getMetadataBuilder()
                    .build();

            return metadata.getSessionFactoryBuilder()
                    .build();
        } catch (IOException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }


    private static ServiceRegistry configureServiceRegistry() throws IOException {
        Properties properties = getProperties();
        return new StandardServiceRegistryBuilder().applySettings(properties).build();
    }

    private static Properties getProperties() throws IOException {
        Properties properties = new Properties();
        URL propertiesURL = Thread.currentThread()
                .getContextClassLoader()
                .getResource("hibernate.properties");
        try (FileInputStream inputStream = new FileInputStream(propertiesURL.getFile())) {
            properties.load(inputStream);
        }
        return properties;
    }
}