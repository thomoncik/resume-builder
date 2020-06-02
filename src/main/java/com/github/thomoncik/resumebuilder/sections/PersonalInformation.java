package com.github.thomoncik.resumebuilder.sections;

import java.util.ArrayList;

public class PersonalInformation implements Section {

    final private ArrayList<Website> websites;
    final private Summary summary;
    final private Details details;

    public PersonalInformation(ArrayList<Website> websites, Summary summary, Details details) {
        this.websites = websites;
        this.summary = summary;
        this.details = details;
    }


    public static class Website {
        public String label;
        public String link;
    }

    public static class Summary {
        public String description;
    }

    public static class Details {
        public String jobTitle;
        public String firstName;
        public String lastName;
        public String email;
        public String phone;
        public String country;
        public String city;
        public String address;
        public String postalCode;
        public String drivingLicense;
        public String nationality;
        public String placeOfBirth;
        public String dateOfBirth;
    }

    @Override
    public StringBuilder process() {
        // TODO generate
        return null;
    }
}
