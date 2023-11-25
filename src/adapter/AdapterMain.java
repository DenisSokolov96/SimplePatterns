package adapter;

/**
 * Решает проблемы:
 * - когда необходимо использовать имеющийся класс, но его интерфейс не соответствует потребностям
 * - когда надо использовать уже существующий класс совместно с другими классами, интерфейсы которых не совместимы
 */

public class AdapterMain {
    public static void main(String[] args) {
        // путешественник
        Traveler traveler = new Traveler();
        // машина
        Auto auto = new Auto();
        // отправляемся в путешествие
        traveler.travel(auto);
        // пустыня, надо использовать верблюда
        Camel camel = new Camel();
        // используем адаптер
        ITransport camelTransport = new CamelToTransportAdapter(camel);
        // продолжаем путь по пескам пустыни
        traveler.travel(camelTransport);
    }
}

// интерфейс транспорта
interface ITransport {
    void drive();
}

// класс машины
class Auto implements ITransport {
    @Override
    public void drive() {
        System.out.println("Машина едет по дороге");
    }
}

class Traveler {
    public void travel(ITransport transport) {
        transport.drive();
    }
}

// интерфейс животного
interface IAnimal {
    void move();
}

//класс верблюд
class Camel implements IAnimal {
    @Override
    public void move() {
        System.out.println("Верблюд идет по пескам пустыни");
    }
}

// Адаптер от patternAdapter.Camel к patternAdapter.ITransport
class CamelToTransportAdapter implements ITransport {

    IAnimal animal;

    public CamelToTransportAdapter(IAnimal animal) {
        this.animal = animal;
    }
    @Override
    public void drive() {
        animal.move();
    }
}
