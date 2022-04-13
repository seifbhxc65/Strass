package DAO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/// this class is executed one time to add a specifiec file data to the database
public class jsonread
{
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws ParseException, org.json.simple.parser.ParseException 
    {
        //JSON parser object to parse read file
    	//fichier hedhi t5ademha mara barka bech 3abilk restaurent li fil fichier json lil base
        JSONParser jsonParser = new JSONParser();
        System.out.println("dsds".replaceAll("", ""));
        try (FileReader reader = new FileReader("C:\\Users\\Asus\\eclipse-workspace\\ProjectX\\src\\DAO\\sousse.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray restoList = (JSONArray) obj;
           
            //Iterate over employee array
            restoList.forEach( rest -> parseEmployeeObject( (JSONObject) rest ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    private static void parseEmployeeObject(JSONObject resto) 
    {
        //Get employee object within list
        JSONObject restoObject = (JSONObject) resto.get("location");
         //get name
         String name=(String)resto.get("title");
         //get email (cause the json do not contain email we will give it a random one)
         String email =name.split(" ")[0]+"@gmail.com";
         //get phone  we will give it 88888888 which means they did not provide the phone nbr
         String phone=(String)resto.get("phone")!=null?(String)resto.get("phone"):"88888888";
         double avis=(double)resto.get("totalScore");
         System.out.println(avis);
         double lat =(double)restoObject.get("lat");
         
        //Get longitude
        double lng =(double)restoObject.get("lng");
        //get link
        String link=(String)resto.get("url");
       RestaurantBD bd=new RestaurantBD();
	     bd.ajout(name,email,avis,phone,lat,lng,link);
        
   
    }
}
