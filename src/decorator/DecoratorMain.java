package decorator;

/**
 * Решает проблемы:
 * - Когда надо динамически добавлять к объекту новые функциональные возможности.
 * При этом данные возможности могут быть сняты с объекта
 * - Когда применение наследования неприемлемо. Например, если нам надо определить множество различных функциональностей
 * и для каждой функциональности наследовать отдельный класс, то структура классов может очень сильно разрастись.
 * Еще больше она может разрастись, если нам необходимо создать классы, реализующие все возможные сочетания
 * добавляемых функциональностей.
 */

public class DecoratorMain {
    public static void main(String[] args) {
        Pizza pizza1 = new ItalianPizza();
        pizza1 = new TomatoPizza(pizza1); // итальянская пицца с томатами
        System.out.println("Название: " + pizza1.getName());
        System.out.println("Цена: " + pizza1.getCost() + "$");

        Pizza pizza2 = new ItalianPizza();
        pizza2 = new CheesePizza(pizza2);// итальянская пиццы с сыром
        System.out.println("Название: " + pizza2.getName());
        System.out.println("Цена: " + pizza2.getCost() + "$");

        Pizza pizza3 = new BulgerianPizza();
        pizza3 = new TomatoPizza(pizza3);
        pizza3 = new CheesePizza(pizza3);// болгарская пиццы с томатами и сыром
        System.out.println("Название: " + pizza3.getName());
        System.out.println("Цена: " + pizza3.getCost() + "$");
    }
}

abstract class Pizza {
    private final String name;

    public Pizza(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getCost();
}

class ItalianPizza extends Pizza {

    public ItalianPizza() {
        super("Итальянская пицца");
    }

    @Override
    public int getCost() {
        return 10;
    }
}

class BulgerianPizza extends Pizza {

    public BulgerianPizza() {
        super("Болгарская пицца");
    }

    @Override
    public int getCost() {
        return 8;
    }
}

abstract class PizzaDecorator extends Pizza {
    protected Pizza pizza;

    public PizzaDecorator(String name, Pizza pizza) {
        super(name);
        this.pizza = pizza;
    }
}

class TomatoPizza extends PizzaDecorator {

    public TomatoPizza(Pizza pizza) {
        super(pizza.getName() + ", с томатами", pizza);
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 3;
    }
}

class CheesePizza extends PizzaDecorator {

    public CheesePizza(Pizza pizza) {
        super(pizza.getName() + ", с сыром", pizza);
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 5;
    }
}
