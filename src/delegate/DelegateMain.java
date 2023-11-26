package delegate;

/**
 * Решает проблемы:
 * - изменить поведение конкретного экземпляра объекта вместо создания нового класса путём наследования
 */
public class DelegateMain {
    public static void main(String[] args) {
        ControllerCar controllerCar = new ControllerCar(new BMW());
        controllerCar.drive();
        controllerCar.stop();
        System.out.println();
        controllerCar = new ControllerCar(new Seat());
        controllerCar.drive();
        controllerCar.stop();
    }
}

interface Car {
    void drive();

    void stop();
}

class ControllerCar implements Car {
    Car car;

    public ControllerCar(Car car) {
        this.car = car;
    }

    @Override
    public void drive() {
        System.out.println("Двигатель включен.");
        car.drive();
    }

    @Override
    public void stop() {
        car.stop();
        System.out.println("Двигатель выключен.");
    }
}

class BMW implements Car {
    @Override
    public void drive() {
        System.out.println("BMW drive...");
    }

    @Override
    public void stop() {
        System.out.println("BMW stop!");
    }
}

class Seat implements Car {
    @Override
    public void drive() {
        System.out.println("Seat drive...");
    }

    @Override
    public void stop() {
        System.out.println("Seat stop!");
    }
}