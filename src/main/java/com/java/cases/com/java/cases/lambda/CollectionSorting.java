package com.java.cases.com.java.cases.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionSorting {

    public static void main(String[] args){

        /**
         * Java 7
         */
        Comparator<User> byName = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Comparator<User> byId = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getId() - o2.getId();
            }
        };

        List<User> compareJ7 = createUserList();

        System.out.println("Java 7");
        System.out.println(compareJ7);
        Collections.sort(compareJ7, byName);
        System.out.println(compareJ7);

        Collections.sort(compareJ7, byId);
        System.out.println(compareJ7);


        /**
         * Java 8
         */
        List<User> compareJ8 = createUserList();

        System.out.println("Java 8");
        System.out.println(compareJ8);
        compareJ8.sort(byName);
        System.out.println(compareJ8);

        compareJ8.sort(byId);
        System.out.println(compareJ8);

    }

    private static List<User> createUserList(){

        List<User> users = new ArrayList<User>();

        for (int i = 0; i <= 10; i++) {
            users.add(new User(i, "MyName-"+i, i*10));
        }
        return users;
    }

}

class User{

    private int id;

    private String name;

    private int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
