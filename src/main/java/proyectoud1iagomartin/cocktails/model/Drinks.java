package proyectoud1iagomartin.cocktails.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


/**
 * The type Drinks.
 */
public class Drinks implements Serializable {

    @JsonProperty("strInstructionsDE")
    private String strInstructionsDE;

    @JsonProperty("strImageSource")
    private Object strImageSource;

    @JsonProperty("strIngredient10")
    private Object strIngredient10;

    //Nombre Cocktail
    @JsonProperty("strDrink")
    private String strDrink;

    @JsonProperty("strIngredient12")
    private Object strIngredient12;

    @JsonProperty("strIngredient11")
    private Object strIngredient11;

    @JsonProperty("strIngredient14")
    private Object strIngredient14;

    @JsonProperty("strCategory")
    private String strCategory;

    @JsonProperty("strAlcoholic")
    private String strAlcoholic;

    @JsonProperty("strIngredient13")
    private Object strIngredient13;

    @JsonProperty("strIngredient15")
    private Object strIngredient15;

    @JsonProperty("strCreativeCommonsConfirmed")
    private String strCreativeCommonsConfirmed;

    @JsonProperty("strIBA")
    private Object strIBA;

    @JsonProperty("strVideo")
    private Object strVideo;

    @JsonProperty("strTags")
    private Object strTags;

    @JsonProperty("strInstructions")
    private String strInstructions;

    @JsonProperty("strIngredient1")
    private String strIngredient1;

    @JsonProperty("strIngredient3")
    private String strIngredient3;

    @JsonProperty("strIngredient2")
    private String strIngredient2;

    @JsonProperty("strIngredient5")
    private Object strIngredient5;

    @JsonProperty("strIngredient4")
    private Object strIngredient4;

    @JsonProperty("strIngredient7")
    private Object strIngredient7;

    @JsonProperty("strIngredient6")
    private Object strIngredient6;

    @JsonProperty("strIngredient9")
    private Object strIngredient9;

    @JsonProperty("strInstructionsFR")
    private Object strInstructionsFR;

    @JsonProperty("strIngredient8")
    private Object strIngredient8;

    @JsonProperty("idDrink")
    private String idDrink;

    @JsonProperty("strInstructionsES")
    private Object strInstructionsES;

    @JsonProperty("strInstructionsIT")
    private String strInstructionsIT;

    @JsonProperty("strGlass")
    private String strGlass;

    @JsonProperty("strMeasure12")
    private Object strMeasure12;

    @JsonProperty("strMeasure13")
    private Object strMeasure13;

    @JsonProperty("strMeasure10")
    private Object strMeasure10;

    @JsonProperty("strMeasure11")
    private Object strMeasure11;

    @JsonProperty("strImageAttribution")
    private Object strImageAttribution;

    @JsonProperty("dateModified")
    private String dateModified;

    @JsonProperty("strDrinkAlternate")
    private Object strDrinkAlternate;

    @JsonProperty("strDrinkThumb")
    private String strDrinkThumb;

    @JsonProperty("strInstructionsZH-HANT")
    private Object strInstructionsZHHANT;

    @JsonProperty("strMeasure9")
    private Object strMeasure9;

    @JsonProperty("strMeasure7")
    private Object strMeasure7;

    @JsonProperty("strMeasure8")
    private Object strMeasure8;

    @JsonProperty("strMeasure5")
    private Object strMeasure5;

    @JsonProperty("strMeasure6")
    private Object strMeasure6;

    @JsonProperty("strMeasure3")
    private Object strMeasure3;

    @JsonProperty("strMeasure4")
    private Object strMeasure4;

    @JsonProperty("strMeasure1")
    private String strMeasure1;

    @JsonProperty("strMeasure2")
    private Object strMeasure2;

    @JsonProperty("strInstructionsZH-HANS")
    private Object strInstructionsZHHANS;

    @JsonProperty("strMeasure14")
    private Object strMeasure14;

    @JsonProperty("strMeasure15")
    private Object strMeasure15;

    /**
     * Instantiates a new Drinks.
     *
     * @param strDrink       the str drink
     * @param strIngredient1 the str ingredient 1
     * @param strIngredient2 the str ingredient 2
     * @param strIngredient3 the str ingredient 3
     */
    public Drinks(String strDrink, String strIngredient1, String strIngredient2, String strIngredient3, Object strIngredient4) {
        this.strDrink = strDrink;
        this.strIngredient1 = strIngredient1;
        this.strIngredient3 = strIngredient3;
        this.strIngredient2 = strIngredient2;
        this.strIngredient4 = strIngredient4;
    }

    /**
     * Instantiates a new Drinks.
     */
    public Drinks() {
    }


