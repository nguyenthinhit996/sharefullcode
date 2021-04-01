package featuresameple.functionalinterfaces;
 

 

//Interface_One
interface Interface_One{  
  //defaultMethod 
  default void defaultMethod(){  
      System.out.println("Interface_One::defaultMethod");  
  }
   
}  
//Interface_Two
interface Interface_Two{  
   //defaultMethod
  default void defaultMethod(){  
      System.out.println("Interface_Two::defaultMethod");  
  }  
}
class TestExample implements Interface_One, Interface_Two{ 
    
  public void disp(String str){
      System.out.println("String is: "+str); 
  }
//  //override defaultMethod to take care of the ambiguity
//  public void defaultMethod(){  
//      System.out.println("TestExample::defaultMethod");  
//  }

@Override
public void defaultMethod() {
	// TODO Auto-generated method stub
	Interface_One.super.defaultMethod();
}
}
class MultipleDefaultMethodInheritance {
  public static void main(String[] args) {  
      TestExample obj = new TestExample();
       
      //call the default method
      obj.defaultMethod();     
  }  
}