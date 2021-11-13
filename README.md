# Machine Problem 7 - Iterator Design Pattern

This project follows the iterator design pattern, builder design pattern, facade design pattern, prototype design pattern, singleton design pattern, abstract factory design pattern as well as the MVC model 2 architecture. We employ the use of servlets and JSP pages as the 'controller' and the 'view' respectively.

## Model.Item

The interface class that serves as the blueprint for the Sandwich, Drink, and Extra abstract classes.

## Model.Meal

The class that represents a Meal object. It contains the `addItem()` method which adds a meal item to the tray, the `getItems()` method which returns the list of meal items currently within the tray, and the `getItemsList()` method which returns a string version of the list of meal items currently within the tray delimited by commas.

## Model.MealBuilder

The class that provides the architecture of the different type of set meals users can choose from. Currently, we provide a selection of four set meals:
    * J&J 1 - Contains a sandwich and a drink
    * J&J 2 - Contains a sandwich, a drink, and an extra
    * J&J 3 - Contains a sandwich and an extra
    * J&J 4 - Contains just an extra

## Model.Sandwich

The abstract class that implements the Item interface as well as serving as the blueprint for the classes AmericanSub, Bacon, BaconEggCheese, BagelToast, and BakedBean.

## Model.AmericanSub, Model.Bacon, Model.BaconEggCheese, Model.BagelToast, Model.BakedBean

The children classes that extends from the Sandwich abstract class and implements its own functionality for the `clone()` method.

## Model.Drink

The abstract class that implements the Item interface as well as serving as the blueprint for the classes BottledWater, Coke, MountainDew, and Royal.

## Model.BottledWater, Model.Coke, Model.MountainDew, Model.Royal 

The children classes that extends from the Drink abstract class and implements its own functionality for the `clone()` method.

## Model.Extra

The abstract class that implements the Item interface as well as serving as the blueprint for the classes Chickennuggets, FrenchFries, and Sundae.

## Model.ChickenNuggets, Model.FrenchFries, Model.Sundae

The children classes that extends from the Extra abstract class and implements its own functionality for the `clone()` method.

## Model.Register

A class that implements the Facade interface. It contains the variables meal, quantity, and creditCardNumber as well as the appropriate getter and setter methods. It also contains the `validateCreditCard()` method which validates the inputted credit card number, the `getTotalCost()` method which computes for the meal's total cost, and the `processOrder()` method which acts as a facade for the whole automated process of ordering a meal. Successful orders with valid inputted credit card numbers are added to the meals table in the database and the number of meals ordered by the user is then subtracted from the total quantity of inventory.

## Model.InventoryManager

The class that handles the inventory amount of the sandwiches, drinks, and extras. It contains the `determineProduct()` helper method which returns the product type (sandwich, drink, or extra) given the product name, the `getInventoryAmount()` method which is tasked with retrieving the current inventory amount of a specific sandwich, drink, or extra, and the `deductInventory()` method that deducts the inventory amount of a specific sandwich, drink, or extra by the quantity inputted by the user.

## View

* view.jsp displays the information of the selected meal to the user.
* products.jsp displays the information of the list of products to the user.
* searchResults.jsp displays the search results (given a keyword) to the user.
* navbar.jsp is a partial that displays the navbar that is common to all the pages in our web application.

## Controller