    /**
     * Gets str instructions de.
     *
     * @return the str instructions de
     */
    public String getStrInstructionsDE() {
        return strInstructionsDE;
    }

    /**
     * Gets str image source.
     *
     * @return the str image source
     */
    public Object getStrImageSource() {
        return strImageSource;
    }

    /**
     * Gets str ingredient 10.
     *
     * @return the str ingredient 10
     */
    public Object getStrIngredient10() {
        return strIngredient10;
    }

    /**
     * Gets str drink.
     *
     * @return the str drink
     */
    public String getStrDrink() {
        return strDrink;
    }

    /**
     * Gets str ingredient 12.
     *
     * @return the str ingredient 12
     */
    public Object getStrIngredient12() {
        return strIngredient12;
    }

    /**
     * Gets str ingredient 11.
     *
     * @return the str ingredient 11
     */
    public Object getStrIngredient11() {
        return strIngredient11;
    }

    /**
     * Gets str ingredient 14.
     *
     * @return the str ingredient 14
     */
    public Object getStrIngredient14() {
        return strIngredient14;
    }

    /**
     * Gets str category.
     *
     * @return the str category
     */
    public String getStrCategory() {
        return strCategory;
    }

    /**
     * Gets str alcoholic.
     *
     * @return the str alcoholic
     */
    public String getStrAlcoholic() {
        return strAlcoholic;
    }

    /**
     * Gets str ingredient 13.
     *
     * @return the str ingredient 13
     */
    public Object getStrIngredient13() {
        return strIngredient13;
    }

    /**
     * Gets str ingredient 15.
     *
     * @return the str ingredient 15
     */
    public Object getStrIngredient15() {
        return strIngredient15;
    }

    /**
     * Gets str creative commons confirmed.
     *
     * @return the str creative commons confirmed
     */
    public String getStrCreativeCommonsConfirmed() {
        return strCreativeCommonsConfirmed;
    }

    /**
     * Gets str iba.
     *
     * @return the str iba
     */
    public Object getStrIBA() {
        return strIBA;
    }

    /**
     * Gets str video.
     *
     * @return the str video
     */
    public Object getStrVideo() {
        return strVideo;
    }

    /**
     * Gets str tags.
     *
     * @return the str tags
     */
    public Object getStrTags() {
        return strTags;
    }

    /**
     * Gets str instructions.
     *
     * @return the str instructions
     */
    public String getStrInstructions() {
        return strInstructions;
    }

    /**
     * Gets str ingredient 1.
     *
     * @return the str ingredient 1
     */
    public String getStrIngredient1() {
        return strIngredient1;
    }

    /**
     * Gets str ingredient 3.
     *
     * @return the str ingredient 3
     */
    public String getStrIngredient3() {
        return strIngredient3;
    }

    /**
     * Gets str ingredient 2.
     *
     * @return the str ingredient 2
     */
    public String getStrIngredient2() {
        return strIngredient2;
    }

    /**
     * Gets str ingredient 5.
     *
     * @return the str ingredient 5
     */
    public Object getStrIngredient5() {
        return strIngredient5;
    }

    /**
     * Gets str ingredient 4.
     *
     * @return the str ingredient 4
     */
    public Object getStrIngredient4() {
        return strIngredient4;
    }

    /**
     * Gets str ingredient 7.
     *
     * @return the str ingredient 7
     */
    public Object getStrIngredient7() {
        return strIngredient7;
    }

    /**
     * Gets str ingredient 6.
     *
     * @return the str ingredient 6
     */
    public Object getStrIngredient6() {
        return strIngredient6;
    }

    /**
     * Gets str ingredient 9.
     *
     * @return the str ingredient 9
     */
    public Object getStrIngredient9() {
        return strIngredient9;
    }

    /**
     * Gets str instructions fr.
     *
     * @return the str instructions fr
     */
    public Object getStrInstructionsFR() {
        return strInstructionsFR;
    }

    /**
     * Gets str ingredient 8.
     *
     * @return the str ingredient 8
     */
    public Object getStrIngredient8() {
        return strIngredient8;
    }

    /**
     * Gets id drink.
     *
     * @return the id drink
     */
    public String getIdDrink() {
        return idDrink;
    }

    /**
     * Gets str instructions es.
     *
     * @return the str instructions es
     */
    public Object getStrInstructionsES() {
        return strInstructionsES;
    }

    /**
     * Gets str instructions it.
     *
     * @return the str instructions it
     */
    public String getStrInstructionsIT() {
        return strInstructionsIT;
    }

    /**
     * Gets str glass.
     *
     * @return the str glass
     */
    public String getStrGlass() {
        return strGlass;
    }

