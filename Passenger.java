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
