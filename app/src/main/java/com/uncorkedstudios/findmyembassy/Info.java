package com.uncorkedstudios.findmyembassy;

/**
 * Created by Kat on 4/12/15.
 */
public class Info {

    public String name;
    public String address;
    public String phoneNumber;

    public Info(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
