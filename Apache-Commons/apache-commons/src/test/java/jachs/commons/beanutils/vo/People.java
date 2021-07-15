package jachs.commons.beanutils.vo;
/***
 * 
 * @author zhanchaohan
 *
 */
public class People {
    private String Name;
    private int Age;
    private long Phone;
    
    public People () {
        super ();
    }
    public People ( String name, int age, long phone ) {
        super ();
        Name = name;
        Age = age;
        Phone = phone;
    }
    @Override
    public String toString () {
        return "People [Name=" + Name + ", Age=" + Age + ", Phone=" + Phone + "]";
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
    public long getPhone () {
        return Phone;
    }
    public void setPhone ( long phone ) {
        Phone = phone;
    }
    
}
