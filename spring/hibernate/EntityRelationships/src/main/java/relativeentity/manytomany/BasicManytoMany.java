package relativeentity.manytomany;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import relativeentity.entitys.manytomanypojo.Course;
import relativeentity.entitys.manytomanypojo.Student;
import relativeentity.hibernateconfiguration.HibernateUtilNormal;

public class BasicManytoMany {

	public static void main(String[] args) {
		 
			SessionFactory sessionFactory = HibernateUtilNormal.getSessionFactory();
			Session session =sessionFactory.openSession();
			
			//TypedQuery of JPA use Table entity
			String sqlTypeQuery = "Select u from Student u ";
			List<Student> ds = sessionFactory.createEntityManager().createQuery(sqlTypeQuery,Student.class).getResultList();	
			ds.stream().forEach(System.out::println);
			
			
			System.out.println("---------------------------------Cretiate of JPA------------------------------");
			CriteriaBuilder criteriaBuilder = sessionFactory.getCriteriaBuilder();
			CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
			Root<Course> root = criteriaQuery.from(Course.class);
			criteriaQuery.select(root);
			List<Course> dsCourse = session.createQuery(criteriaQuery).getResultList();
			dsCourse.stream().flatMap(s->{
				System.out.println(s);
				return s.getDsStudent().stream();
			}).forEach(System.out::println);
			
			session.close();
	}
	
}
