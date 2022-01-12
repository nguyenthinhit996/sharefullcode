package copies.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import copies.pojo.Address;
import copies.pojo.User;


/**
 * <li> Use = , constructor, addAll, Collections.copy the contents of both lists will reference the same objects. </li>
 * <li> Using the constructor is good to copy immutable objects </li>
 * <li> Use clone for copy deep in list </li>
 * @author Peter
 *
 */
public class DemoCopyList {

	private List<User> listOriginal = new ArrayList<User>();

	public DemoCopyList() {
		for (int i = 0; i < 10; i++) {
			Address ad = new Address();
			ad.setTP(String.valueOf("Address" + i));

			User user = new User();
			user.setAddress(ad);
			user.setIn(i);
			user.setName("name" + i);
			listOriginal.add(user);
		}
	}
	
	/**
	 *  Use =  the contents of both lists will reference the same objects.
	 * @param lsOriginalParam
	 */
	void copyListByOperator(List<User> lsOriginalParam) {
		
		System.out.println("------------ lsOriginalParam before copy--------------");
		lsOriginalParam.stream().forEach(System.out::println);
		
		System.out.println("------------ lsOriginalParam copy and change--------------");
		List<User> listCopy  = lsOriginalParam;
		User User = listCopy.get(1);
		User.setName("change this");
		
		listCopy.forEach(System.out::println);
		
		System.out.println("------------ lsOriginal after copy--------------");
		lsOriginalParam.stream().forEach(System.out::println);

	}
	
	/**
	 *  Use constructor the contents of both lists will reference the same objects.
	 *  Using the constructor is good to copy immutable objects. (wapper class)
	 */
	void copyListByContructor(List<User> lsOriginalParam) {
		
		System.out.println("------------ lsOriginalParam before copy--------------");
		lsOriginalParam.stream().forEach(System.out::println);
		
		System.out.println("------------ lsOriginalParam copy and change--------------");
		List<User> listCopy  = new ArrayList<User>(lsOriginalParam);
		User User = listCopy.get(1);
		User.setName("change this");
		listCopy.forEach(System.out::println);
		
		System.out.println("------------ lsOriginal after copy--------------");
		lsOriginalParam.stream().forEach(System.out::println);

	}
	
	/**
	 *  Use AddAll the contents of both lists will reference the same objects.
	 */
	void copyListByAddAll(List<User> lsOriginalParam) {
		
		System.out.println("------------ lsOriginalParam before copy--------------");
		lsOriginalParam.stream().forEach(System.out::println);
		
		System.out.println("------------ lsOriginalParam copy and change--------------");
		List<User> listCopy  = new ArrayList<User>();
		listCopy.addAll(lsOriginalParam);
		User User = listCopy.get(1);
		User.setName("change this");
		listCopy.forEach(System.out::println);
		
		System.out.println("------------ lsOriginal after copy--------------");
		lsOriginalParam.stream().forEach(System.out::println);

	}
	
	/**
	 *  Use Collections.copy the contents of both lists will reference the same objects.
	 *  Copy maintain index of source list into dest list, it is override value of dest list
	 */
	void copyListByCollections_copy(List<User> lsOriginalParam) {
		
		System.out.println("------------ lsOriginalParam before copy--------------");
		lsOriginalParam.stream().forEach(System.out::println);
		
		System.out.println("------------ lsOriginalParam copy and change--------------");
		List<User> listCopy  = new ArrayList<User>();
		for (int i = 0; i < 15; i++) {
			Address ad = new Address();
			ad.setTP(String.valueOf("Address listCopy" + i));

			User user = new User();
			user.setAddress(ad);
			user.setIn(i);
			user.setName("name listCopy" + i);
			listCopy.add(user);
		}
		Collections.copy(listCopy, lsOriginalParam);
		User User = listCopy.get(1);
		User.setName("change this");
		
		User User2 = listCopy.get(12);
		User2.setName("change this");
		listCopy.forEach(System.out::println);
		
		System.out.println("------------ lsOriginal after copy--------------");
		lsOriginalParam.stream().forEach(System.out::println);
	}
	
	/**
	 * Use clone method for stream or foreach normal
	 */
	void copyDeepListToList(List<User> lsOriginalParam) {
		
		System.out.println("------------ lsOriginalParam before copy--------------");
		lsOriginalParam.stream().forEach(System.out::println);
		
		System.out.println("------------ lsOriginalParam copy and change--------------");
		// use one in three ways to get listcopy
		List<User> listCopy  = listOriginal.stream().map(User::new).collect(Collectors.toList()); //contructor User(User user)
//		List<User> listCopy  = listOriginal.stream().map(s-> SerializationUtils.clone(s)).collect(Collectors.toList());
//		List<User> listCopy  = listOriginal.stream().map(s-> UserCloneable.clone).collect(Collectors.toList());

		User User = listCopy.get(1);
		User.setName("change this");
		listCopy.forEach(System.out::println);
		
		System.out.println("------------ lsOriginal after copy--------------");
		lsOriginalParam.stream().forEach(System.out::println);
	}

	/**
	 * <li>When use = to copy, Edit and Delete effect on both.  </li>
	 * <li>When use constructor to copy,Call Edit effect on both but call delete on effect to list call method delete, not effect to list others.</li>
	 * @param listOriginal
	 */
	static void demoCopyAfterThatDeleteElement(List<User> listOriginal ) {

		List<User> listTemp = new ArrayList<>(listOriginal);
//		for(User s : listOriginal){
//			listTemp.add(s);
//			tempLast = s;
//		}
		User tempLast = listTemp.get(listTemp.size()-1);
		System.out.println("List has just copied");
		System.out.println(listTemp);
		System.out.println("User last of list");
		System.out.println(tempLast);

		System.out.println("++++++++++++ Remove it ++++++++++++==");
		tempLast.setName("changessssss ");
		listTemp.remove(tempLast);
//		User sss = listTemp.get(0);
//		sss.setName("change from copied list");


		System.out.println("List has just copied");
		System.out.println(listTemp);
		System.out.println("User last of list");
		System.out.println(tempLast);
		System.out.println("List original");
		System.out.println(listOriginal);

	}

	public static void main(String[] args) {
		DemoCopyList demoCopyList = new DemoCopyList();
		List<User> listOriginal = demoCopyList.listOriginal;
//		demoCopyList.copyListByContructor(listOriginal);
		demoCopyAfterThatDeleteElement(listOriginal);
	}
}
