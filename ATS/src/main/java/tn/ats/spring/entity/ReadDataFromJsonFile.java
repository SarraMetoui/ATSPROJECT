package tn.ats.spring.entity;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.Iterator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@SuppressWarnings("unchecked")
public class ReadDataFromJsonFile {

	public static void main(String[] args) throws IOException, ParseException {
		
		JSONParser jsonparser = new JSONParser();
        FileReader reader = new FileReader("C:\\Users\\User\\Documents\\workspace-sts-3.8.4.RELEASE\\ATS\\src\\main\\java\\tn\\ats\\spring\\jsonfiles\\url.json");
	    Object obj = jsonparser.parse(reader);
	    JSONObject empjsonobj= (JSONObject) obj;
	    JSONArray products = (JSONArray)empjsonobj.get("products");
	    Iterator<JSONObject> iterator = products.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
	   
	    
	    
	}

}
