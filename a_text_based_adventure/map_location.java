
import java.util.ArrayList;

public class map_location {
    String loc_description;
    ArrayList<item> loc_objects = new ArrayList<>();
    

    map_location(String desc){

        loc_description = desc;
    }
    //more struggling with directions and how to move
    //around the map, again, before coordinates idea
/* 
    public void moveTo(map_location nextLocation){
        player.setLocation(nextLocation);
    }
*/
    public void addObject(item item_from_player){
        this.loc_objects.add(item_from_player);
    }

    public void takeObject(item item_in_room, player currentPlayer){
        this.loc_objects.remove(item_in_room);
        currentPlayer.inventory.add(item_in_room);
        Main.print(item_in_room.name+" taken");
    }

    public String[] getLocObjects(){
        return loc_objects.toString().toUpperCase().replace("[", "").replace("]", "").split(", ");
    }

    public String toString(){

        return loc_description;
    }

}
