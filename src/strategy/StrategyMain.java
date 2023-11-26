package strategy;

/**
 * Стратегия имеет несколько реализаций, а на клиенте вызывается необходимая реализация
 * Решает проблемы:
 * - когда есть несколько родственных классов, которые отличаются поведением. Можно задать один основной класс,
 * а разные варианты поведения вынести в отдельные классы и при необходимости их применять.
 * - когда необходимо обеспечить выбор из нескольких вариантов алгоритмов,
 * которые можно легко менять в зависимости от условий
 * - когда необходимо менять поведение объектов на стадии выполнения программы
 * - когда класс, применяющий определенную функциональность, ничего не должен знать о ее реализации
 */
public class StrategyMain {
    public static void main(String[] args) {
        Developer developer = new Developer();
        developer.setActivity(new Sleeping());
        developer.executeActivity();
        developer.setActivity(new Training());
        developer.executeActivity();
        developer.setActivity(new Coding());
        developer.executeActivity();
        developer.setActivity(new Reading());
        developer.executeActivity();
    }
}

class Developer {
    Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void executeActivity() {
        if (activity != null) {
            activity.justDoIt();
        }
        else {
            System.out.println("Активность не найдена.");
        }

    }
}

interface Activity {
    void justDoIt();
}

class Coding implements Activity {
    @Override
    public void justDoIt() {
        System.out.println("Coding...");
    }
}

class Reading implements Activity {
    @Override
    public void justDoIt() {
        System.out.println("Reading...");
    }
}

class Sleeping implements Activity {
    @Override
    public void justDoIt() {
        System.out.println("Sleeping...");
    }
}

class Training implements Activity {
    @Override
    public void justDoIt() {
        System.out.println("Training...");
    }
}
