package application.types.factorymethod;

import application.types.factorymethod.model.*;

public class MethodFactoryConcrete {

    // not good
    // because when add Vehicle new use modify this class , so use Factory registry class.
    public static Vehicle factoryMethodVehicle(EnumVehicle enums){
        if(EnumVehicle.BIKE.equals(enums)){
            return new Bike();
        }else if(EnumVehicle.CAR.equals(enums)){
            return new Car();
        }else if(EnumVehicle.MOTOR.equals(enums)){
            return new Motor();
        }
        return null;
    }

}
