# Machine Problem 1.2 - Factory Method Design Pattern

This project follows the factory method design pattern as well as the MVC model 2 architecture. We employ the use of servlets and JSP pages as the 'controller' and the 'view' respectively.

## Controller

The ChooseSandwichServlet is the servlet that handles the request from index.jsp. It uses the Factory class to instantiate a new Sandwich object, using the option the user selected. After getting the newly-made Sandwich object, the page will be redirected to view.jsp.

## Model.Sandwich

The interface class that serves as the blueprint for the classes AmericanSub, Bacon, BaconEggCheese, BagelToast, and BakedBean.

## Model.AmericanSub, Model.Bacon, Model.BaconEggCheese, Model.BagelToast, Model.BakedBean

The children classes that implements the Sandwich interface and inherits the appropriate methods such as `getName()`, `getDescription()`, `getPrice()`, `getIngredients()`, `getCalorieCount()`, `getImageName()`, and overrides `printDetails()`.

## Utility

Contains the Factory class that is in charge of creating the Sandwiches. The Factory class contains a single method `createSandwich()` that accepts the string variable `sandwichType` and returns the corresponding object using a switch case.

## View

Displays the information of the selected sandwich to the user.

## UML Diagram

<p align="center">
    <img alt="DESPTRN - Machine Problem 1.2 UML" src="https://github.com/JSintos/DESPTRN/blob/machineproblem1.2/DESPTRN%20-%20Machine%20Problem%201.2%20UML.png?raw=true">
</p>

## Collaborators

[Joshua Lagarejos](https://github.com/joshualagarejos)  
[Joshua Sintos](https://github.com/JSintos)