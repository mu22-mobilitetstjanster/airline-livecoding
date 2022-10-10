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
