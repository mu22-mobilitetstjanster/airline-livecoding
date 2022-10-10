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
