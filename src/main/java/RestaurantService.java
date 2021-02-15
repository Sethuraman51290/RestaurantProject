import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException{
        for(Restaurant rs : restaurants){
            if(((rs.getName()).equalsIgnoreCase(restaurantName))){
                return rs;
            }
        }
        throw new restaurantNotFoundException(restaurantName);
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    //method to calculate total price for the items(newly added method for the assignment)
    public int getTotalPriceOfTheItem(String restaurantName) throws restaurantNotFoundException,itemNotFoundException{
        Restaurant rst = findRestaurantByName(restaurantName);
            List<String> itemsAddedToCart = itemsAddedToCartForThisRestaurant();
            int sum = rst.calculateItemPrice(itemsAddedToCart);
             System.out.println("your cart contains items of worth "+sum);
             return sum;
    }
    //method to calculate total price for the items(newly added method for the assignment)
    public List<String> itemsAddedToCartForThisRestaurant(){
        List<String> itemsAddedToCart = new ArrayList<>();
        itemsAddedToCart.add("soup");
        itemsAddedToCart.add("noodles");
        itemsAddedToCart.add("bread sandwhich");
        return itemsAddedToCart;
    }
}
