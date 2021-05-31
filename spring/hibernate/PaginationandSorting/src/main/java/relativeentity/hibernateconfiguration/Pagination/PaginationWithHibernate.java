package relativeentity.hibernateconfiguration.Pagination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.query.Query;

import relativeentity.hibernateconfiguration.config.HibernateUtilNormal;
import relativeentity.hibernateconfiguration.entitys.CompositeStudent;

public class PaginationWithHibernate {

	static void ScrollableResultsAPI() {
		int pageSize = 10;
		Session session = HibernateUtilNormal.getSessionFactory().openSession();
		String sql = "FROM CompositeStudent";
		Query<CompositeStudent> query = session.createQuery(sql, CompositeStudent.class);
		ScrollableResults resultScroll = query.scroll(ScrollMode.SCROLL_SENSITIVE);
		resultScroll.afterLast(); // di chuyen ve sau thằng sau cùng là null
		resultScroll.previous();
		List<CompositeStudent> fooPage = new ArrayList<CompositeStudent>();
		fooPage.add((CompositeStudent) resultScroll.get(0));
		fooPage.stream().forEach(System.out::println);

		resultScroll.beforeFirst(); // di chuyển về trước thằng đầu tiên
		resultScroll.next();
		List<CompositeStudent> fooPage1 = new ArrayList<CompositeStudent>();
		fooPage1.add((CompositeStudent) resultScroll.get(0));
		fooPage1.stream().forEach(System.out::println);

//		int i = 0;
//		while (resultScroll.next()) {
//		    fooPage.add((CompositeStudent) resultScroll.get(0));
//		    if (!resultScroll.next())
//		        break;
//		}
//		fooPage.stream().forEach(System.out::println);
		System.out.println();
	}

	static void scrollDone() {

		final Integer pageSizeMaxItem = 50;

		// get count
		String hql = "SELECT u FROM CompositeStudent u";
		Query<CompositeStudent> query = HibernateUtilNormal.getSessionFactory().openSession().createQuery(hql,
				CompositeStudent.class);
		ScrollableResults scroll = query.scroll(ScrollMode.SCROLL_INSENSITIVE);
		scroll.afterLast();
		scroll.last();
		Long countItemInDB = (long) (scroll.getRowNumber() + 1); // The first position is number 0
		System.out.println("CompositeStudent count Db " + countItemInDB);

		// tinh số page dựa vào pageSizeMaxItem
		long numberPage = Long.divideUnsigned(countItemInDB, Long.valueOf(pageSizeMaxItem));
		if (numberPage * pageSizeMaxItem != countItemInDB) {
			numberPage++; // because round
		}
		System.out.println("number page " + numberPage);

		// pagination
		scroll.beforeFirst();
		for (var i = 1; i <= numberPage; i++) {
			int stop = pageSizeMaxItem;
			// scroll sẽ set vị trí current + vị trí truyền vào 
			// trường hợp đầu tiên set là beforeFirst -1 + 0 bằng -1 đi vào scroll.next() = 0 vt đầu tiên
			// trường hợp vào vòng lặp chạy tới 50 dừng do stop.
			// vị trí current 50 + 0 = 50 đi vào next là 51 đúng
			scroll.scroll(0);  
			System.out.println("-------------------Page "+i+" Start--------------------");
			while(stop > 0 && scroll.next()) {
				CompositeStudent com = (CompositeStudent) scroll.get(0);
				System.out.println(com);
				stop--;
			}
			System.out.println("-------------------Page "+i+" End--------------------");
		}

	}

	public static void main(String[] args) {
//		ScrollableResultsAPI();
		scrollDone();
	}

}
