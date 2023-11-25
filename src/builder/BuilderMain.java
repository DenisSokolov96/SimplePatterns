package builder;

/**
 * Решает проблемы:
 * - когда процесс создания нового объекта не должен зависеть от того,
 * из каких частей этот объект состоит и как эти части связаны между собой
 * - когда необходимо обеспечить получение различных вариаций объекта в процессе его создания
 */

public class BuilderMain {
    public static void main(String[] args) {
        Auto auto1 = Auto.builder()
                .engine("V8")
                .power("550")
                .body("coupe")
                .color("yellow")
                .build();
        System.out.println(auto1.toString());

        Auto auto2 = Auto.builder()
                .engine("R6")
                .power("240")
                .body("pickup")
                .build();
        System.out.println(auto2.toString());
    }
}

class Auto {

    private final String power;
    private final String color;
    private final String body;
    private final String engine;

    private Auto(AutoBuilder autoBuilder) {
        this.power = autoBuilder.power;
        this.color = autoBuilder.color;
        this.body = autoBuilder.body;
        this.engine = autoBuilder.engine;
    }

    public static AutoBuilder builder() {
        return new AutoBuilder();
    }

    public String getPower() {
        return power;
    }

    public String getColor() {
        return color;
    }

    public String getBody() {
        return body;
    }

    public String getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return "Auto{\n" +
                notNull(" engine : ", engine) +
                notNull(" power : ", power) +
                notNull(" color : ", color) +
                notNull(" body : ", body) +
                '}';
    }

    private String notNull(String name, String value) {
        return value != null ? name + value + ",\n" : "";
    }

    protected static class AutoBuilder {
        private String power;
        private String color;
        private String body;
        private String engine;

        public AutoBuilder() {
        }

        public AutoBuilder power(String power) {
            this.power = power;
            return this;
        }

        public AutoBuilder color(String color) {
            this.color = color;
            return this;
        }

        public AutoBuilder body(String body) {
            this.body = body;
            return this;
        }

        public AutoBuilder engine(String engine) {
            this.engine = engine;
            return this;
        }

        public Auto build() {
            return new Auto(this);
        }
    }

}
