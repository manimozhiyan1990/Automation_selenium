package basic;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest {
   public static void main(String[] args) {
       Map<Integer,String> nameList = new LinkedHashMap<>();

       nameList.put(1,"mani");
       nameList.put(2,"anbu");
       nameList.put(3,"ariv");
       nameList.put(4,"anna");

       for(Map.Entry<Integer,String> entry : nameList.entrySet())
       {
           String songName = entry.getValue();
           System.out.println(songName);
       }
    }
}
