# Machine Problem 4 - Prototype Design Pattern

This project follows the prototype design pattern, singleton design pattern, the abstract factory design pattern as well as the MVC model 2 architecture. We employ the use of servlets and JSP pages as the 'controller' and the 'view' respectively.

## Controller

* The HomepageServlet is the servlet that handles the request from index.jsp. It is tasked with manually creating the database tables and populating them as well as creating the sandwich and drink prototype clones basing it from the current list of products in our database and then sending it as a request attribute for products.jsp.
* The ChooseMealServlet is the servlet that handles the request from chooseMeal.jsp. It uses the SandwichFactory and DrinkFactory classes to instantiate a new Sandwich object and a new Drink object respectively, using the options the user selected and inserts it into the meals table in the database shortly after. After getting the newly-made Sandwich and Drink objects, the page will be redirected to view.jsp.
* The SearchResultServlet is the servlet that handles the search feature. It takes the keyword from the user input and searches the database using it. We then use the contents of the result set as a basis to determine which prototype clones our web application will display in searchResults.jsp.

## Model.Sandwich

The interface class that serves as the blueprint for the classes AmericanSub, Bacon, BaconEggCheese, BagelToast, and BakedBean.

## Model.AmericanSub, Model.Bacon, Model.BaconEggCheese, Model.BagelToast, Model.BakedBean

The children classes that implements the Sandwich interface and inherits the appropriate methods such as `getName()`, `getDescription()`, `getPrice()`, `getIngredients()`, `getCalorieCount()`, `getImageName()`, `clone()`, and overrides `printDetails()`.

## Model.Drink

The interface class that serves as the blueprint for the classes Coke, Royal, MountainDew, and BottledWater.

## Model.Coke, Model.Royal, Model.MountainDew, Model.BottledWater

The children classes that implements the Drink interface and inherits the approrpriate methods such as `getName()`, `getPrice()`, `getImageName()`, `clone()`, and overrides `printDetails()`.

## Utility

* Contains the SandwichFactory class that is in charge of creating the Sandwiches.
* Contains the DrinkFactory class that is in charge of creating the Drinks.
* Contains the AbstractFactory class that is the parent class of both the SandwichFactory and the DrinkFactory classes. The AbstractFactory class contain two methods, the `createSandwich()` and the `createDrink()` methods, that accepts the string variables `sandwichType` and `drinkType` respectively and returns the corresponding objects using switch cases.
* Contains the SingletonDatabase class that handles all database functions. It contains seven methods: `getInstance()`, `getConnection()`, `createTables()`, `populateTables()`, `retrieveSandwiches()`, `retrieveDrinks`, and `insertMeal()`.
    * `getInstance()` - returns the connection instance.
    * `getConnection()` - returns either the current connection instance or a new connection instance.
    * `createTables()` - checks whether the sandwiches, drinks, and meals tables already exist in the database and creates the aforementioned tables if they do not exist yet.
    * `populateTables()` - populates the newly created tables (sandwiches and drinks) with data of specific sandwiches and drinks.
    * `retrieveSandwiches()` - retrieves the list of sandwiches from the database.
    * `retrieveDrinks()` - retrieves the list of drinks from the database
    * `insertMeal()` - inserts a meal record into the database.
* Contains the Prototype class that handles the object cloning for the Sandwich and Drink classes. It contains the sandwichPrototypes and drinkPrototypes maps that contain the respective prototypes of the sandwich and drink objects. It contains two methods, the getSandwichPrototype() and the getDrinkPrototype() methods, that accepts the string variables sandwichType and drinkType respectively and returns the corresponding prototype.

## View

* view.jsp displays the information of the selected meal to the user.
* products.jsp displays the information of the list of products to the user.
* searchResults.jsp displays the search results (given a keyword) to the user.

## UML Diagram

<p align="center">
    <img alt="DESPTRN - Machine Problem 4 UML" src="https://github.com/JSintos/DESPTRN/blob/machineproblem4/DESPTRN%20-%20Machine%20Problem%204%20UML.png?raw=true">
</p>

## Collaborators

[Joshua Lagarejos](https://github.com/joshualagarejos)  
[Joshua Sintos](https://github.com/JSintos)