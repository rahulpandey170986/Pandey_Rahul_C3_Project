import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
	private static List<Restaurant> restaurants = new ArrayList<>();

	public Restaurant findRestaurantByName(String restaurantName) {

		// DELETE ABOVE STATEMENT AND WRITE CODE HERE
		
		LocalTime openingTime = LocalTime.parse("09:00:00");
		LocalTime closingTime = LocalTime.parse("23:00:00");
		Restaurant restaurant = new Restaurant("Amelie's cafe", "Chennai", openingTime, closingTime);
		for (int i = 0; i < restaurants.size(); i++) {

			if (restaurants.get(i).getName().equals(restaurantName)) {
				restaurant.setName(restaurants.get(i).getName());
			}
		}
		return restaurant;
	}

	public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
		Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
		restaurants.add(newRestaurant);
		return newRestaurant;
	}

	public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
		Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
		String restName=restaurantToBeRemoved.toString();
		if (restName.equals(restaurantName))
		{
			restaurants.remove(restaurantToBeRemoved);
			
		}
		else
		{
			throw new restaurantNotFoundException(restaurantName);
		}
		return restaurantToBeRemoved;
	}
	
	
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

}