* The HomepageServlet is the servlet that handles the request from index.jsp. It is tasked with manually creating the database tables and populating them as well as creating the sandwich, drink, and extra prototype clones basing it from the current list of products in our database and then sending it as a request attribute for products.jsp.
* The SearchResultServlet is the servlet that handles the search feature. It takes the keyword from the user input and searches the database using it. We then use the contents of the result set as a basis to determine which prototype clones our web application will display in searchResults.jsp.
* The ChooseMealServlet is the servlet that handles the request from chooseMeal.jsp wherein the user has the option to select a set meal and passes that information towards orderMeal.jsp.
* The OrderMealServlet is the servlet that handles the request from orderMeal.jsp. It uses the SandwichFactory, DrinkFactory, and ExtraFactory classes to instantiate a new Sandwich object, a new Drink object, and a new Extra object respectively, using the options the user selected. It then instantiates a new Meal object and sets it to null and uses the MealBuilder class to prepare a set meal and assigns the returned Meal object to the newly-instantiated Meal object. Additionally, it instantiates a new Register object as well that is tasked with processing the order which includes verifying if there’s sufficient inventory amount for the chosen meal items, validating the credit card number inputted by the user, inserting the meal into the meals table, and deducting the corresponding amount from our inventory in the database. After getting the newly-made meal Itm objects, the page will be redirected to view.jsp, displaying the meal items that the user ordered as well as the total cost and the meal's quantity. If our inventory has an insufficient amount of the chosen meal items, it will give the user an error message, prompting them to choose different meal items. If the inputted credit card number is invalid however, it will give the user an error message, prompting them to input a valid one.

## Utility

* Contains the SandwichFactory class that is in charge of creating the Sandwiches.
* Contains the DrinkFactory class that is in charge of creating the Drinks.
* Contains the ExtraFactory class that is in charge of creating the Extras.
* Contains the AbstractFactory class that is the parent class of the SandwichFactory, DrinkFactory, and ExtraFactory classes. The AbstractFactory class contains the `createSandwich()` method, the `createDrink()` method, and the `createExtra()` method that accepts the string variables sandwichType, drinkType, and extraType respectively and returns the corresponding objects using switch cases.
* Contains the SingletonDatabase class that handles all database functions. It contains seven methods: `getInstance()`, `getConnection()`, `createTables()`, `populateTables()`, `retrieveSandwiches()`, `retrieveDrinks`, `retrieveExtras()`, `insertMeal()`, `getSandwichSearchResults()`, `getDrinkSearchResults()`, and `getExtraSearchResults()`.
    * `getInstance()` - returns the connection instance.
    * `getConnection()` - returns either the current connection instance or a new connection instance.
    * `createTables()` - checks whether the sandwiches, drinks, extras, and meals tables already exist in the database and creates the aforementioned tables if they do not exist yet.
    * `populateTables()` - populates the newly created table (sandwiches, drinks, and extras) with data of specific sandwiches, drinks, and extras.
    * `retrieveSandwiches()` - retrieves the list of sandwiches from the database.
    * `retrieveDrinks()` - retrieves the list of drinks from the database.
    * `retrieveExtras()` - retrieves the list of extras from the database.
    * `insertMeal()` - inserts a meal record into the database.
    * `getSandwichSearchResults()` - returns the list of sandwich prototypes that are similar to a given keyword.
    * `getDrinkSearchResults()` - returns the list of drink prototypes that are similar to a given keyword.
    * `getExtraSearchResults()` - returns the list of extra prototypes that are similar to a given keyword.
* Contains the Prototype class that handles the object cloning for the Sandwich, Drink, and Extra classes. It contains the sandwichPrototypes, drinkPrototypes, and extraPrototypes maps that contain the respective prototypes of the sandwich, drink, and extra objects. It contains the `getSandwichPrototype()` method, the `getDrinkPrototype()` method, and the `getExtraPrototype()` that accepts the string variables sandwichType, drinkType, and extraType respectively and returns the corresponding prototype.
* Contains the Facade class that hides the whole automated process of ordering a meal.
* Contains the MealIterator class that acts as an interface for the Iterator design pattern.

## UML Diagram

<p align="center">
    <img alt="DESPTRN - Machine Problem 7 UML" src="https://github.com/JSintos/DESPTRN/blob/machineproblem7/DESPTRN%20-%20Machine%20Problem%207%20UML.png?raw=true">
</p>

## Collaborators

[Joshua Lagarejos](https://github.com/joshualagarejos)  
[Joshua Sintos](https://github.com/JSintos)