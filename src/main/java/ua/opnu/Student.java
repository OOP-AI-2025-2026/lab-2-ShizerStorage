package ua.opnu;

public class Student {
    String name;
    int year;
    String[] courses;

    Student(String name, int year) {
        if (name == null || name.trim().isEmpty() && year < 1 || year > 4) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.year = year;
        this.courses = new String[0];
    }

    void addCourse(String courseName) {
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("courseName is null");
        }
        String[] newCourses = new String[this.courses.length + 1];
        System.arraycopy(this.courses, 0, newCourses, 0, this.courses.length);
        newCourses[newCourses.length - 1] = courseName;
        this.courses = newCourses;
    }

    void dropAll() {
        this.courses = new String[0];
    }

    public int getCourseCount() {
        return this.courses.length;
    }

    public String getName() {
        return this.name;
    }

    public int getTuition() {
        return this.year * 20000;
    }

    public int getYear() {
        return this.year;
    }

    public static void main(String[] args) {
        Student s = new Student("Test", 4);

        s.addCourse("Maths");
        s.addCourse("IT");
        s.addCourse("Physics");

        System.out.println(s.getName() + ": courses - " + s.getCourseCount());
        System.out.println(s.getName() + ": year - " + s.getYear());
        System.out.println(s.getName() + ": paid for tuition - " + s.getTuition());

        s.dropAll();

        System.out.println("Courses after dropping - " + s.getCourseCount());
    }
}
