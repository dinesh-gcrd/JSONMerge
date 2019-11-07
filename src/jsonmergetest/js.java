package jsonmergetest;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator; 
import java.util.Map; 
  
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;
public class js {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub

		 // parsing file "JSONExample.json" 
        Object obj = new JSONParser().parse(new FileReader("F:/eg.json")); 
        Object obj1 = new JSONParser().parse(new FileReader("F:/eg1.json"));        //Accessing the JSON files
        Object obj2 = new JSONParser().parse(new FileReader("F:/eg2.json"));
        // typecasting obj to JSONObject 
        JSONObject jo = (JSONObject) obj; 
        JSONArray ja = (JSONArray) jo.get("strikers");  
        /*for (Object c : ja)
        {
          System.out.println(c+"");
        }*/
        JSONObject jo1 = (JSONObject) obj1; 
        JSONArray ja1 = (JSONArray) jo1.get("strikers");  
        /*for (Object c : ja1)
        {
          System.out.println(c+"");
        }*/
        JSONObject jo2 = (JSONObject) obj2; 
        JSONArray ja2 = (JSONArray) jo2.get("strikers");  
        /*for (Object c : ja2)
        {
          System.out.println(c+"");
        }*/
        
        
        ja.addAll(ja1);
        ja.addAll(ja2);                                             //concatinating JSON Arrays
       System.out.println(jo);
       JSONObject object = new JSONObject();
       object.put("strikers",ja);                                 // we can make the name as user input
       FileWriter f= new FileWriter("F:/merge.json");              // New JSON file to merge
       f.write(object.toJSONString());                            // Writing to new JSON file
       f.flush();
	}

}
