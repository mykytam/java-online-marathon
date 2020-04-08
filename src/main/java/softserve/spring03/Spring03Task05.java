package softserve.spring03;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/*
Create the commonStudents() method of the MyUtils class to return a HashSet of common elements of two student lists.
For example, for a given list1 [Students [id=1, name=Ivan], Students [id=2, name=Petro], Students [id=3, name=Stepan]]
and list2 [Students [id=1, name=Ivan], Students [id=3, name=Stepan], Students [id=4, name=Andriy]]
you should get [Students [id=3, name=Stepan], Students [id=1, name=Ivan]].
 */

public class Spring03Task05 {
    public static class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return id == student.id &&
                    Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }
    public Set<Student> commonStudents(List<Student> list1, List<Student> list2) {
        list1.retainAll(list2);
        System.out.println(list1);
        Set<Student> sameStudent = new HashSet<>(list1);
        return sameStudent;
    }
}
