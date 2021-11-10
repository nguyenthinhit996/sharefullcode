package pattern.creational.factory.astractfactory.functionfactoryvehiclewater.model;

import pattern.creational.factory.astractfactory.functionfactoryvehiclewater.RegistryVehicleWaterFactoryReflection;
import pattern.creational.factory.fucntionfactoryvehicleroad.RegistryVehicleRoadFactoryReflection;
import pattern.creational.factory.fucntionfactoryvehicleroad.model.Bike;
import pattern.creational.factory.fucntionfactoryvehicleroad.model.EnumVehicle;

public class Cano implements IVehicleWater{


    // registry factory reflection
    static {
        RegistryVehicleWaterFactoryReflection.getInstance().addNewIVehicleWater(EnumVehicle.CANO, Cano.class);
    }

    @Override
    public IVehicleWater createObject() {
        return new Cano();
    }
}
