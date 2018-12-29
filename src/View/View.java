package View;

import Controller.Controller;
import jdk.nashorn.api.tree.Parser;
import netscape.javascript.JSObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONException;
import org.json.simple.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;

public class View {
    public static void main(String[] args) throws FileNotFoundException, JSONException {

        Controller controller = new Controller();

        String[] inputs = new String[];
        String output;
        View view = new View();
        view.ReadInput();

        Object obj = Parser.parse(new FileReader("E:\\json.txt"));
        JSONObject jsonObject = (JSONObject) obj;

        //// THIS PART IS FOR WORKSHOPS
        // output.println(jsonObject.get("workshops"));

        ArrayList<String> features = new ArrayList<>();
        JSONArray features1 = (JSONArray) jsonObject.get("workshops");
        String name = (String) jsonObject.get("name");
        if (features1 != null) {
            for (int i = 0; i < features1.length(); i++) {
                features.add(features1.getString(i));
            }
        }
        Iterator iterator = features.iterator();

        while (iterator.hasNext()) {
            inputs = (String[]) iterator.next();
        }
        controller.CreatWorkshops(name, inputs);


        output = (String) jsonObject.get("output");

        /////// THIS PARTS IS FOR WAREHOUSE
        ArrayList<String> materials = new ArrayList<>();

        JSONArray features2 = (JSONArray) jsonObject.get("workshops");

        if (features1 != null) {
            for (int i = 0; i < features2.length(); i++) {
                materials.add(features2.getString(i));
            }


            Iterator iterator2 = materials.iterator();

            String[] material = new String[];
            while (iterator2.hasNext()) {

                for (int i = 0; i < materials.size(); i++) {
                    material[i] = materials.get(i);
                }
            }
            controller.CreatWarehouse(material);

        }
    }

        public void ReadInput ()
        {
            Controller controller = new Controller();
            Scanner scanner = new Scanner(System.in);

            String input = scanner.nextLine();
            while (!input.equals("end")) {
                input = scanner.nextLine();
                String commands[] = input.split(" ");
                controller.CommandAnalyzer(commands);
            }
        }


}





