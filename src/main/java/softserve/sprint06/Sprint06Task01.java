package softserve.sprint06;

// Create a maxDuration() method of the MyUtils class to return a list of Students with maximum duration of study and Workers with maximum experience.

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}

class Student extends Person {
    private String studyPlace;
    private int studyYears;

    public Student(String name, String studyPlace, int studyYears) {
        super(name);
        this.studyPlace = studyPlace;
        this.studyYears = studyYears;
    }

    public String getStudyPlace() {
        return studyPlace;
    }

    public int getStudyYears() {
        return studyYears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return studyYears == student.studyYears && Objects.equals(getName(), student.getName()) &&
                Objects.equals(studyPlace, student.studyPlace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studyPlace, studyYears, getName());
    }
}

class Worker extends Person {
    private String workPosition;
    private int experienceYears;

    public Worker(String name, String workPosition, int experienceYears) {
        super(name);
        this.workPosition = workPosition;
        this.experienceYears = experienceYears;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;
        Worker worker = (Worker) o;
        return experienceYears == worker.experienceYears && Objects.equals(getName(), worker.getName()) &&
                Objects.equals(workPosition, worker.workPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workPosition, experienceYears, getName());
    }
}

class MyUtils1 {
    public List<Person> maxDuration(List<Person> persons) {

        Integer maxStudent = persons.stream()
                .filter(Objects::nonNull)
                .filter(person -> person instanceof Student)
                .map(person -> (Student) person)
                .map(student -> student.getStudyYears())
                .max(Integer::compareTo)
                .get();

        List<Person> studentList = persons.stream()
                .filter(Objects::nonNull)
                .filter(person -> person instanceof Student)
                .map(person -> (Student) person)
                .filter(student -> student.getStudyYears() == maxStudent)
                .distinct()
                .collect(Collectors.toList());


        Integer maxWorker = persons.stream()
                .filter(Objects::nonNull)
                .filter(person -> person instanceof Worker)
                .map(person -> (Worker) person)
                .map(worker -> worker.getExperienceYears())
                .max(Integer::compareTo)
                .get();

        List<Person> workerList = persons.stream()
                .filter(Objects::nonNull)
                .filter(person -> person instanceof Worker)
                .map(person -> (Worker) person)
                .filter(worker -> worker.getExperienceYears() == maxWorker)
                .distinct()
                .collect(Collectors.toList());

        studentList.addAll(workerList);
        return studentList;
    }
}
