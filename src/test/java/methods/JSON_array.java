package methods;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class JSON_array {
	
	@Test
	public void test() {
		
		// here we are creating an array of objects and adding the same to the array 
		// object one
		JSONObject object1  = new JSONObject();
		
		object1.put("name", "shon");
		object1.put("id", "1");
		object1.put("Ph", "9538360582");
		object1.put("Branch", "Mech");
		
		// object two
		JSONObject object2  = new JSONObject();
		
		object2.put("name", "Anto");
		object2.put("id", "2");
		object2.put("Ph", "9538360582");
		object2.put("Branch", "CS");
		
		
		JSONArray array = new JSONArray();
		array.put(object1);
		array.put(object2);
		
		System.out.println(array.toString());
			
		
		// when we are adding array of objects linked to a key we are creating an employee object with all the attributes which are link to the
		// employee in the form of an array
		JSONObject object3 = new JSONObject();
		object3.put("name", "shon");
		object3.put("id", "1");
		object3.put("Ph", "9538360582");
		object3.put("Branch", "Mech");
		
		
		JSONObject object4 = new JSONObject();
		object4.put("name", "Anto");
		object4.put("id", "2");
		object4.put("Ph", "9538360582");
		object4.put("Branch", "CS");
		
		JSONArray array1 = new JSONArray();
		array1.put(object3);
		JSONArray array2 = new JSONArray();
		array2.put(object4);
		
		
		JSONObject empObject = new JSONObject();
		empObject.put("emp1", array1);
		empObject.put("emp2", array2);
		
		System.out.println(empObject.toString());
		
		
		// just to create an object with only one array of values 
		JSONArray arr = new JSONArray();
		arr.put(1);
		arr.put(2);
		arr.put(3);
		arr.put(4);
		arr.put(5);
		
		JSONObject obj = new JSONObject();
		obj.put("val", arr);
		
		System.out.println(obj.toString());
		
		
	}

}
