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
public class Colleague extends AddressBook {
    String Department;
    String DepartmentNumber;
    
    public Colleague(){
        Department = "資訊管理";
    }
    public Colleague(String n , String Mnum){
        setName(n).setNumber(Mnum);
    }
    public void setDepartment(String d){
        Department = d;
    }
    public String getDepartment(){
        return Department;
    }
    public void setDepartNumber(String dnum){
        DepartmentNumber = dnum;
    }
    public String getDepartmentNumber(){
        return DepartmentNumber;
    }
        public String toString(){
        String str = super.toString() + getDepartment() + " " + getDepartmentNumber();
        return str;
    }
}
