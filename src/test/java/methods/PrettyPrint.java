package methods;

import java.lang.reflect.Array;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class PrettyPrint {

	@Test
	public void test() {
		JSONArray arr1 = new JSONArray();
		arr1.put(new JSONObject().put("name", "shon").put("id", "1"));
		
		JSONArray arr2 = new JSONArray();
		arr2.put(new JSONObject().put("name", "Anto").put("id", "2"));
		
		JSONObject data1 = new JSONObject();
		data1.put("emp1", arr1);
		data1.put("emp2", arr2);
		
		System.out.println(data1.toString());
		
		
		JSONObject object = new JSONObject();
		object.put("emp1", new JSONObject().put("name", "shon").put("id", "1"));
		object.put("emp2", new JSONObject().put("name", "Anto").put("id", "2"));
		
		System.out.println(object);
		
		HashMap<String, JSONObject> map = new HashMap<String, JSONObject>();
		map.put("data", object);
		
		System.out.println(map.toString());
		
		JSONObject data = new JSONObject().put("values", map);
		
		System.out.println(data);
		
		
		
		// this is just an example where in i just want to store an object with one key associated with it 
		JSONObject test = new JSONObject();
		test.put("emp1", new JSONObject().put("Name", "King").put("id", "1"));
		System.out.println("----------------------------------------------------");
		System.out.println(test.toString());
		System.out.println("------------------------------------------------");
		JSONObject test1 = new JSONObject();
		test1.put("values", test);
		System.out.println(test1.toString());
	
		
	}
}
