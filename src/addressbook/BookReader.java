/*
 * JAVA期末專題
 * 4102029018 陳欣儀
 * 引用請註明來源
 */

package addressbook;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.*;
        
/**
 *
 * @author Little Mouse
 */
public class BookReader {
    //Treemap <姓名, 對應的ArrayList索引值>
    TreeMap <String , String> map = new TreeMap <> ();
    ArrayList list = new ArrayList();
    private File f;
    //讀檔並回傳ArrayList
    public ArrayList open(){
        list.clear();
        map.clear();
        JFileChooser fc = new JFileChooser(new File("."));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Normal text file(*.txt)","txt");
        fc.setFileFilter(filter);
        int status = fc.showOpenDialog(null);
           
        if(status != JFileChooser.CANCEL_OPTION){
	f = fc.getSelectedFile();
                    BufferedReader r = null;
	//開啟檔案並讀取資料到TreepMap中
	try{
                               r = new BufferedReader(new FileReader (f));
	}catch(FileNotFoundException e){
                                JOptionPane.showMessageDialog(null, "找不到檔案！", "錯誤", JOptionPane.ERROR_MESSAGE);
                                System.exit(-1);
	}
	StringTokenizer st;
	String temp;
	AddressBook ab;                    
                    //txt檔格式：群組代號(r,c,f) 姓名 手機號碼 生日(yyyy/mm/dd) 電子信箱 屬性1(關係,部門,暱稱) 屬性2(住家電話,部門電話,住家地址)
	try{
                                String input = r.readLine();
                                while(input != null){
		st = new StringTokenizer(input);
                                        temp = st.nextToken();
                                    switch (temp) {
                                        case "r":
                                            Relatives abR = new Relatives(st.nextToken(), st.nextToken());
                                            abR.setBirthday(st.nextToken());
                                            abR.setMailAddress(st.nextToken());
                                            abR.setRelationship(st.nextToken());
                                            abR.setPhoneNumber(st.nextToken());
                                            list.add(abR);
                                            map.put(abR.getName(), Integer.toString(list.indexOf(abR)));
                                            break;
                                        case "f":
                                            Friend abF = new Friend(st.nextToken(), st.nextToken());
                                            abF.setBirthday(st.nextToken());
                                            abF.setMailAddress(st.nextToken());
                                            abF.setNickname(st.nextToken());
                                            abF.setHouseAddress(st.nextToken());
                                            list.add(abF);
                                            map.put(abF.getName(), Integer.toString(list.indexOf(abF)));
                                            break;
                                        default:
                                            Colleague abC = new Colleague(st.nextToken(), st.nextToken());
                                            abC.setBirthday(st.nextToken());
                                            abC.setMailAddress(st.nextToken());
                                            abC.setDepartment(st.nextToken());
                                            abC.setDepartNumber(st.nextToken());
                                            list.add(abC);
                                            map.put(abC.getName(), Integer.toString(list.indexOf(abC)));
                                            break;
                                    }
                                    input = r.readLine();
                                }
	}catch(IOException e){
                                JOptionPane.showMessageDialog(null, "資料讀取錯誤", "錯誤", JOptionPane.ERROR_MESSAGE);
                                System.exit(-2);
	}
	//關閉檔案
	try{
                                r.close();
	}catch(IOException e){
                                JOptionPane.showMessageDialog(null, "檔案關閉錯誤", "錯誤", JOptionPane.ERROR_MESSAGE);
                                System.exit(-3);
	}
        }
        return list;
    }//在open()這個方法中，讀取資料至TreeMap和關閉檔案時都會產生IOException，若將例外傳播到呼叫端，將無法判別是何者產生的例外
    //改&增
    public void update(AddressBook ab){
        //增
        if(list.contains(ab) != true) {
            list.add(ab);
            map.put(ab.getName(), Integer.toString(list.indexOf(ab)));
        } 
        //改
        else {
            list.set(Integer.parseInt(map.get(ab.getName())),ab);       
        }
    }
    public ArrayList updateList(){
        return list;
    }
    //刪
    public String delete(String n){
         AddressBook ab = (AddressBook) list.remove(Integer.parseInt(map.get(n)));
        String name = ab.getName();
        map.remove(n);
        for(int i = 0; i < list.size() ; i++){
            ab = (AddressBook) list.get(i);
            map.put(ab.getName(), Integer.toString(list.indexOf(i)));
        }
        return name;
    }
    //查
    public Object search(String n) throws NullPointerException, NumberFormatException {
        Object o = list.get(Integer.parseInt(map.get(n)));
        return o;
    }
    //儲存(輸出txt檔)
    public void save(String n) throws IOException{
        FileWriter fw = new FileWriter (n + ".txt");
        PrintWriter pw = new PrintWriter(fw);
        String str = "";
        for (Object list1 : list) {
            if (list1 instanceof Relatives) {
                Relatives ab = (Relatives) list1;
                str = "r ";
                str += ab.toString();
                pw.println(str);
            }
            if (list1 instanceof Colleague) {
                Colleague ab = (Colleague) list1;
                str = "c ";
                str += ab.toString();
                pw.println(str);
            }
            if (list1 instanceof Friend) {
                Friend ab = (Friend) list1;
                str = "f ";
                str += ab.toString();
                pw.println(str);
            }
        }
        pw.close();
    }
}
