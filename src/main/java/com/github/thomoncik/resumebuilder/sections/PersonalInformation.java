package com.github.thomoncik.resumebuilder.sections;

import java.util.ArrayList;

public class PersonalInformation implements Section {

    final private Summary summary;
    final private Details details;

    public PersonalInformation(Summary summary, Details details) {
        this.summary = summary;
        this.details = details;
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
