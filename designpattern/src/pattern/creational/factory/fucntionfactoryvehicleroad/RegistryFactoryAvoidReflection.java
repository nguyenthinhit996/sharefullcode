package pattern.creational.factory.fucntionfactoryvehicleroad;

import pattern.creational.factory.fucntionfactoryvehicleroad.model.EnumVehicle;
import pattern.creational.factory.fucntionfactoryvehicleroad.model.IVehicleRoad;

import java.util.HashMap;
import java.util.Map;

/**
 * đăng kí với class cách 1
 * Singleton Class Registration - using reflection
 * mỗi type sản phẩm thêm mới sẽ tự đăng ký với class này không cần phải edit gì class này khi thêm 1 loại mới
 */
public class RegistryFactoryAvoidReflection {

    private static RegistryFactoryAvoidReflection registryFactoryConcrete;

    // map save vehicle
    private final Map<EnumVehicle, IVehicleRoad> MAP_REGISTRY = new HashMap<>();


    // add new vehicle when new class type vehicle
    public void addNewVehicle(EnumVehicle enumVehicle, IVehicleRoad classVehicle) {
        MAP_REGISTRY.put(enumVehicle, classVehicle);
    }

    // get instance vehicle
    public  IVehicleRoad factoryRegistryVehicle(EnumVehicle enumVehicle) {
        IVehicleRoad classVehicle = MAP_REGISTRY.get(enumVehicle);
        if (classVehicle != null) {
            return classVehicle.createVehicle();
        }
        return null;
    }

    public static synchronized RegistryFactoryAvoidReflection getInstance() {
        if (registryFactoryConcrete == null) {
            return registryFactoryConcrete = new RegistryFactoryAvoidReflection();
        }
        return registryFactoryConcrete;
    }
}
