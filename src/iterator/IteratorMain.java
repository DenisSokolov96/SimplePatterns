package iterator;

/**
 * Решает проблемы:
 * - получить последовательный доступ ко всем элементам составного объекта, скрывая его внутреннее представление
 */
public class IteratorMain {
    public static void main(String[] args) {
        String[] skills = {"Java", "Spring", "Maven", "PostgreSQL"};
        JavaDeveloper javaDeveloper = new JavaDeveloper("Ivanov Ivan", skills);
        Iterator iterator = javaDeveloper.getIterator();
        System.out.println("Developer : " + javaDeveloper.getName());
        while (iterator.hasNext()) {
            System.out.print(iterator.next().toString() + " ");
        }
    }
}

interface Iterator<T> {
    boolean hasNext();
    T next();
}

interface Collection<T> {
    Iterator<T> getIterator();
}

class JavaDeveloper<T> implements Collection<T> {
    private final String name;
    private final T[] skills;

    public JavaDeveloper(String name, T[] skills) {
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public T[] getSkills() {
        return skills;
    }

    @Override
    public Iterator getIterator() {
        return new SkillIterator();
    }

    private class SkillIterator implements Iterator<T> {
        int index;

        @Override
        public boolean hasNext() {
            return index < skills.length;
        }

        @Override
        public T next() {
            return skills[index++];
        }
    }
}