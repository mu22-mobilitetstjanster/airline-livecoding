# Airline-livecoding index

1. [Main.java](#Main.java)
2. [Airline.java](#Airline.java)
3. [Airplane.java](#Airplane.java)
4. [ScheduledFlight.java](#ScheduledFlight.java)
5. [Passenger.java](#Passenger.java)
6. [Ticket.java](#Ticket.java)
7. [Luggage.java](#Luggage.java)

## Main.java<a id='Main.java'></a>

```java
import java.util.List;

public class Main {

  public static void main(String[] args) {

    Airline airline = new Airline("SAAS"); //name
    Airplane airplane = new Airplane("Boeing-757", 243); //model, capacity

    airline.addAirplane(airplane); // Add airplane to airplane list



    //origin, destination, duration (min)
    ScheduledFlight flight = new ScheduledFlight("Stockholm Arlanda", "Finland Helsinki", 60);
    airline.addFlight(flight); // Vi låter airline's minne hålla i detta flight

    flight = new ScheduledFlight("Stockholm Arlanda", "Paris", 240);
    airline.addFlight(flight);

    flight = new ScheduledFlight("Home", "Far far far away from them kittens", 99);
    airline.addFlight(flight);



    Passenger passenger = new Passenger("Bertil");
    boolean isSuccesful = airline.bookPassenger(passenger, "Stockholm Arlanda", "Paris");

    passenger = new Passenger("Annika");
    isSuccesful = airline.bookPassenger(passenger, "Stockholm Arlanda", "Paris");




    List<ScheduledFlight> flights = airline.getFlights();

    for (ScheduledFlight scheduledFlight : flights) {
      List<Passenger> passengers = scheduledFlight.getPassengers();

      System.out.println("Flight passenger amount: " + passengers.size());
      System.out.println("Flight origin: " + scheduledFlight.getOrigin());
      System.out.println("Flight destination: " + scheduledFlight.getDestination());
      System.out.println("Flight duration: " + scheduledFlight.getDuration());

      System.out.println("--Passenger list--");

      for (Passenger flightPassenger : passengers) {
        System.out.println("\tPassenger name: " + flightPassenger.getName());
      } // end of passenger for loop

      System.out.println(); // new line after each flight
    } // end of flight for loop
  }
}

```

## Airline.java<a id='Airline.java'></a>

```java
import java.util.ArrayList;
import java.util.List;

public class Airline {

  private List<Airplane> airplanes;
  private List<ScheduledFlight> flights;

  private String name;

  public Airline(String name) {
    this.name = name;
    this.airplanes = new ArrayList<>();
    this.flights = new ArrayList<>();
  }

  public List<ScheduledFlight> getFlights() {
    return flights;
  }

  public void addAirplane(Airplane airplane) {
    airplanes.add(airplane);
  }

  public void addFlight(ScheduledFlight flight) {
    flights.add(flight);
  }

  public boolean bookPassenger(Passenger passenger, String fromOrigin, String toDestination) {
    ScheduledFlight flight = new ScheduledFlight(fromOrigin, toDestination, 0);
    int flightIndex = flights.indexOf(flight); // internt använder equals för att hitta rätt flyg
    flight = flights.get(flightIndex); // Hämta den "Rätta" flight instansen


    flight.addPassenger(passenger);

    //System.out.println(flightIndex); // debugging

    return true;
  }
}
```

## Airplane.java<a id='Airplane.java'></a>

```java
public class Airplane {

  private String model;
  private int passengerCapacity;

  public Airplane(String model, int passengerCapacity) {
    this.model = model;
    this.passengerCapacity = passengerCapacity;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getPassengerCapacity() {
    return passengerCapacity;
  }

  public void setPassengerCapacity(int passengerCapacity) {
    this.passengerCapacity = passengerCapacity;
  }
}
```

## ScheduledFlight.java<a id='ScheduledFlight.java'></a>

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ScheduledFlight {
  private List<Passenger> passengers;

  private String origin;
  private String destination;
  private int duration; // in minutes

  public ScheduledFlight(String origin, String destination, int duration) {
    this.origin = origin;
    this.destination = destination;
    this.duration = duration;
    this.passengers = new ArrayList<>();
  }

  public void addPassenger(Passenger passenger) {
    passengers.add(passenger);
  }

  public List<Passenger> getPassengers() {
    return passengers;
  }

  public String getOrigin() {
    return origin;
  }

  public String getDestination() {
    return destination;
  }

  public int getDuration() {
    return duration;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ScheduledFlight that = (ScheduledFlight) o; //type casting
    return Objects.equals(origin, that.origin) && Objects.equals(destination, that.destination);
  }

  @Override
  public int hashCode() {
    return Objects.hash(origin, destination);
  }
}

```

## Passenger.java<a id='Passenger.java'></a>
```java
import java.util.List;

public class Passenger {

  private Ticket ticket;
  private List<Luggage> luggageList;

  private String name;

  public Passenger(String name) {
    this.name = name;
  }


  public String getName() {
    return name;
  }
}
```

## Ticket.java<a id='Ticket.java'></a>

```java
public class Ticket {
}
```

## Luggage.java<a id='Luggage.java'></a>

```java
public class Luggage {
}
```
