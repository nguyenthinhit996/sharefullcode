package collectionsinJava;

import java.util.*;

/**
 * only static method
 */
public class CollectionsClass {

    /**
     * Copy method override element following index source to dest
     * size dest >= size source
     */
    static void copy() {
        List<Integer> dest = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> source = Arrays.asList(7, 8, 9);
        Collections.copy(dest, source);
        System.out.println(dest); // [7, 8, 9, 4, 5, 6]
    }

    /**
     * disjoint check two collection has join ? , true if not same element
     */
    static void checkJoinCollection() {
        List<Integer> dest = Arrays.asList(1, 44, 3, 4, 5, 6);
        List<Integer> source = Arrays.asList(10, 44, 64);
        System.out.println("is join two collection: " + !Collections.disjoint(source, dest)); // true
    }


    /**
     * Collections.emptyList return immutable (not add, remove, replace, edit ...) ,difference with key-work final on list.
     * Collections.emptyList() to return if error or if you return list empty, instead of return null.
     *
     * @return
     */
    static List<Student> useEmptyList() {
        return Collections.<Student>emptyList(); //[]
    }

    /**
     * Collections.fill to override all element become value
     */
    static void useFill() {
        List<String> dest = Arrays.asList("hi", "hi2", "hi3", "hi4", "hi6");
        Collections.fill(dest, "OkMan");
        System.out.println(dest); // [OkMan, OkMan, OkMan, OkMan, OkMan]
    }

    /**
     * frequency (tần số) xuất hiện
     */
    static void usefrequency() {
        List<Integer> dest = Arrays.asList(1, 44, 3, 4, 5, 6, 44, 45, 46);
        System.out.println("frequency of 44 : " + Collections.frequency(dest, 44)); //2
    }

    /**
     * return index first occurred of sublist
     */
    static void seachSublistInCollection() {
        List<Integer> dest = Arrays.asList(1, 44, 3, 45, 5, 6, 44, 45, 46);
        List<Integer> subList = Arrays.asList(44, 45);

        int indexOccurred = Collections.indexOfSubList(dest, subList); // 6 , start 0 , inclusive 44
        System.out.println("Search sub list in collection: " + indexOccurred); // 6
        System.out.println(dest.get(indexOccurred)); // 44
    }

    /**
     * max min
     */
    static void maxMinInCollection() {
        List<Integer> dest = Arrays.asList(1, 44, 3, 45, 5, 6, 44, 45, 46);
        System.out.println("max: " + Collections.max(dest));
        System.out.println("min: " + Collections.min(dest));
    }

    /**
     * Copy n object to list
     */
    static void useNCopyInCollection() {
        String a = "hihi";
        List<String> ls = Collections.nCopies(5, a);
        System.out.println(ls);
    }

    /**
     * initial map must empty
     * both map ans set effect together
     * value of both always same
     */
    static void useNewSetFromMap() {
        Map<String, Boolean> map = new HashMap<>();
        Set<String> set = Collections.newSetFromMap(map); // map must empty

        System.out.println("map " + map);
        System.out.println("set " + set);

        set.add("hi1");
        set.add("hi2");
        set.add("hi3");
        set.add("hi4");

        System.out.println("map " + map);
        System.out.println("set " + set);

        map.remove("hi1");
        map.put("hi1111", false);

        System.out.println("map " + map);
        System.out.println("set " + set);
    }

    static void useReplaceAll() {
        //replaceAll(List<T> list, T oldVal, T newVal)
    }

    /**
     * reverse order insertion not sort
     */
    static void reverseCollection() {
        // list [3,5,8,9]
        // reverse collection
        // list [9,8,5,3]
    }

    /**
     * reverse Sort of collection dependent comparable or comparator of class
     * it return Comparator
     */
    static void reverseOrder() {
        // SortLists By Comparable include wrapper class default has implement Comparable
        // Collections.sort(list); ascending
        //  Collections.sort(list, Collections.reverseOrder());  descending

        //Sort Lists By Comparator
        // Create Comparator ascendingSort
        // static Comparator<ClassCustomize> descendingSort = Collections.reverseOrder(ascendingSort);

        // reference: collectionsinJava.listinterface.sorts
    }

