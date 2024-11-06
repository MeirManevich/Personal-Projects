import java.util.Arrays;
import java.util.Scanner;



public class Main {
    //unfinished direction system, before global 
    //coordinates idea
    enum direction{
        north,
        east,
        south,
        west,
        northEast,
        northWest,
        southEast,
        southWest,
        up,
        down
    }
    public static int print(String output){
        System.out.println(output);
        return 0;
    }

    //lots of hard-coded data everywhere, 
    //honestly to test classes and functions
    //but it has gotten kinda out of hand
    public static void main(String[] args) {
        player oop = new player();
        locations game_locations = new locations();
        map_location House = new map_location("""
            You are in a quaint house that appears to have been recently vacated. 
            A pair of woolen stockings hangs over a lit fireplace.\n\n
            To the west is a closed door.
            """);
        oop.setLocation(House);
        Scanner userInput = new Scanner(System.in);
        item apple = new item("APPLE","back-to-school red apple", 1);
        item beet = new item("BEET", "slightly dusty beet", 1);
        item kitchen_knife = new item("KNIFE","recently sharpened knife", 1);

        oop.inventory.add(apple);
        oop.getlocation();
        print("hello");

        map_location kitchen = new map_location("You are in a kitchen "+
        "that looks like it hasn't been updated since 1927. A slightly dusty beet sits on"+
        " an old wood counter, a recently sharpened knife lies next to it.");
        kitchen.addObject(kitchen_knife);
        kitchen.addObject(beet);
        oop.setLocation(game_locations.West_of_House);
        oop.getlocation();
        oop.setLocation(game_locations.East_of_House);
        oop.getlocation();


        
        String[] next = {"",""};
        String[] kitchenItems = kitchen.getLocObjects();

        while (!next[0].equals("QUIT")) {
            next = userInput.nextLine().toUpperCase().split(" ");

            switch(next[0]){
                case "W","WEST" -> {
                    oop.setLocation(kitchen);
                    oop.getlocation();
                }
                case "TAKE" -> {
                    print("What do you want to take?");
                    next = userInput.nextLine().toUpperCase().split(" ");
                    
                    if (next[0].equals(kitchenItems[0])){
                        kitchen.takeObject(kitchen_knife, oop);
                    }
                    else if(next[0].equals(kitchenItems[1])){
                        kitchen.takeObject(beet, oop);
                    }
                }
                case "I", "INVENTORY" -> {
                    oop.getInvetory();
                }
                default -> {
                    print("Sorry, I didn't understand that");
                }

            }
            /*try{

                if (next[0].equals("WEST") || next[0].equals("W")){
                    oop.setLocation(kitchen);
                    oop.getlocation();
                }
                //conditions for the kitchen
                
                if (next[0].equals("TAKE")){
                    print("What do you want to take?");
                }
                    if (next[0].equals(beet.name)){
                        oop.addItem(beet);
                        print("Taken.");
                    }
                    else if(next[0].equals("KNIFE")){
                        oop.addItem(kitchen_knife);
                        print("Taken.");
                    }
                else if(next[0].equals("DROP")){
                    print("What do you want to drop?");
                    if(next[0].equals(beet.name)){
                        oop.dropItem(beet);
                    }
                }
                else if(next[0].equals("WEIGHT")){
                    print(oop.getWeight());
                }
                    
                    
                else if (next[0].equals("I") || next[0].equals("INVENTORY")) {
                    oop.getInvetory();
                }
                else if (next[0].equals("QUIT") || next[0].equals("STOP")){
                    break;
                }
                else{
                    print("Sorry, I did not understand that");
                }
            //} catch (Exception e){
                //print("exception");
                //continue;
            //}
            */
            Arrays.fill(next, "");
            
        }
        userInput.close();

    }

    
}
