# Machine Problem 3 - Singleton Design Pattern

This project follows the singleton design pattern, the abstract factory design pattern as well as the MVC model 2 architecture. We employ the use of servlets and JSP pages as the 'controller' and the 'view' respectively.

## Controller

* The HomepageServlet is the servlet that handles the request from index.jsp. It is tasked with manually creating the database tables and populating them.
* The ChooseMealServlet is the servlet that handles the request from chooseMeal.jsp. It uses the SandwichFactory and DrinkFactory classes to instantiate a new Sandwich object and a new Drink object respectively, using the options the user selected and inserts it into the meals table in the database shortly after. After getting the newly-made Sandwich and Drink objects, the page will be redirected to view.jsp. 

## Model.Sandwich

The interface class that serves as the blueprint for the classes AmericanSub, Bacon, BaconEggCheese, BagelToast, and BakedBean.

## Model.AmericanSub, Model.Bacon, Model.BaconEggCheese, Model.BagelToast, Model.BakedBean

The children classes that implements the Sandwich interface and inherits the appropriate methods such as `getName()`, `getDescription()`, `getPrice()`, `getIngredients()`, `getCalorieCount()`, `getImageName()`, and overrides `printDetails()`.

## Model.Drink

The interface class that serves as the blueprint for the classes Coke, Royal, MountainDew, and BottledWater.

## Model.Coke, Model.Royal, Model.MountainDew, Model.BottledWater

The children classes that implements the Drink interface and inherits the approrpriate methods such as `getName()`, `getPrice()`, `getImageName()`, and overrides `printDetails()`.

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


## View

Displays the information of the selected meal to the user.

## UML Diagram

<p align="center">
    <img alt="DESPTRN - Machine Problem 3 UML" src="https://github.com/JSintos/DESPTRN/blob/machineproblem3/DESPTRN%20-%20Machine%20Problem%203%20UML.png?raw=true">
</p>

## Collaborators

[Joshua Lagarejos](https://github.com/joshualagarejos)  
[Joshua Sintos](https://github.com/JSintos)