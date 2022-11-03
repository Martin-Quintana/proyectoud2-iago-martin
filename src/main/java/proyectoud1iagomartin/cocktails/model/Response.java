package proyectoud1iagomartin.cocktails.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * The type Response.
 */
public class Response {

    @JsonProperty("drinks")
    private ArrayList<Drinks> drinks = new ArrayList<Drinks>();

    /**
     * Gets drinks.
     *
     * @return the drinks
     */
    public ArrayList<Drinks> getDrinks() {
        return drinks;
    }

}