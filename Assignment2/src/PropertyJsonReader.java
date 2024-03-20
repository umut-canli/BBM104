import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

//Burada  json dosyasini okuduktan sonra Hashmap ile kayit ediyorum.
public  class PropertyJsonReader {
    public String name;
    public int ID,cost;
    public static HashMap<Integer,Properties> lnd=new HashMap<Integer,Properties>();


    public PropertyJsonReader(){

        JSONParser processor = new JSONParser();
        try (Reader file = new FileReader("property.json")){
            JSONObject jsonfile = (JSONObject) processor.parse(file);
            JSONArray Land = (JSONArray) jsonfile.get("1");
            for(Object i:Land){


                //You can reach items by using statements below:
                ID=Integer.parseInt((String)((JSONObject)i).get("id"));

                name=(String)((JSONObject)i).get("name");
                cost=Integer.parseInt((String)((JSONObject)i).get("cost"));
                Properties land=new Land(name,cost);
                lnd.put(ID,land);
                //And you can add these items to any data structure (e.g. array, linkedlist etc.



            }
            JSONArray RailRoad = (JSONArray) jsonfile.get("2");
            for(Object i:RailRoad){
                //You can reach items by using statements below:
                ID=Integer.parseInt((String)((JSONObject)i).get("id"));
                name=(String)((JSONObject)i).get("name");
                cost=Integer.parseInt((String)((JSONObject)i).get("cost"));
                Properties rail=new Railroad(name,cost);
                lnd.put(ID,rail);



                //And you can add these items to any data structure (e.g. array, linkedlist etc.
            }

            JSONArray Company = (JSONArray) jsonfile.get("3");
            for(Object i:Company){
                //You can reach items by using statements below:
                ID=Integer.parseInt((String)((JSONObject)i).get("id"));
                name=(String)((JSONObject)i).get("name");
                cost=Integer.parseInt((String)((JSONObject)i).get("cost"));
                Properties comp=new Company(name,cost);
                lnd.put(ID,comp);

            }

        } catch (IOException e){
            e.printStackTrace();
        } catch (ParseException e){
            e.printStackTrace();
        }
    }
    //You can add function(s) if you want
}