    /**
     * Gets str measure 12.
     *
     * @return the str measure 12
     */
    public Object getStrMeasure12() {
        return strMeasure12;
    }

    /**
     * Gets str measure 13.
     *
     * @return the str measure 13
     */
    public Object getStrMeasure13() {
        return strMeasure13;
    }

    /**
     * Gets str measure 10.
     *
     * @return the str measure 10
     */
    public Object getStrMeasure10() {
        return strMeasure10;
    }

    /**
     * Gets str measure 11.
     *
     * @return the str measure 11
     */
    public Object getStrMeasure11() {
        return strMeasure11;
    }

    /**
     * Gets str image attribution.
     *
     * @return the str image attribution
     */
    public Object getStrImageAttribution() {
        return strImageAttribution;
    }

    /**
     * Gets date modified.
     *
     * @return the date modified
     */
    public String getDateModified() {
        return dateModified;
    }

    /**
     * Gets str drink alternate.
     *
     * @return the str drink alternate
     */
    public Object getStrDrinkAlternate() {
        return strDrinkAlternate;
    }

    /**
     * Gets str drink thumb.
     *
     * @return the str drink thumb
     */
    public String getStrDrinkThumb() {
        return strDrinkThumb;
    }

    /**
     * Gets str instructions zhhant.
     *
     * @return the str instructions zhhant
     */
    public Object getStrInstructionsZHHANT() {
        return strInstructionsZHHANT;
    }

    /**
     * Gets str measure 9.
     *
     * @return the str measure 9
     */
    public Object getStrMeasure9() {
        return strMeasure9;
    }

    /**
     * Gets str measure 7.
     *
     * @return the str measure 7
     */
    public Object getStrMeasure7() {
        return strMeasure7;
    }

    /**
     * Gets str measure 8.
     *
     * @return the str measure 8
     */
    public Object getStrMeasure8() {
        return strMeasure8;
    }

    /**
     * Gets str measure 5.
     *
     * @return the str measure 5
     */
    public Object getStrMeasure5() {
        return strMeasure5;
    }

    /**
     * Gets str measure 6.
     *
     * @return the str measure 6
     */
    public Object getStrMeasure6() {
        return strMeasure6;
    }

    /**
     * Gets str measure 3.
     *
     * @return the str measure 3
     */
    public Object getStrMeasure3() {
        return strMeasure3;
    }

    /**
     * Gets str measure 4.
     *
     * @return the str measure 4
     */
    public Object getStrMeasure4() {
        return strMeasure4;
    }

    /**
     * Gets str measure 1.
     *
     * @return the str measure 1
     */
    public String getStrMeasure1() {
        return strMeasure1;
    }

    /**
     * Gets str measure 2.
     *
     * @return the str measure 2
     */
    public Object getStrMeasure2() {
        return strMeasure2;
    }

    /**
     * Gets str instructions zhhans.
     *
     * @return the str instructions zhhans
     */
    public Object getStrInstructionsZHHANS() {
        return strInstructionsZHHANS;
    }

    /**
     * Gets str measure 14.
     *
     * @return the str measure 14
     */
    public Object getStrMeasure14() {
        return strMeasure14;
    }

    /**
     * Gets str measure 15.
     *
     * @return the str measure 15
     */
    public Object getStrMeasure15() {
        return strMeasure15;
    }

    /**
     * Sets str ingredient 1.
     *
     * @param strIngredient1 the str ingredient 1
     */
    public void setStrIngredient1(String strIngredient1) {
        this.strIngredient1 = strIngredient1;
    }

    /**
     * Sets str drink.
     *
     * @param strDrink the str drink
     */
    public void setStrDrink(String strDrink) {
        this.strDrink = strDrink;
    }

    /**
     * Sets str ingredient 3.
     *
     * @param strIngredient3 the str ingredient 3
     */
    public void setStrIngredient3(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }

    /**
     * Sets str ingredient 2.
     *
     * @param strIngredient2 the str ingredient 2
     */
    public void setStrIngredient2(String strIngredient2) {
        this.strIngredient2 = strIngredient2;
    }

    /**
     * Sets str ingredient 4.
     *
     * @param strIngredient4 the str ingredient 4
     */
    public void setStrIngredient4(Object strIngredient4) {
        this.strIngredient4 = strIngredient4;
    }

    @Override
    public String toString() {
        return "Nombre = " + strDrink +
                ", Ingrediente 1 = " + strIngredient1 +
                ", Ingrediente 2 = " + strIngredient2 +
                ", Ingrediente 3 = " + strIngredient3 +
                ", Ingrediente 4 = " + strIngredient4 + "\n";
    }

}