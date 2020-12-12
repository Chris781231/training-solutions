package exceptionclass.simpletime;

public class Course {

    private final SimpleTime begin;
    private final String name;

    public Course(String name, SimpleTime begin) {
        if (name == null || begin == null) {
            throw new IllegalArgumentException("name and/or begin is null");
        }
        this.name = name;
        this.begin = begin;
    }

    public String getName() {
        return name;
    }

    public SimpleTime getBegin() {
        return begin;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", begin, name);
    }
}
