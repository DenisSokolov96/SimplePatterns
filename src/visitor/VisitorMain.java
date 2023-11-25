package visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Решает проблемы:
 * - когда имеется много объектов разнородных классов с разными интерфейсами, и требуется выполнить ряд операций
 * над каждым из этих объектов
 * - когда классам необходимо добавить одинаковый набор операций без изменения этих классов
 * - когда часто добавляются новые операции к классам,
 * при этом общая структура классов стабильна и практически не изменяется
 */

public class VisitorMain {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.add(new Person("Иван Алексеев", "82184931"));
        bank.add(new Company("Microsoft", "ewuir32141324", "3424131445"));
        bank.accept(new HtmlVisitor());
        bank.accept(new XmlVisitor());
    }
}

interface IVisitor {
    void visitPersonAcc(Person acc);

    void visitCompanyAc(Company acc);
}

// сериализатор в HTML
class HtmlVisitor implements IVisitor {
    @Override
    public void visitPersonAcc(Person acc) {
        System.out.println("HtmlVisitor");
        String result = "Свойство : Значение \n" +
                " Name : " + acc.getName() + "\n" +
                " Number : " + acc.getNumber();
        System.out.println(result);
        System.out.println();
    }

    @Override
    public void visitCompanyAc(Company acc) {
        System.out.println("HtmlVisitor");
        String result = "Свойство : Значение \n" +
                " Name : " + acc.getName() + "\n" +
                " RegNumber : " + acc.getRegNumber() + "\n" +
                " Number : " + acc.getNumber();
        System.out.println(result);
        System.out.println();
    }
}

// сериализатор в XML
class XmlVisitor implements IVisitor {
    @Override
    public void visitPersonAcc(Person acc) {
        System.out.println("XmlVisitor");
        String result = "Свойство : Значение \n" +
                " Name : " + acc.getName() + "\n" +
                " Number : " + acc.getNumber();
        System.out.println(result);
        System.out.println();
    }

    @Override
    public void visitCompanyAc(Company acc) {
        System.out.println("XmlVisitor");
        String result = "Свойство : Значение \n" +
                " Name : " + acc.getName() + "\n" +
                " RegNumber : " + acc.getRegNumber() + "\n" +
                " Number : " + acc.getNumber();
        System.out.println(result);
        System.out.println();
    }
}

class Bank {
    List<IAccount> accounts = new ArrayList<>();

    public void add(IAccount acc) {
        accounts.add(acc);
    }

    public void remove(IAccount acc) {
        accounts.remove(acc);
    }

    public void accept(IVisitor visitor) {
        for (IAccount acc : accounts)
            acc.accept(visitor);
    }
}

interface IAccount {
    void accept(IVisitor visitor);
}

class Person implements IAccount {

    String name;
    String number;

    public Person(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitPersonAcc(this);
    }
}

class Company implements IAccount {
    String name;
    String regNumber;
    String number;

    public Company(String name, String regNumber, String number) {
        this.name = name;
        this.regNumber = regNumber;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitCompanyAc(this);
    }
}
