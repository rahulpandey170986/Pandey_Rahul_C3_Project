
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen(Restaurant restaurant) {
       
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
    	 	
    	Boolean isResOpen= false;
    	LocalTime openingTime = restaurant.openingTime;
		LocalTime closingTime = restaurant.closingTime;
    	LocalTime currentTime=restaurant.getCurrentTime();
    	int value1 = openingTime.compareTo(currentTime);
    	int value2 = closingTime.compareTo(currentTime);
    	if ((value1 <= 0) && value2 >=0) {
    		
    		isResOpen=true;
    	}
        	
        return isResOpen;
    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
       
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
    	List<Item> menuDetails= menu;
    	return menuDetails;
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }
    // Add item from Menu and get Total
    public Boolean addingItemFromMenu(ArrayList<String> newItem) {
    	double total=0;
    	for(int i=0;i<newItem.size();i++) {
    		for (int j=0; j< menu.size();j++)
    		{
    			if( newItem.get(i).equals(menu.get(j).getName())) {
    				total= menu.get(j).getPrice()+total;   	
    				System.out.println(menu.get(j));
    				}
    		}
    		
    	}
    	System.out.println("Your order will cost: Rs "+total);
    	Boolean value = false;
		if (total != 0) {
			value = true;
		}
    	return value;
    }
    
    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name =name;
    }

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return name;
	}    
	
    
    
    
 }