package application.types.factorymethod.model;

public interface Vehicle {

    Vehicle createVehicle();

    String getType();
}
