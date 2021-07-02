package basicioc.pojo;

public class ContructPOJODependency {

	private String name;
	private String nameClass;
	private int maso;
	private int maso2;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameClass() {
		return nameClass;
	}

	public void setNameClass(String nameClass) {
		this.nameClass = nameClass;
	}

	public int getMaso() {
		return maso;
	}

	public void setMaso(int maso) {
		this.maso = maso;
	}

	public int getMaso2() {
		return maso2;
	}

	public void setMaso2(int maso2) {
		this.maso2 = maso2;
	}

	public ContructPOJODependency(String name, String nameClass, int maso, int maso2) {
		super();
		this.name = name;
		this.nameClass = nameClass;
		this.maso = maso;
		this.maso2 = maso2;
	}

	public ContructPOJODependency(String name) {
		super();
		this.name = name;
	}

	public ContructPOJODependency(String name, String nameClass) {
		super();
		this.name = name;
		this.nameClass = nameClass;
	}

	public ContructPOJODependency(String name, String nameClass, int maso) {
		super();
		this.name = name;
		this.nameClass = nameClass;
		this.maso = maso;
	}

	public ContructPOJODependency() {
		super();
		this.name = "default";
		this.nameClass = "default";
		System.out.println("calling ContructPOJODependency()");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + "," + this.nameClass + "," + this.maso + "," + this.maso2;
	}
	
	public void customInit() 
    {
        System.out.println("Method customInit() invoked...");
    }
 
    public void customDestroy() 
    {
        System.out.println("Method customDestroy() invoked...");
    }

}
