package com.example.immaculate.mygym;

public class InstructorsInformation {
    public String Name, PhoneNumber, Gym;

    public InstructorsInformation() {

    }


    public InstructorsInformation(String name, String phoneNumber, String gym) {
        Name = name;
        PhoneNumber = phoneNumber;
        Gym = gym;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getGym() {
        return Gym;
    }

    public void setGym(String gym) {
        Gym = gym;
    }
}
