package factoryMethod;

/**
 * Решает проблемы:
 * - когда заранее неизвестно, объекты каких типов необходимо создавать
 * - когда система должна быть независимой от процесса создания новых объектов и расширяемой: в нее можно легко
 * вводить новые классы, объекты которых система должна создавать
 * - когда создание новых объектов необходимо делегировать из базового класса классам наследникам
 */

public class FactoryMethodMain {
    public static void main(String[] args) {
        CoffeeShop italianCoffeeShop = new ItalianCoffeeShop();
        italianCoffeeShop.orderCoffee(CoffeeType.CAFFE_LATTE);

        CoffeeShop americanCoffeeShop = new AmericanCoffeeShop();
        americanCoffeeShop.orderCoffee(CoffeeType.CAFFE_LATTE);
    }
}

enum CoffeeType {
    ESPRESSO,
    AMERICANO,
    CAFFE_LATTE,
    CAPPUCCINO
}

abstract class CoffeeShop {

    public void orderCoffee(CoffeeType type) {
        Coffee coffee = createCoffee(type);

        coffee.printName();
        coffee.grindCoffee();
        coffee.makeCoffee();
        coffee.pourIntoCup();

        System.out.println("Вот ваш кофе! Спасибо, приходите еще!");
        System.out.println();
    }

    protected abstract Coffee createCoffee(CoffeeType type);
}

class ItalianCoffeeShop extends CoffeeShop {

    @Override
    public Coffee createCoffee(CoffeeType type) {
        return switch (type) {
            case AMERICANO -> new ItalianStyleAmericano();
            case ESPRESSO -> new ItalianStyleEspresso();
            case CAPPUCCINO -> new ItalianStyleCappuccino();
            case CAFFE_LATTE -> new ItalianStyleCaffeLatte();
        };
    }
}

class AmericanCoffeeShop extends CoffeeShop {
    @Override
    public Coffee createCoffee(CoffeeType type) {
        return switch (type) {
            case AMERICANO -> new AmericanStyleAmericano();
            case ESPRESSO -> new AmericanStyleEspresso();
            case CAPPUCCINO -> new AmericanStyleCappuccino();
            case CAFFE_LATTE -> new AmericanStyleCaffeLatte();
        };
    }
}

abstract class Coffee {

    String name;

    public Coffee(String name) {
        this.name = name;
    }

    public void printName() {
        System.out.println(this.name);
    }

    public void grindCoffee() {
        System.out.println("перемалываем кофе");
    }

    public void makeCoffee() {
        System.out.println("делаем кофе");
    }

    public void pourIntoCup() {
        System.out.println("наливаем в чашку");
    }
}

class ItalianStyleAmericano extends Coffee {
    public ItalianStyleAmericano() {
        super("ItalianStyleAmericano");
    }
}

class ItalianStyleCappuccino extends Coffee {
    public ItalianStyleCappuccino() {
        super("ItalianStyleCappuccino");
    }
}

class ItalianStyleCaffeLatte extends Coffee {
    public ItalianStyleCaffeLatte() {
        super("ItalianStyleCaffeLatte");
    }
}

class ItalianStyleEspresso extends Coffee {
    public ItalianStyleEspresso() {
        super("ItalianStyleEspresso");
    }
}

class AmericanStyleAmericano extends Coffee {
    public AmericanStyleAmericano() {
        super("AmericanStyleAmericano");
    }
}

class AmericanStyleCappuccino extends Coffee {
    public AmericanStyleCappuccino() {
        super("AmericanStyleCappuccino");
    }
}

class AmericanStyleCaffeLatte extends Coffee {
    public AmericanStyleCaffeLatte() {
        super("AmericanStyleCaffeLatte");
    }
}

class AmericanStyleEspresso extends Coffee {
    public AmericanStyleEspresso() {
        super("AmericanStyleEspresso");
    }
}
