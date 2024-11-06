import java.util.*;

public class player {
    map_location currentLocation;
    ArrayList<item> inventory = new ArrayList<item>();
    item torch = new item("torch", "flaming torch", 1);
    int weight;
    
    public player(){
        inventory.add(torch);
    }

    public void addItem(item newItem){
        inventory.add(newItem);
    }

    public void dropItem(item inventoryItem){
        inventory.remove(inventoryItem);
    }

    public void setLocation(map_location newLocation){
        currentLocation = newLocation;
    }

    public void getlocation(){

        System.out.println(this.currentLocation);
    }

    //for future ideas of some locations that cannot
    //be entered unless a certain weight
    public int getWeight(){
        int totalWeight = 0;
        for(int i=0;i<inventory.size();i++){
            totalWeight =+ inventory.get(i).weight;
        }
        return totalWeight;
    }

    public void getInvetory(){
        System.out.println("You are carrying:");
        for(int i = 0; i<inventory.size(); i++){
            //conditional for a/an
            if (inventory.get(i).description.startsWith("a")){
                System.out.println("    an "+inventory.get(i).description);
            }
            else{
                System.out.println("    a "+inventory.get(i).description);
            }
        }
    }

}
