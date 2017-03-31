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
public class Friend extends AddressBook{
    String Nickname;
    String HouseAddress;
    
    public Friend(){
        HouseAddress = "台中市南區國光路250號";
    }
    public Friend(String n , String Mnum){
        setName(n).setNumber(Mnum);
    }
    public void setNickname(String n){
        Nickname = n;
    }
    public String getNickname(){
        return Nickname;
    }
    public void setHouseAddress(String ha){
        HouseAddress = ha;
    }
    public String getHouseAddress(){
        return HouseAddress;
    }
    public String toString(){
        String str = super.toString() + getNickname() + " " + getHouseAddress();
        return str;
    }
}
