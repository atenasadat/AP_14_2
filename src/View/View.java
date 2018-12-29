package View;

import Controller.Controller;
import netscape.javascript.JSObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import org.json.simple.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;

public class View
{
    public static void main(String[] args) throws FileNotFoundException {

        Object obj = new JSONParser.parse(new FileReader("JSONExample.json"));
        JSONObject jo = (JSONObject) obj;



        view.ReadInput();
    }



    public void ReadInput()
    {
        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);

        String input=scanner.nextLine();
        while (!input.equals("end")) {
            input=scanner.nextLine();
            String commands[]=input.split(" ");
            controller.CommandAnalyzer(commands);
        }
    }

}





