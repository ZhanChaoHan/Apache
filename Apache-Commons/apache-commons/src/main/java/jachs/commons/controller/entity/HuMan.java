package jachs.commons.controller.entity;

/***
 * 
 * @author zhanchaohan
 *
 */
public class HuMan {
	private String Name;
	private int age;
	
	public HuMan() {
		super();
	}

	public HuMan(String name, int age) {
		super();
		Name = name;
		this.age = age;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