    /**
     * rotate has mean : example 2 , value current = value [index current + 2] start 0
     * list [1, 4, 5, 7, 6]
     * list [7, 6, 1, 4, 5]
     */
    static void rotate() {
        List<Integer> dest = Arrays.asList(1, 4, 5, 7, 6);
        System.out.println("list orginal " + dest);
        Collections.rotate(dest, 2); // rotate 2
        System.out.println(dest);
    }

    /**
     * reOrder of list
     */
    static void useShuffle() {
        List<Integer> dest = Arrays.asList(1, 4, 5, 7, 6, 77, 99);
        System.out.println("List original "+ dest);
        Collections.shuffle(dest);
        System.out.println("Shuffle first times: "+ dest);

        Collections.shuffle(dest);
        System.out.println("Shuffle second times: "+ dest);

        Collections.shuffle(dest);
        System.out.println("Shuffle third times: "+ dest);
    }

    /**
     * Return list immutable only one element
     * @return
     */
    static List<String> singleTonList(){
        return Collections.singletonList("one");
    }

    /**
     * swapElementInCollection
     * @return
     */
    static void swapElementInCollection(){
        List<Integer> dest = Arrays.asList(1, 4, 5, 7, 6);
        System.out.println("list orginal " + dest);
        Collections.swap(dest, 0,2); // swap value in index 0 vs index 2 (1 <--> 5)
        System.out.println(dest);
    }

    /**
     *
     * unmodifiableList
     * Not add, remove, set will UnsupportedOperationException
     * but change context of element (inside element)
     *
     */
    static void unmodifiableList(){
        List<Integer> dest = Arrays.asList(1, 4, 5, 7, 6);
        System.out.println("list orginal " + dest);

        List<Integer> listUnmodifieable = Collections.unmodifiableList(dest);
        // listUnmodifieable.add(232);  UnsupportedOperationException
        System.out.println(listUnmodifieable);

        List<Student> listOriginal = new ArrayList<>();
        listOriginal.add(new Student(1, "hs1", new Address("tp1")));
        listOriginal.add(new Student(2, "hs2", new Address("tp2")));
        listOriginal.add(new Student(3, "hs3", new Address("tp3")));
        listOriginal.add(new Student(4, "hs3", new Address("tp3")));
        listOriginal.add(new Student(5, "hs3", new Address("tp3")));
        listOriginal.add(new Student(6, "hs3", new Address("tp3")));

        System.out.println(listOriginal);
        List<Student> listUnmodifiable = Collections.unmodifiableList(listOriginal);
        listUnmodifiable.get(1).setName("hihihii");
        System.out.println(listUnmodifiable);
        Student news = new Student(4444444, "hs4444444444444", new Address("tp3")) ;
        listUnmodifiable.set(4,news); // UnsupportedOperationException
    }

    public static void main(String[] args) {
        copy(); // copy collection to collection override value following index
        checkJoinCollection(); //check join of two collection
        useEmptyList(); // use return list empty
        useFill(); // replace all value become element specified
        usefrequency(); // get frequency (tần số)
        seachSublistInCollection(); // search sublist in collection
        maxMinInCollection(); // find min max in collection
        useNCopyInCollection(); // copy n element become list
        useNewSetFromMap(); // ues set and map affect together
        useReplaceAll(); // replace all element if find it
        reverseCollection(); // reverse order in time insertion not sort
        reverseOrder(); // sort descending or ascending dependent comparable or comparator
        rotate(); // replace element by index specified
        useShuffle(); // shuffle reOrder of list
        singleTonList(); // return one element of list immutable
        swapElementInCollection(); //swap element index a vs index b
        unmodifiableList(); // Not add, remove, set will UnsupportedOperationException.
    }
}

class Student {
    private Integer id;
    private String name;
    private Address address;


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Student(Integer id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(address, student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}

class Address {
    private String tp;

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public Address(String tp) {
        this.tp = tp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(tp, address.tp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tp);
    }
}