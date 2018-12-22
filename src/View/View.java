package View;

import Controller.Controller;

import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        System.out.printf("hi");
        View view=new View();
        view.ReadInput();
    }

    public void ReadInput(){
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





