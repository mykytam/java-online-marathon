package com.softserve.itacademy.model;

import java.util.Arrays;
import java.util.Iterator;

enum SortOrder {
    ASC, DESC
}

public class AddressBook implements Iterable<NameAddressPair> {
    private static AddressBook addressBookInstance;
    private NameAddressPair[] addressBook;
    private Person person;
    private int counter = 0;

    private AddressBook(int size) {
        addressBook = new NameAddressPair[size];
    }

    public static AddressBook getInstance() {
        if (addressBookInstance == null) {
            addressBookInstance = new AddressBook(5);
        }
        return addressBookInstance;
    }

    public boolean create(String firstName, String lastName, String address) {
        if (addressBook.length == counter) {
            addressBook = Arrays.copyOf(addressBook, 2 * counter);
        }
        Person person = new Person(firstName, lastName);
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].getPerson().equals(person)) {
                return false;
            }
        }
        addressBook[counter++] = new NameAddressPair(person, address);
        return true;
    }

    public String read(String firstName, String lastName) {
        Person person = new Person(firstName, lastName);
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].getPerson().equals(person)) {
                return addressBook[i].getAddress();
            }
        }
        return null;
    }

    public boolean update(String firstName, String lastName, String address) {
        Person person = new Person(firstName, lastName);
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].getPerson().equals(person)) {
                addressBook[i].setAddress(address);
                return true;
            }
        }
        return false;
    }

    public boolean delete(String firstName, String lastName) {
        Person person = new Person(firstName, lastName);
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].getPerson().equals(person)) {
                NameAddressPair[] newAddressBook = new NameAddressPair[addressBook.length];
                System.arraycopy(addressBook, 0, newAddressBook, 0, i);
                System.arraycopy(addressBook, i + 1, newAddressBook, i, addressBook.length - i - 1);
                addressBook = newAddressBook;
                counter--;
                return true;
            }
        }
        return false;
    }

    public int size() {
        return counter;
    }

    @Override
    public AddressBookIterator iterator() {
        return new AddressBookIterator();
    }

    public void sortedBy(SortOrder order) {
        switch (order) {
            case ASC:
                Arrays.sort(addressBook, (pair1, pair2) -> {
                    if (pair1 == null || pair2 == null) return 0;
                    return pair1.getPerson().getFirstName().compareTo(pair2.getPerson().getFirstName()) == 0 ?
                            pair1.getPerson().getLastName().compareTo(pair2.getPerson().getLastName()) :
                            pair1.getPerson().getFirstName().compareTo(pair2.getPerson().getFirstName());
                });
                break;
            case DESC:
                Arrays.sort(addressBook, (pair1, pair2) -> {
                    if (pair1 == null || pair2 == null) return 0;
                    return pair1.getPerson().getFirstName().compareTo(pair2.getPerson().getFirstName()) == 0 ?
                            -pair1.getPerson().getLastName().compareTo(pair2.getPerson().getLastName()) :
                            -pair1.getPerson().getFirstName().compareTo(pair2.getPerson().getFirstName());
                });
        }
    }

    private class AddressBookIterator implements Iterator<NameAddressPair> {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < AddressBook.this.counter;
        }

        @Override
        public NameAddressPair next() {
            return addressBook[counter++];
        }
    }

}