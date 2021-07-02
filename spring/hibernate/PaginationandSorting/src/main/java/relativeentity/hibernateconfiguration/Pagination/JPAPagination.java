package relativeentity.hibernateconfiguration.Pagination;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import relativeentity.hibernateconfiguration.config.HibernateUtilNormal;
import relativeentity.hibernateconfiguration.entitys.CompositeStudent;

public class JPAPagination {

	static void Pagination_With_JQL() {
		// mặc định nếu order by giá trị bị null thì nó sẽ đầy về cuối hết
		SessionFactory sessionFactory = HibernateUtilNormal.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("From CompositeStudent");

		int pageNumber = 1; // position page current
		int pageSize = 20; // số lượng entity trong 1 page
		query.setFirstResult((pageNumber - 1) * pageSize); // lấy vị trí bắt đầu của list , 1(1-20) , 2(21-40) ,
															// 3(41-60),...
		// pageNumber là 1 sẽ lấy vị trí từ 1 đến 20
		// pageNUmber là 2 sẽ lây vị trí 21 đến 40 ...
		query.setMaxResults(pageSize); // số lượng entity trong 1 page
		List<CompositeStudent> ds = query.getResultList();
		ds.stream().forEach(System.out::println);

		// get số lương item sử dụng Tquery
		TypedQuery<Long> longCount = sessionFactory.createEntityManager()
				.createQuery("SELECT count(u.idStudent) from CompositeStudent u", Long.class);
		Long countNumberItem = longCount.getSingleResult();
		System.out.println("Number item in DB: " + countNumberItem);

		// get số lượng page có bao nhiêu nếu mỗi page có số lượng là 20;
		pageSize = 20;
		long coutPage_LatPage = Long.divideUnsigned(countNumberItem, Long.valueOf(pageSize)); // 28
		if (coutPage_LatPage * pageSize != countNumberItem) { // 20*28= 560
			coutPage_LatPage++; // bởi vì bị làm tròn nên cộng cho 1, page cuối sẽ có 6 giá trị
		}

		System.out.println(" number of page has (page last): " + coutPage_LatPage);
		System.out.println("value of page last view 6 item not enough 20 item");
		query.setFirstResult((int) ((coutPage_LatPage - 1) * pageSize));
		List<CompositeStudent> ds1 = query.getResultList();
		ds1.stream().forEach(System.out::println);
	}

	static void Pagination_With_JQL_Using_the_Id_of_Entities() {
		// get list if from select *
		SessionFactory sessionFactory = HibernateUtilNormal.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Long> dsAllID = session.createQuery("select u.idStudent from CompositeStudent u", Long.class)
				.getResultList();
		System.out.println("sum item counted: " + dsAllID.size());
		// get giá trị có id từ 1- 10
		System.out.println("get value tu dsAllID.subList(0, 10) ");
		Query query = session.createQuery("select u from CompositeStudent u where u.idStudent in :dsidStudent",
				CompositeStudent.class);
		query.setParameter("dsidStudent", dsAllID.subList(0, 10));
		List<CompositeStudent> dsStudent = query.getResultList();
		dsStudent.forEach(System.out::println);

	}

	public static void Pagination_With_JPA_Using_Criteria_API() {
		SessionFactory sessionFactory = HibernateUtilNormal.getSessionFactory();
		CriteriaBuilder criterialBuilder = sessionFactory.getCriteriaBuilder();
		CriteriaQuery<CompositeStudent> criteriaQuery = criterialBuilder.createQuery(CompositeStudent.class);
		Root<CompositeStudent> root = criteriaQuery.from(CompositeStudent.class);

		CriteriaQuery<CompositeStudent> criteriaQuerySelect = criteriaQuery.select(root);
		// change criteriaQuerySelect to TypeQuery
		TypedQuery<CompositeStudent> typedQuerySelect = sessionFactory.createEntityManager()
				.createQuery(criteriaQuerySelect);
		typedQuerySelect.setFirstResult(0);
		typedQuerySelect.setMaxResults(20);
		List<CompositeStudent> ds = typedQuerySelect.getResultList();
		ds.stream().forEach(System.out::println);

		// get count by Criterial
		CriteriaQuery<Long> coutSumItem = criterialBuilder.createQuery(Long.class);
		coutSumItem.select(criterialBuilder.count(coutSumItem.from(CompositeStudent.class)));

		Long countSum = sessionFactory.createEntityManager().createQuery(coutSumItem).getSingleResult();
		System.out.println("Number Sum All Id: " + countSum);

	}

	static void paginationDone() {

		final int pageItemSize = 50; // each page is has 50 item
		int lastPageNumber = 0; // page last number

		// 1 get all
		SessionFactory sessionFactory = HibernateUtilNormal.getSessionFactory();
		CriteriaBuilder criteriaBuilder = sessionFactory.getCriteriaBuilder();
		CriteriaQuery<Long> countSum = criteriaBuilder.createQuery(Long.class);
		Root<CompositeStudent> rootCountSum = countSum.from(CompositeStudent.class);
		countSum.select(criteriaBuilder.count(rootCountSum));
		Long countSumItem = sessionFactory.createEntityManager().createQuery(countSum).getSingleResult();
		System.out.println("countSumItem in DB :" + countSumItem);
		
		// 2 tinh so page
		lastPageNumber = (int) Long.divideUnsigned(countSumItem, pageItemSize);
		if (lastPageNumber * pageItemSize != countSumItem) {
			lastPageNumber++; // bởi vì page cuối bị thiếu do làm tròn phép chia
		}
		System.out.println("Has " + lastPageNumber + " Page");

		// 3 view moi page
		CriteriaQuery<CompositeStudent> querySelectFollowNumberPage = criteriaBuilder
				.createQuery(CompositeStudent.class);
		Root<CompositeStudent> root = querySelectFollowNumberPage.from(CompositeStudent.class);
		CriteriaQuery<CompositeStudent> querySelectPrepareParseToTypeQuery = querySelectFollowNumberPage.select(root);
		TypedQuery<CompositeStudent> typeQuerySelectRoot = sessionFactory.createEntityManager()
				.createQuery(querySelectPrepareParseToTypeQuery);
		typeQuerySelectRoot.setMaxResults(pageItemSize);

		for (var i = 0; i < lastPageNumber; i++) { // vị trí bắt đầu = 0 bằng với page đầu tiên là 0
			
			typeQuerySelectRoot.setFirstResult(i * pageItemSize); 
			System.out.println("-------------------------- Page" + i + " Start--------------------------");
			List<CompositeStudent> dsItem = typeQuerySelectRoot.getResultList();
			dsItem.forEach(System.out::println);
			System.out.println("-------------------------- Page" + i + " End--------------------------");
		}
	}

	public static void main(String[] args) {
//		Pagination_With_JQL();
//		Pagination_With_JPA_Using_Criteria_API();
		paginationDone();
	}

}
