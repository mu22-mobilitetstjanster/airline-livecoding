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
