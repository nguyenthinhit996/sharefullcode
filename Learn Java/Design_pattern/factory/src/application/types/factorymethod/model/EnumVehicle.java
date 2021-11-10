package application.types.factorymethod.model;

public enum EnumVehicle {
    CAR(1),
    BIKE(2),
    MOTOR(3);

    private int index;
    EnumVehicle(int i){
        index=i;
    }
}
