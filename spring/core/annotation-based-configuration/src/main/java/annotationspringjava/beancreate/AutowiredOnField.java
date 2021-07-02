package annotationspringjava.beancreate;

import annotationspringjava.POJO.StudentPOJO3;
import annotationspringjava.POJO.StudentPOJO4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutowiredOnField {

    //@Autowired
    StudentPOJO4 studentPOJO4;

    AutowiredOnField(){
        System.out.println("AutowiredOnField constructor non argument");
    }
}
