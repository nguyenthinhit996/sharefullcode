package pattern.creational.factory.astractfactory.main;

import pattern.creational.factory.fucntionfactoryvehicleroad.model.EnumVehicle;

public interface AbstractFactory<T> {
    T createObject(EnumVehicle enumVehicle);
}
