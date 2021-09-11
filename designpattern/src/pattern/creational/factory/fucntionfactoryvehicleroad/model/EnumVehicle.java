package pattern.creational.factory.fucntionfactoryvehicleroad.model;

public enum EnumVehicle {
    CAR(1),
    BIKE(2),
    MOTOR(3),
    SHIP(4),
    CANO(5);

    private int index;
    EnumVehicle(int i){
        index=i;
    }
}
