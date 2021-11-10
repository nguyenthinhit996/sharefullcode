package application.types.astractFactories.model.animals;

public interface IAnimal {

    String  makeSound();
    Float getWeight();

    IAnimal createInstance();
}
