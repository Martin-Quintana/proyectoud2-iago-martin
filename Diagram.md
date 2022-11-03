classDiagram
direction BT
class DrinkController {
  + DrinkController() 
  - TextField name
  + export(ActionEvent) void
  + initialize(URL, ResourceBundle) void
   ActionEvent name
   ActionEvent random
}
class Drinks {
  + Drinks(String, String, String, String, Object) 
  + Drinks() 
  - Object strTags
  - Object strIngredient4
  - Object strIngredient15
  - Object strIngredient14
  - Object strIngredient11
  - String strInstructions
  - Object strIngredient6
  - String strIngredient3
  - String strDrinkThumb
  - String strMeasure1
  - Object strMeasure14
  - Object strMeasure4
  - Object strMeasure15
  - Object strDrinkAlternate
  - String strCategory
  - Object strMeasure11
  - Object strMeasure6
  - String strDrink
  - Object strMeasure13
  - Object strMeasure10
  - Object strMeasure9
  - Object strMeasure2
  - String strIngredient1
  - Object strIngredient13
  - Object strIBA
  - String strAlcoholic
  - String strGlass
  - Object strMeasure3
  - String strInstructionsIT
  - String strInstructionsDE
  - Object strMeasure8
  - Object strIngredient12
  - String strIngredient2
  - Object strInstructionsZHHANS
  - Object strIngredient7
  - String strCreativeCommonsConfirmed
  - Object strVideo
  - Object strMeasure5
  - String dateModified
  - Object strImageSource
  - Object strMeasure12
  - Object strMeasure7
  - Object strInstructionsZHHANT
  - Object strInstructionsES
  - Object strIngredient10
  - String idDrink
  - Object strIngredient5
  - Object strIngredient9
  - Object strImageAttribution
  - Object strIngredient8
  - Object strInstructionsFR
  + toString() String
   Object strTags
   Object strMeasure6
   Object strMeasure14
   String strGlass
   String strIngredient3
   Object strMeasure2
   String dateModified
   String idDrink
   Object strIngredient11
   Object strMeasure10
   Object strImageAttribution
   Object strIngredient7
   Object strIngredient15
   Object strMeasure7
   String strDrink
   Object strInstructionsZHHANS
   Object strImageSource
   String strMeasure1
   Object strMeasure15
   Object strInstructionsES
   Object strMeasure3
   String strAlcoholic
   Object strIngredient12
   Object strMeasure11
   Object strVideo
   Object strIngredient6
   Object strMeasure8
   Object strInstructionsZHHANT
   String strIngredient1
   Object strInstructionsFR
   Object strMeasure4
   Object strMeasure12
   Object strIngredient5
   Object strDrinkAlternate
   Object strIngredient13
   String strInstructionsIT
   Object strIngredient9
   String strCategory
   Object strMeasure5
   Object strIBA
   Object strMeasure9
   String strIngredient2
   String strCreativeCommonsConfirmed
   String strInstructionsDE
   Object strIngredient10
   Object strMeasure13
   Object strIngredient4
   String strInstructions
   Object strIngredient14
   String strDrinkThumb
   Object strIngredient8
}
class Encryption {
  + Encryption() 
  + readPass() void
  - base64Encode(byte[]) String
  + createSecretKey(char[], byte[], int, int) SecretKeySpec
  + encrypt(String, SecretKeySpec) String
  + decrypt(String, SecretKeySpec) String
  - base64Decode(String) byte[]
}
class Launcher {
  + Launcher() 
  + main(String[]) void
}
class LoginController {
  + LoginController() 
  - Stage stage
  + initialize(URL, ResourceBundle) void
  + LogIn(ActionEvent) void
   Stage stage
}
class Main {
  + Main() 
  + main(String[]) void
  + start(Stage) void
}
class Response {
  + Response() 
  - ArrayList~Drinks~ drinks
   ArrayList~Drinks~ drinks
}

DrinkController "1" *--> "tableDrinks *" Drinks 
Response "1" *--> "drinks *" Drinks 
