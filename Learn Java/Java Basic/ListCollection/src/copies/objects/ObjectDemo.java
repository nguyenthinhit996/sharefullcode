package copies.objects;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;

import copies.pojo.Address;
import copies.pojo.AddressCloneable;
import copies.pojo.User;
import copies.pojo.UserCloneable;

/**
 * Copy object has 3 type
 * <li> Use = use for immutable class ex: {@link Integer} , {@link String} or Wrapper classes {@link Object} </li>
 * <li> Use Cloneable Interface with class has propeties Object reference exaple: (User has properties Address) </li>
 * <li> Use Use Apache Common Lang SerializationUtils.clone(object) with class implements {@link Serializable} </li>
 * @author Peter
 *
 */
public class ObjectDemo {

	/**
	 * wapper is immutable , it create instace when copy 
	 */
	static void CopyObjecrWapper() {
		
		Integer inOriginal = 100;
		String strOriginal = "String original";
		Double doubleOriginal = 899.9;
		
		Integer inCopy = inOriginal;
		String strCopy = strOriginal;
		Double doubleCopy = doubleOriginal;
		
		//change object copy and compare it with original 
		inCopy = 200;
		strCopy="String Change";
		doubleCopy=123.4;
		
		System.out.println("inOriginal before copy : "+ inOriginal); // 100
		System.out.println("inOriginal copied and change : "+ inCopy); // 200
		System.out.println("inOriginal after copy and change: "+ inOriginal); //100
		System.out.println("------------------------");
		System.out.println("strOriginal before copy : "+ strOriginal); // String original
		System.out.println("strOriginal copied and change : "+ strCopy); //String Change
		System.out.println("strOriginal after copy and change: "+ strOriginal); //String original
		System.out.println("------------------------");
		System.out.println("doubleOriginal before copy : "+ doubleOriginal); //899.9
		System.out.println("doubleOriginal copied and change : "+ doubleCopy); //123.4
		System.out.println("doubleOriginal after copy and change: "+ doubleOriginal); //899.9
	}
	
	/**
	 *   use = , it referene same memory , change content effect all object reference to it.
	 */
	static void copyObjectReferenceDefination() {
		
		// class use properties wapper object
		Address addressOriginal = new Address();
		addressOriginal.setTP("Ho CHi Minh CITy");
		Address addressCopy = addressOriginal; // it is copy address memory , 2 object use one memory
		
		System.out.println("addressOriginal before copy : "+ addressOriginal.getTP()); //Ho CHi Minh CITy
		
		addressCopy.setTP("Tan An CiTy");
		System.out.println("addressOriginal copied and change : "+ addressCopy.getTP()); //Tan An CiTy
		
		System.out.println("addressOriginal after copy and change: "+ addressOriginal.getTP()); //Tan An CiTy
	}
	
	/**
	 * Use Cloneable interface, it create instace when copy   
	 */
	static void copyDeepCopyUseCloneableInterface() {
		// class use properties wapper object
		AddressCloneable addressOriginal = new AddressCloneable();
		addressOriginal.setTP("Ho CHi Minh CITy");
		AddressCloneable addressCopy = addressOriginal.clone();
		
		System.out.println("addressOriginal before copy : "+ addressOriginal.getTP()); //Ho CHi Minh CITy
		addressCopy.setTP("Tan An CiTy");
		System.out.println("addressOriginal copied and change : "+ addressCopy.getTP()); //Tan An CiTy
		System.out.println("addressOriginal after copy and change: "+ addressOriginal.getTP()); //Ho CHi Minh CITy
		
		System.out.println("---------------User has properties Address-------------------");
		UserCloneable useOriginal = new UserCloneable();
		useOriginal.setIn(11);
		useOriginal.setName("original");
		useOriginal.setAddress(addressOriginal);
		
		UserCloneable useCopy = useOriginal.clone();
		
		System.out.println("useOriginal before copy : "+ useOriginal.toString()); //Ho CHi Minh CITy
		useCopy.getAddress().setTP("Tan An CiTy");
		System.out.println("useOriginal copied and change : "+ useCopy.toString()); //Tan An CiTy
		System.out.println("useOriginal after copy and change: "+ useOriginal.toString()); //Ho CHi Minh CITy
		
	}
	
	/** 
	 * it create instace when copy   
	 * Use Apache Common Lang SerializationUtils.clone(object);
	 */
	static void copyDeepCopyUseApacheComomLang() {
		 
		Address addressOriginal = new Address();
		addressOriginal.setTP("Ho CHi Minh CITy");
		System.out.println("---------------User has properties Address-------------------");
		User useOriginal = new User();
		useOriginal.setIn(11);
		useOriginal.setName("original");
		useOriginal.setAddress(addressOriginal);
		
		User useCopy = SerializationUtils.clone(useOriginal);
		
		System.out.println("useOriginal before copy : "+ useOriginal.toString()); //Ho CHi Minh CITy
		useCopy.getAddress().setTP("Tan An CiTy");
		System.out.println("useOriginal copied and change : "+ useCopy.toString()); //Tan An CiTy
		System.out.println("useOriginal after copy and change: "+ useOriginal.toString()); //Ho CHi Minh CITy
		
	}
	
	
	
	public static void main(String[] args) {
		CopyObjecrWapper();
		System.out.println();
		System.out.println("-----------use = ------------");
		copyObjectReferenceDefination();
		System.out.println();
		System.out.println("-----------use clone()------------");
		copyDeepCopyUseCloneableInterface();
		System.out.println();
		System.out.println("------------------ copyDeepCopyUseApacheComomLang() ----------------------");
		copyDeepCopyUseApacheComomLang();
	}
}
