package relativeentity.manytomany;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import relativeentity.entitys.manytomanypojo.CompositeCourse;
import relativeentity.entitys.manytomanypojo.CompositeStudent;
import relativeentity.hibernateconfiguration.HibernateUtilNormal;

public class UseNewIDInTableTrungGiang {
	public static void main(String[] args) {
		 
		SessionFactory sessionFactory = HibernateUtilNormal.getSessionFactory();
		Session session =sessionFactory.openSession();
		
		//TypedQuery of JPA use Table entity
		String sqlTypeQuery = "Select u from CompositeStudent u ";
		List<CompositeStudent> ds = sessionFactory.createEntityManager().createQuery(sqlTypeQuery,CompositeStudent.class).getResultList();	
		ds.stream().forEach(System.out::println);
		
		
		System.out.println("---------------------------------Cretiate of JPA------------------------------");
		CriteriaBuilder criteriaBuilder = sessionFactory.getCriteriaBuilder();
		CriteriaQuery<CompositeCourse> criteriaQuery = criteriaBuilder.createQuery(CompositeCourse.class);
		Root<CompositeCourse> root = criteriaQuery.from(CompositeCourse.class);
		criteriaQuery.select(root);
		List<CompositeCourse> dsCourse = session.createQuery(criteriaQuery).getResultList();
		dsCourse.stream().flatMap(s->{
			System.out.println(s);
			return s.getDsStuCourseFFF().stream();
		}).forEach(System.out::println);
		
		session.close();
}
}
