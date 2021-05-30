package hibernatebasic.B2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import hibernatebasic.entity.FootballPlayer;

import static hibernatebasic.B2.DirtyDataInspector.getListDirtyEntity;
import static hibernatebasic.B2.HibernateLifecycleUtil.*;

import static org.assertj.core.api.Assertions.assertThat;

public class HibernateLifecycleUnitTest {

	// getManagedEntities
	// khi save hay update gì thì nó chỉ lưu vào Manager thôi chưa có thực hiện dưới
	// DB
	// nếu muốn thì lệnh transaction.commit

	// getListDirtyEntity
	// chỉ khi commit xong mới xuất hiện các Entity thay đổi so với DB ở đây

	@BeforeClass
	public static void setup() throws ClassNotFoundException, FileNotFoundException, IOException, SQLException {
		HibernateLifecycleUtil.init();
	}

	@AfterClass
	public static void tearDown() throws SQLException {
		HibernateLifecycleUtil.tearDown();
	}

	@Before
	public void beforeMethod() {
		DirtyDataInspector.clearDirtyEntitites();
	}

	@Test
	public void test() {
		Session session = HibernateLifecycleUtil.getSessionfatory().openSession();

		Transaction transaction = startTransaction(session);

		assertThat(getManagedEntities(session)).isEmpty();

		List<FootballPlayer> players = session.createQuery("from FootballPlayer").getResultList();

		assertThat(getManagedEntities(session)).size().isEqualTo(3);

		assertThat(getListDirtyEntity()).isEmpty();
//
		FootballPlayer gigiBuffon = players.stream().filter(p -> p.getId() == 3).findFirst().get();
//
		gigiBuffon.setName("eeeee ggggg");

		System.out.println(getListDirtyEntity().size());

		transaction.commit();
//
		System.out.println(getListDirtyEntity().size());

		assertThat(getListDirtyEntity()).size().isEqualTo(1);
//        assertThat(getListDirtyEntity().get(0).getId()).isEqualTo(3);
//        assertThat(getListDirtyEntity().get(0).getName()).isEqualTo("Gianluigi Buffon");
		  TypedQuery<Collection> query = entityManager.createQuery("SELECT e.phones FROM Employee e", Collection.class);

	        List<Collection> resultList = query.getResultList();
		 assertThat(resultList).extracting("number").containsOnly("111", "222", "333");
	}

	@Test
	public void testDetack() {
		Session session = HibernateLifecycleUtil.getSessionfatory().openSession();

		Transaction transaction = startTransaction(session);

		assertThat(getManagedEntities(session)).isEmpty();

		FootballPlayer cr7 = session.get(FootballPlayer.class, 1L);

		assertThat(getManagedEntities(session).get(0).getId().equals(cr7.getId()));

		session.evict(cr7); // detack entity cr7

		assertThat(getManagedEntities(session)).isEmpty();

		cr7.setName("sdfsdfsdfsdfsd");

		transaction.commit();

		assertThat(getListDirtyEntity()).isEmpty();

		// Session.merge(entity)/Session.update(entity) can (re)attach a session:
		transaction = startTransaction(session);

		FootballPlayer messi = session.get(FootballPlayer.class, 2L);
		session.evict(messi);
		messi.setName("Leo Messi eee");
		transaction.commit();

		assertThat(getListDirtyEntity()).isEmpty();

		transaction = startTransaction(session);

		// acttack by update
		session.update(messi);
		transaction.commit();

		assertThat(getListDirtyEntity()).size().isEqualTo(1);
		assertThat(getListDirtyEntity().get(0).getName()).isEqualTo("Leo Messi eee");

	}

	@Test
	public void testUpdate() {
		Session session = HibernateLifecycleUtil.getSessionfatory().openSession();

		Transaction transaction = startTransaction(session);

		assertThat(getManagedEntities(session)).isEmpty();

		FootballPlayer gigi = new FootballPlayer();
		gigi.setId(3L);
		gigi.setName("Gigi the vssssv");
		session.update(gigi);

		assertThat(getManagedEntities(session)).size().isEqualTo(1);
		assertThat(getListDirtyEntity()).size().isEqualTo(1);
		assertThat(getListDirtyEntity().get(0).getName()).isEqualTo("Gigi the vv");

	}

	@Test
	public void TransientEntity() throws SQLException {

		Session session = HibernateLifecycleUtil.getSessionfatory().openSession();

		Transaction transaction = startTransaction(session);

		FootballPlayer neymar = new FootballPlayer();
		neymar.setName("Neymar");
		session.save(neymar); // chua luu vao DB

		assertThat(getManagedEntities(session)).size().isEqualTo(1);
		// 0 assertThat(getListDirtyEntity()).size().isEqualTo(1);
		assertThat(neymar.getId()).isNotNull();

		assertThat(getManagedEntities(session)).size().isEqualTo(1);
		assertThat(neymar.getId()).isNotNull();

		int count = queryCount("select count(*) from Football_Player where name='Neymar'");

		assertThat(count).isEqualTo(0);

		transaction.commit();
		count = queryCount("select count(*) from Football_Player where name='Neymar'");

		assertThat(count).isEqualTo(1);

	}

}
