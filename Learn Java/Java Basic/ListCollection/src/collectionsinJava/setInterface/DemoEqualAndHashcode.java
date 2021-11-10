package collectionsinJava.setInterface;


import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class DemoEqualAndHashcode {

    private String id;
    private Integer age;

    public String getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public DemoEqualAndHashcode(String id, Integer age) {
        this.id = id;
        this.age = age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", age=" + age +
                ", hashcode="+ hashCode() +
                '}';
    }

    DemoEqualAndHashcode(){
        super();
    }

    public static void main(String[] args) {

        Set<DemoEqualAndHashcode> set = new HashSet<>();

        DemoEqualAndHashcode a1 = new DemoEqualAndHashcode();

        DemoEqualAndHashcode a2 = new DemoEqualAndHashcode();

        DemoEqualAndHashcode a3 = new DemoEqualAndHashcode();

        DemoEqualAndHashcode a4 = new DemoEqualAndHashcode();

        System.out.println(a1.equals(a2));

        set.add(a1);
        set.add(a2);
        set.add(a3);
        set.add(a1);

        System.out.println(set.size());
        System.out.println(set);

    }
}
