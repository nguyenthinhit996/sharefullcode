package relativeentity.hibernateconfiguration.sorts;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import relativeentity.hibernateconfiguration.config.HibernateUtilNormal;
import relativeentity.hibernateconfiguration.entitys.CompositeCourse;
import relativeentity.hibernateconfiguration.entitys.CompositeStudent;

public class Sort {

	static void useQueryToSortingOnEntity() {
		SessionFactory sessionFactory = HibernateUtilNormal.getSessionFactory();
		EntityManager entityManager = sessionFactory.createEntityManager();
		
		// chỉ ra kêt quả của idStudent asc giông vs SQL
		String query = "SELECT u FROM CompositeStudent u ORDER BY u.idStudent asc,  u.age desc"; 
		String queryDes = "SELECT u FROM CompositeStudent u ORDER BY u.idStudent desc";
		List<CompositeStudent> dsAsc = entityManager.createQuery(query, CompositeStudent.class).getResultList();
		dsAsc.stream().forEach(System.out::println);
		System.out.println("-------------------------------------");
		List<CompositeStudent> dsDesc = entityManager.createQuery(queryDes, CompositeStudent.class).getResultList();
		dsDesc.stream().forEach(System.out::println);

	}

	static void useQueryToSortingOnEntity_WithNUll() {
		
		// mặc định nếu order by giá trị bị null thì nó sẽ đầy về cuối hết
		SessionFactory sessionFactory = HibernateUtilNormal.getSessionFactory();
		EntityManager entityManager = sessionFactory.createEntityManager();
		String query = "SELECT u FROM CompositeStudent u ORDER BY u.age asc NULLs FIRST"; // NULLs LAST, NULLs FIRST
		List<CompositeStudent> dsAsc = entityManager.createQuery(query, CompositeStudent.class).getResultList();
		dsAsc.stream().forEach(System.out::println);
	}

	static void Sorting_One_To_Many_Relations() {

		// @OrderBy("idTrungGiang desc") // cột idTrungGiang sẽ giảm dần trong object
		// CompositeStudent
		// private List<Student_Course_NewID> dsStuCourseFFF;
		SessionFactory sessionFactory = HibernateUtilNormal.getSessionFactory();
		EntityManager entityManager = sessionFactory.createEntityManager();
		String query = "SELECT u FROM CompositeStudent u ORDER BY u.id asc NULLs FIRST"; // NULLs LAST, NULLs FIRST
		List<CompositeStudent> dsAsc = entityManager.createQuery(query, CompositeStudent.class).getResultList();
		// get id CompositeStudent 88 ra để check list con Student_Course_NewID có giảm
		// dần ko
		dsAsc.stream().filter(s -> {
			return s.getIdStudent() == 88;
		}).flatMap(objectCompositeStudent -> {
			System.out.println("objectCompositeStudent + id: " + objectCompositeStudent.getIdStudent());
			System.out.println(" Entity child DESC ");
			return objectCompositeStudent.getDsStuCourseDDD().stream();
		}).forEach(System.out::println);

		// @OrderBy("idTrungGiang asc") // cột idTrungGiang sẽ tăng dần trong object
		// CompositeCourse
		// private List<Student_Course_NewID> dsStuCourseFFF;
		String query1 = "SELECT u FROM CompositeCourse u ORDER BY u.id asc NULLs FIRST"; // NULLs LAST, NULLs FIRST
		List<CompositeCourse> dsAsc1 = entityManager.createQuery(query1, CompositeCourse.class).getResultList();
		// get id CompositeStudent 110 ra để check list con Student_Course_NewID có giảm
		// dần ko
		dsAsc1.stream().filter(s -> {
			return s.getIdCourse() == 110;
		}).flatMap(compositeCourse -> {
			System.out.println("CompositeCourse + id: " + compositeCourse.getIdCourse());
			System.out.println(" Entity child ASC ");
			return compositeCourse.getDsStuCourseFFF().stream();
		}).forEach(System.out::println);
	}

	static void Sorting_With_JPA_Criteria_Query_Object_API() {
		SessionFactory sessionFactory = HibernateUtilNormal.getSessionFactory();
		Session session = sessionFactory.openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<CompositeStudent> queryStudent = criteriaBuilder.createQuery(CompositeStudent.class);
		Root<CompositeStudent> root = queryStudent.from(CompositeStudent.class);
		Order oderDesc = criteriaBuilder.desc(root.get("idStudent"));
		Order oderDesc2 = criteriaBuilder.desc(root.get("age"));

		List<CompositeStudent> ds = session.createQuery(queryStudent.orderBy(oderDesc, oderDesc2)).getResultList();
		ds.stream().forEach(System.out::println);

		session.close();
	}

	public static void main(String[] args) {
//		useQueryToSortingOnEntity();

//		useQueryToSortingOnEntity_WithNUll();

//		Sorting_One_To_Many_Relations();

		Sorting_With_JPA_Criteria_Query_Object_API();
	}

}