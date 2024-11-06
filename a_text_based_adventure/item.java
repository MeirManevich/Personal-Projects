public class item{
	int weight;
	String name;
	String description;

	public item(){
		name = "lantern";
		weight = 0;
	}

	public item(String item_name, String item_desc, int item_weight) {
		this.name = item_name;
		this.description = item_desc;
		this.weight = item_weight;
	}

	public String toString(){

		return name;
	}

	public String getDescription(){
		return this.description;
	}
}