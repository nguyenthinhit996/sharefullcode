package relativeentity.JPAJoinTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.sql.JoinType;

import relativeentity.entitys.entitysach.TableR;
import relativeentity.entitys.entitysach.TableS;
import relativeentity.hibernateconfiguration.HibernateUtilNormal;

public class DemoJoin {

	static void autoJoin() {
		System.out.println("------------------Query----------------------");
		SessionFactory sessionFactory = HibernateUtilNormal.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select u from TableR u", TableR.class);
		query.getResultList().stream().forEach(System.out::println);
		session.close();

		System.out.println("------------------TypedQuery----------------------");
		TypedQuery<TableR> typedQuery = sessionFactory.createEntityManager().createQuery("select u from TableR u",
				TableR.class);
		List<TableR> lsCollection = typedQuery.getResultList();
		lsCollection.stream().forEach(System.out::println);
	}

	// auto join with collection not where This is because a path expression can't
	// continue from a collection-valued association
	static void autoJoinVsCollectionAndCLass() {
		SessionFactory sessionFactory = HibernateUtilNormal.getSessionFactory();
		System.out.println("------------------Auto Join TypedQuery return Collection----------------------");
		TypedQuery<Collection> typedQuery = sessionFactory.createEntityManager()
				.createQuery("select u.listTableS from TableR u", Collection.class);
		List<Collection> lsCollection = typedQuery.getResultList(); // nên nhớ trả về chỉ là đúng kiểu của listTableS
																	// luôn
		for (int i = 0; i < lsCollection.size(); i++) {
			TableS ss = (TableS) lsCollection.get(i);
			System.out.println(ss);
		}

		System.out.println(
				"------------------Inner Join TypedQuery return TablS instead of Collection.class----------------------");
		TypedQuery<TableS> typedQuery1 = sessionFactory.createEntityManager()
				.createQuery("SELECT vari FROM TableR u JOIN u.listTableS vari", TableS.class);
		List<TableS> lsCollection1 = typedQuery1.getResultList();
		for (int i = 0; i < lsCollection1.size(); i++) {
			TableS ss = (TableS) lsCollection1.get(i);
			System.out.println(ss);
		}
	}

	// inner join để sử dụng collection trong where | use name param :name , use
	// position sử dụng ?1 ?2 ?3
	static void innerJoinGetCollection() {
		SessionFactory sessionFactory = HibernateUtilNormal.getSessionFactory();
		System.out.println("------------------TypedQuery----------------------");
		TypedQuery<TableS> typedQuery = sessionFactory.createEntityManager().createQuery(
				"SELECT vari FROM TableR u JOIN u.listTableS vari WHERE vari IS NOT NULL AND u.id = :idTableR",
				TableS.class);
		Integer paraIdtableR = 1;
		List<TableS> lsCollection = typedQuery.setParameter("idTableR", paraIdtableR).getResultList();
		for (int i = 0; i < lsCollection.size(); i++) {
			TableS ss = (TableS) lsCollection.get(i);
			System.out.println(ss);
		}
	}

	// outer join
	static void tableR_Left_Join_TableS() {
		SessionFactory sessionFactory = HibernateUtilNormal.getSessionFactory();
		System.out.println("------------------TableR get TableR----------------------");
		TypedQuery<TableR> typedQuery = sessionFactory.createEntityManager()
				.createQuery("SELECT u FROM TableR u LEFT JOIN u.listTableS vari", TableR.class);
		List<TableR> lsCollection = typedQuery.getResultList();
		lsCollection.stream().forEach(System.out::println);

		System.out.println("------------------TableR get listTableS-------------");
		TypedQuery<TableS> typedQuery2 = sessionFactory.createEntityManager()
				.createQuery("SELECT vari FROM TableR u LEFT JOIN u.listTableS vari", TableS.class);
		List<TableS> lsCollection1 = typedQuery2.getResultList(); // nên nhớ trả về chỉ là đúng kiểu của listTableS luôn
		lsCollection1.forEach(System.out::println);
	}

	// outer join
	static void tableS_Left_Join_TableR() {
		SessionFactory sessionFactory = HibernateUtilNormal.getSessionFactory();
		System.out.println("------------------TableS get TableS----------------------");
		TypedQuery<TableS> typedQuery = sessionFactory.createEntityManager()
				.createQuery("SELECT u FROM TableS u LEFT JOIN u.idTableR vari", TableS.class);
		List<TableS> lsCollection = typedQuery.getResultList();
		lsCollection.stream().forEach(System.out::println);

		System.out.println("------------------TableS get TableR----------------------");
		TypedQuery<TableR> typedQuery2 = sessionFactory.createEntityManager()
				.createQuery("SELECT vari FROM TableS u LEFT JOIN u.idTableR vari", TableR.class);
		List<TableR> lsCollection1 = typedQuery2.getResultList(); // nên nhớ trả về chỉ là đúng kiểu của listTableS luôn
		lsCollection1.forEach(System.out::println);
	}
	
	static void ManyToOne_Outer_Join_TableR_TableS() {
		// TableR outer Join Table S
		tableR_Left_Join_TableS();
		
		tableS_Left_Join_TableR();
	}
	
	static void outterJoinWith2Table() {
		
		SessionFactory sessionFactory = HibernateUtilNormal.getSessionFactory();
		System.out.println("------------------TableR get TableR----------------------");
		TypedQuery<TableR> typedQuery = sessionFactory.createEntityManager()
				.createQuery("SELECT u FROM TableR u FULL JOIN u.listTableS vari", TableR.class);
		List<TableR> lsCollection = typedQuery.getResultList();
		lsCollection.stream().forEach(System.out::println);

		System.out.println("------------------TableR get listTableS-------------");
		TypedQuery<TableS> typedQuery2 = sessionFactory.createEntityManager()
				.createQuery("SELECT vari FROM TableR u FULL JOIN u.listTableS vari", TableS.class);
		List<TableS> lsCollection1 = typedQuery2.getResultList(); // nên nhớ trả về chỉ là đúng kiểu của listTableS luôn
		lsCollection1.forEach(System.out::println);
	}

	public static void main(String[] args) {
//		autoJoin();
//		autoJoinVsCollectionAndCLass();
//		innerJoinGetCollection();
//		ManyToOne_Outer_Join_TableR_TableS();
		outterJoinWith2Table();
	}
}
