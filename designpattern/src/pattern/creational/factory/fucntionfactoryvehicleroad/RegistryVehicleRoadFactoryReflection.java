package pattern.creational.factory.fucntionfactoryvehicleroad;

import pattern.creational.factory.astractfactory.main.AbstractFactory;
import pattern.creational.factory.astractfactory.main.RegistryFunctionFactoryNonReflection;
import pattern.creational.factory.fucntionfactoryvehicleroad.model.Bike;
import pattern.creational.factory.fucntionfactoryvehicleroad.model.EnumVehicle;
import pattern.creational.factory.fucntionfactoryvehicleroad.model.IVehicleRoad;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * đăng kí với class cách 1
 * Singleton Class Registration - using reflection
 * mỗi type sản phẩm thêm mới sẽ tự đăng ký với class này không cần phải edit gì class này khi thêm 1 loại mới
 */
public class RegistryVehicleRoadFactoryReflection implements AbstractFactory<IVehicleRoad> {

    // registry factory reflection with abstract factory
    static {
        RegistryFunctionFactoryNonReflection.getInstance().addNewVehicle("road", getInstance());
    }

    //private constructor to avoid client applications to use constructor
    private RegistryVehicleRoadFactoryReflection(){}

    private static RegistryVehicleRoadFactoryReflection registryFactoryConcrete;

    // map save vehicle
    private final Map<EnumVehicle,  Class<IVehicleRoad>> MAP_REGISTRY = new HashMap<>();

    // add new vehicle when new class type vehicle
    public void addNewVehicle(EnumVehicle enumVehicle,  Class classVehicle){
        MAP_REGISTRY.put(enumVehicle, classVehicle);
    }

    // get instance vehicle
    public IVehicleRoad factoryRegistryVehicle(EnumVehicle enumVehicle){
        try {
            //Reflection class to instance
            Class<IVehicleRoad> classVehicle = MAP_REGISTRY.get(enumVehicle);
            Constructor<IVehicleRoad> productConstructor = classVehicle.getDeclaredConstructor();
            return productConstructor.newInstance();
        }catch( Exception e) {
            return null;
        }
    }

    public static synchronized RegistryVehicleRoadFactoryReflection getInstance(){
         if(registryFactoryConcrete == null){
             return registryFactoryConcrete = new RegistryVehicleRoadFactoryReflection();
         }
         return registryFactoryConcrete;
    }


    // abstract factory , factory of factory
    @Override
    public IVehicleRoad createObject(EnumVehicle enumVehicle) {
        return factoryRegistryVehicle(enumVehicle);
    }

}
