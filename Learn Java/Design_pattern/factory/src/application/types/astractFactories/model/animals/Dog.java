package application.types.astractFactories.model.animals;

import application.types.astractFactories.factorys.AnimalFactory;

public class Dog implements IAnimal{

    static{
        AnimalFactory.registryAnimal("DOG", new Dog());
    }

    @Override
    public String makeSound() {
        return "DOG";
    }

    @Override
    public Float getWeight() {
        return 10.5f;
    }

    @Override
    public IAnimal createInstance() {
        return new Dog();
    }
}
