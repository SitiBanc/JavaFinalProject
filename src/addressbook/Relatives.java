/*
 * JAVA期末專題
 * 4102029018 陳欣儀
 * 引用請註明來源
 */

package addressbook;

/**
 *
 * @author user
 */
public class Relatives extends AddressBook {
    String Relationship;
    String PhoneNumber;
    
    public Relatives(){
        PhoneNumber = "0412356789";
    }
    public Relatives(String n , String Mnum){
        setName(n).setNumber(Mnum);
    }
    public void setRelationship(String r){
        Relationship = r;
    }
    public String getRelationship(){
        return Relationship;
    }
    public void setPhoneNumber(String pnum){
        PhoneNumber = pnum;
    }
    public String getPhoneNumber(){
        return PhoneNumber;
    }
    public String toString(){
        String str = super.toString() + getRelationship() + " " + getPhoneNumber();
        return str;
    }
}
