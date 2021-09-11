package pattern.creational.factory.astractfactory.functionfactoryvehiclewater.model;

import pattern.creational.factory.astractfactory.functionfactoryvehiclewater.RegistryVehicleWaterFactoryReflection;
import pattern.creational.factory.fucntionfactoryvehicleroad.model.EnumVehicle;

public class Ship implements IVehicleWater{

    // registry factory reflection
    static {
        RegistryVehicleWaterFactoryReflection.getInstance().addNewIVehicleWater(EnumVehicle.SHIP, Ship.class);
    }

    @Override
    public IVehicleWater createObject() {
        return new Ship();
    }
}
