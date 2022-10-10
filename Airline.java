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
