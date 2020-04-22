package softserve.sprint07;

// Create class hierarchy that represent Address Book, where can be save records in format: "(first name, last name) => address":

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;

enum SortOrder {
    ASC,
    DESC;
}

class AddressBook implements Iterable {
    private NameAddressPair[] addressBook;
    private int counter = 0;

    public AddressBook(int capacity) {
        addressBook = new NameAddressPair[capacity];
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "addressBook=" + Arrays.toString(addressBook) +
                ", counter=" + counter +
                '}';
    }

    public boolean create(String firstName, String lastName, String address) {
        NameAddressPair.Person mem = new NameAddressPair.Person(firstName, lastName);

        for (NameAddressPair nameAddressPair : addressBook) {
            if (counter != 0 && nameAddressPair != null && nameAddressPair.getPerson().equals(mem)) {
                return false;
            }
        }

        if (addressBook.length == counter) {
            addressBook = Arrays.copyOf(addressBook, addressBook.length * 2);
        }
        addressBook[counter++] = new NameAddressPair(mem, address);
        return true;
    }

    public String read(String firstName, String lastName) {
        NameAddressPair.Person mem = new NameAddressPair.Person(firstName, lastName);

        for (int i = 0; i < counter; i++) {
            if (addressBook[i].getPerson().equals(mem)) {
                return addressBook[i].getAddress();
            }
        }
        return null;
    }

    public boolean update(String firstName, String lastName, String address) {
        NameAddressPair.Person mem = new NameAddressPair.Person(firstName, lastName);

        for (int i = 0; i < counter; i++) {
            if (addressBook[i].getPerson().equals(mem)) {
                addressBook[i] = new NameAddressPair(new NameAddressPair.Person(firstName, lastName), address);
                return true;
            }
        }
        return false;
    }

    public boolean delete(String firstName, String lastName) {
        NameAddressPair.Person mem = new NameAddressPair.Person(firstName, lastName);

        for (int i = 0; i < counter; i++) {
            if (addressBook[i].getPerson().equals(mem)) {
                int numMoved = counter - i - 1;
                // delete
                addressBook[i] = null;
                System.arraycopy(addressBook, i + 1, addressBook, i, numMoved);
                addressBook[--counter] = null;
                return true;
            }
        }
        return false;
    }

    public int size() {
        return counter;
    }

    public void sortedBy(SortOrder order) {
        switch (order) {
            case ASC:
                Arrays.sort(addressBook, (o1, o2) -> o1.getPerson().compareTo(o2.person));
            case DESC:
                Arrays.sort(addressBook, Collections.reverseOrder());
        }
    }

    public Iterator iterator() {
        return new AddressBookIterator();
    }

    private static class NameAddressPair {
        private final Person person;
        private String address;

        private NameAddressPair(Person person, String address) {
            this.person = person;
            this.address = address;
        }

        @Override
        public String toString() {
            return "NameAddressPair{" +
                    "person=" + person +
                    ", address='" + address + '\'' +
                    '}';
        }

        public Person getPerson() {
            return person;
        }

        public String getAddress() {
            return address;
        }

        private static class Person implements Comparable<Person> {
            private String firstName;
            private String lastName;


            private Person(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            @Override
            public String toString() {
                return "Person{" +
                        "firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        '}';
            }

            public String getFirstName() {
                return firstName;
            }

            public String getLastName() {
                return lastName;
            }


            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Person)) return false;
                Person person = (Person) o;
                return Objects.equals(firstName, person.firstName) &&
                        Objects.equals(lastName, person.lastName);
            }

            @Override
            public int compareTo(Person o) {
                return toString().compareTo(o.toString());
            }
        }
    }

    private class AddressBookIterator implements Iterator {
        private int counter = 0;

        public boolean hasNext() {
            return counter < addressBook.length && addressBook[counter] != null;
        }

        public String next() {
            String toReturn = "First name:" + addressBook[counter++].getPerson().firstName + ", Last name:" + addressBook[counter++].getPerson().lastName + ", Address:" + addressBook[counter++].getAddress();
            return toReturn;
        }
    }
}

