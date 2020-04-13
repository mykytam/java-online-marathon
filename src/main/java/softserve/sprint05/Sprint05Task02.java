package softserve.sprint05;

import java.util.Calendar;

public class Sprint05Task02 {

    class User {
        protected String name;
        protected String surname;

        public User(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public String getFullName() {
            return String.join(" ", name, surname);
        }
    }

    class Student extends User {
        protected int year;

        public Student(int year, String name, String surname) {
            super(name, surname);
            this.year = year;
        }

        public int getCourseNumber() {
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            int course = (currentYear - year) + 1;
            if (course > 6 || course < 1) {
                course = -1;
            }
            return course;
        }
    }
}
