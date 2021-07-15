package jachs.commons.beanutils.vo;

/**
 * @author zhanchaohan
 * 
 */
public class Person {
    private String Name;
    private int Age;
    private String Email;
    
    public Person () {
        super ();
    }
    public Person ( String name, int age, String email ) {
        super ();
        Name = name;
        Age = age;
        Email = email;
    }
    @Override
    public String toString () {
        return "Person [Name=" + Name + ", Age=" + Age + ", Email=" + Email + "]";
    }
    public String getName () {
        return Name;
    }
    public void setName ( String name ) {
        Name = name;
    }
    public int getAge () {
        return Age;
    }
    public void setAge ( int age ) {
        Age = age;
    }
    public String getEmail () {
        return Email;
    }
    public void setEmail ( String email ) {
        Email = email;
    }
    
}
