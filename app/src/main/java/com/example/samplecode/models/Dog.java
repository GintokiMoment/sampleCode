package com.example.samplecode.models;

import java.util.ArrayList;

public class Dog {
    public static ArrayList<Dog> allDogs = new ArrayList(){{
        add(new Dog(1, "Zyghost", true));
    }};
    private long  id;
    private String name;
    private boolean vaccinated;

    public Dog(int id, String name, boolean vaccinated) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    @Override
    public String toString(){
        String s = super.toString();

        return String.format("ID: %d NAME: %s VACCINATED: %b RAM: %s", this.id, this.name, this.vaccinated, s);
//                                  ^^^^ place holders.. memeory adress fr where string is.
                        // %s = string
    }
}
