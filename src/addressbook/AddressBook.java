/*
 * JAVA期末專題
 * 4102029018 陳欣儀
 * 引用請註明來源
 */

package addressbook;

/**
 *
 * @author Little Mouse
 */
public class AddressBook {
    String Name;
    String MobileNumber;
    String Birthday;
    String MailAddress;
    
    public AddressBook(){
        Name = "Joe Smith";
        MobileNumber = "0912345678";
    }
    public AddressBook(String n , String Mnum){
        Name = n;
        MobileNumber = Mnum;
    }
    public AddressBook setName(String n){
        Name = n;
        return this;
    }
    public String getName(){
        return Name;
    }
    public AddressBook setNumber(String Mnum){
        MobileNumber = Mnum;
        return this;
    }
    public String getNumber(){
        return MobileNumber;
    }
    public void setBirthday(String bd){
        Birthday = bd;
    }
    public String getBirthday(){
        return Birthday;
    }
    public void setMailAddress(String ma){
        MailAddress = ma;
    }
    public String getMailAddress(){
        return MailAddress;
    }
     public String toString(){
        String str = getName() + " " + getNumber() + " " + getBirthday() + " " + getMailAddress() + " ";
        return str;
    }
}
