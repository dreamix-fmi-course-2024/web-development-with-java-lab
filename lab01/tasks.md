# Java introduction tasks
For development purposes you can use any IDE(IntelliJ, Eclipse, STS) or text editor with compiler

Before starting your task create a package named bg.uni.fmi.lab01.baseline

When you are working on your solution you can create a single class Exercise where you can write your function solutions, or create class for each task (it's up to you).

# Task 1
Write a method that returns the nth odd element of an array. If the index of the element exceeds the list size, then throw Exception.
Example:
[5, 3, 8, 1, 9] 4 -> 9
[5, 3, 8, 1, 9] 5 -> throws Exception

# Task 2
Create a class named Person with two attributes: name and age. 
Implement 3 constructors:
 - without parameters setting up default parameters "No name" and -1
 - with 1 parameter for name and default value for age -1
 - with 2 parameters setting up the both attributes

Implement setters and getters

Implement string representation of the object -> Hello, I am < name >. I am < age > years old
Tip: override -> toString.

This implementation to have the following logic:
 - if the age is not set, then print Hello, I am < name >.
 - if the the name is not set, then print I am John Doe

## Task 3
Write a method to insert an element(String) into the array list at the first position

## Task 4
Write a method to retrieve an element(String) (at a specified index) from a given list.

## Task 5
Write a method to remove the third element(String) from an array list.

## Task 6
Write a method to search an element(String) in a list.

## Task 7
Write a method to sort a given array list. (list of String/Integer/Dog).
Implement Dog class with attribute breed and weight, sort the array by weight property.
Tip: implement the task with Comparator and Comparable

## Task 8
Write a method to replace the second element of a ArrayList with the specified element.

## Task 9
Write a Java program to count the number of key-value (size) mappings in a map.

## Task 10
Create a structure that will represent aircraft tail number (e.g 9H-VCA) against a list of leg information (fromAirport["LBSF"], toAirport["EBBR"], date).

Fill test information

Extract legs inside list/set that have from/to airport for a specific airport
(Example: All flight legs from airport LBSF)

FlightLeg {
    private String fromAirport;
    private String toAirport;
    private LocalDate date;
}

Map<String, List<Flightleg>>

# Streams

Before starting your task create a package named *bg.uni.fmi.lab01.streams*

# Task 11
Imagine you need to design a simple shop with a bascket. The following structure is used

High-level structure
```
User {List<Order>}
    Order {id, enum OrderStatus ; List<OrderLine> ; LocalDate orderDate ; enum PaymentMethod}
        OrderLine { quantity ; Item ; specialOffer }
            Item { String }
        PaymentMethod
```

![alt tag](https://github.com/dreamix-fmi-course-2024/web-development-with-java-lab/blob/main/lab01/class-diagram.png)

User will have a list of orders. An order will be a combination of status (enum), list of order items, date of order (LocalDate) and payment method (enum)

Order of implementation: Item -> OrderList -> PaymentMethod -> Order -> User

* Create a class named Item inside *entity* package which consists of name:String, description:String and price:BigDecimal.

* Create OrderLine which holds information for product, boolean specialOffer and count
Implement setters/getters/constructor

* Create class Order that holds information for id, status:OrderStatus, creationDate, totalPrice, paymentMethod, deliveryDueDate, user.
  * Write constructors: default by status, by id, by array of lines (use ...), getters, setters, toString, isActive

* Create a class User with list of orders

Write your enums in VO (value object) package;


```
package ....streams.vo;

public enum OrderStatus {
    DRAFT, ACTIVE, INACTIVE
}
```

```
package ....streams.vo;

public enum PaymentMethod {
    CARD,
    CASH_ON_SITE,
    CASH_ON_DELIVERY
}
```

```
package ....streams.entity;

public class Item {
    private String name;
    private String description;

    private BigDecimal price;
}
```



Write all your business logic inside *service* package (bg.uni.fmi.lab02.streams.service)

```
public class SearchExercise {

    /**
     * extract all active orders
     * @param user
     * @return List<Order>
     */
    public List<Order> getActiveOrders(User user) {
        return null;
    }

    public List<Order> getActiveOrdersByIteration(User user) {
        return null;
    }

    /**
     * Return order by a specific id
     * @param orders
     * @param orderId
     * @return Order
     */
    public Order getOrderById(List<Order> orders, long orderId) {
        return null;
    }

    public Order getOrderByIdIteration(List<Order> orders, long orderId) {
        return null;
    }

    /**
     * Return orders that have specific description for item
     * @param user
     * @param description
     * @return List<Order>
     */
    public List<Order> getOrdersThatHaveItemDescription(User user, String description) {
        return null;
    }

    /**
     * @return true if customer has at least one order with status ACTIVE
     */
    public boolean hasActiveOrders(User user) {
        return null;
    }

    /**
     * Return true if inside the Order we don't have OrderLine with special offer
     */
    public boolean canBeReturned(Order order) {
        return null;
    }

    /**
     * Return the order with maximum total price
     * @param user
     * @return
     */
    public Optional<Order> getMaxPriceOrder(User user) {
        return null;
    }
}
```

# Additional tasks
Create a Book store program. In the store we can have only one book from the same type.( Same type means book with same author, title and year). Our programm should implement all method from Store interface. 
```
public interface Store {

  /**
   * Add book to the store
   * @param o is the book which we want to add
   * @return true is the book is add successful and false is the book is already exists
   */
  boolean add(Book o);

  /**
   * Remove specific book from the store
   * @param o is the book which we want to remove
   */
  void remove(Book o);

  /**
   *  Get all books by Author
   * @param author
   * @return
   */
  List<Book> getAllBooksByAuthor(String author);

  /**
   * Get all books publish after specific year
   * @param from
   * @return
   */
  List<Book> getAllBooksPublishedAfter(LocalDate from);

  /**
   * Return all books between two dates
   * @param from
   * @param to
   * @return
   */
  List<Book> getAllBooksBetween(LocalDate from, LocalDate to);

  /**
   * Clear the whole book store
   */
  void clear();

  /**
   * Return all books grouped by author
   * @return
   */
  Map<String, List<Book>> getAllBooksGroupByAuthor();


  /**
   * Return all books grouped by publisher
   * @return
   */
  Map<String, List<Book>> getAllBooksGroupByPublisher();

  /**
   * Filter books by given filter
   * @param bookPredicate
   * @return
   */
  List<Book> getAllBooksFilterBy(Predicate<Book> bookPredicate);

}
```
Also, we have class Book:
```
public class Book {
  private String title;
  private String author;
  private BigDecimal price;
  private String publisher;
  private LocalDate publishedYear;
}
```

As a part of this task you should choose the correct collection for your Store implementation