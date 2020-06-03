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

    private StringBuilder processAdditionalInformation(Details details){
        StringBuilder result = new StringBuilder();
        result.append("\\begin{DETAILS}{")
                .append(resolveEmpty(details.address))
                .append("}{")
                .append(resolveEmpty(details.city))
                .append("}{")
                .append(resolveEmpty(details.postalCode))
                .append("}{")
                .append(resolveEmpty(details.country))
                .append("}{")
                .append(resolveEmpty(details.phone))
                .append("}{")
                .append(resolveEmpty(details.email))
                .append("}\n")
                .append("\\end{DETAILS}\n\n");
        return result;
    }

    private String resolveEmpty(String string) {
        return string == null || string.isEmpty() || string.isBlank() ? "" : string;
    }

    private StringBuilder processName(Details details){
        StringBuilder result = new StringBuilder();
        result.append("\\begin{NAME}{")
                .append(resolveEmpty(details.firstName))
                .append("}{")
                .append(resolveEmpty(details.lastName))
                .append("}\n")
                .append("\\end{NAME}\n\n");
        return result;
    }

    private StringBuilder processImportantInformation(Details details){
        StringBuilder result = new StringBuilder();
        result.append("\\begin{INFO}{")
                .append(resolveEmpty(details.jobTitle))
                .append("}{")
                .append(resolveEmpty(details.city))
                .append("}{")
                .append(resolveEmpty(details.phone))
                .append("}\n")
                .append("\\end{INFO}\n\n");
        return result;
    }

    private StringBuilder processBirth(Details details){
        StringBuilder result = new StringBuilder();
        result.append("\\begin{BIRTH}{")
                .append(resolveEmpty(details.dateOfBirth))
                .append("}{")
                .append(resolveEmpty(details.placeOfBirth))
                .append("}\n")
                .append("\\end{BIRTH}\n\n");
        return result;
    }

    private StringBuilder processDriving(Details details){
        StringBuilder result = new StringBuilder();
        result.append("\\begin{DRIVING}{")
                .append(resolveEmpty(details.drivingLicense))
                .append("}\n")
                .append("\\end{DRIVING}\n\n");
        return result;
    }

    private StringBuilder processNationality(Details details){
        StringBuilder result = new StringBuilder();
        result.append("\\begin{NATIONALITY}{")
                .append(resolveEmpty(details.nationality))
                .append("}\n")
                .append("\\end{NATIONALITY}\n\n");
        return result;
    }

    private  StringBuilder processSummary(Summary summary){
        StringBuilder result = new StringBuilder();
        result.append("\\begin{SUMMARY}{")
                .append(resolveEmpty(summary.description))
                .append("}\n")
                .append("\\end{SUMMARY}\n\n");
        return result;
    }

    @Override
    public StringBuilder process() {
        StringBuilder result = new StringBuilder();
        result.append(processName(this.details));
        result.append(processImportantInformation(this.details));
        result.append(processAdditionalInformation(this.details));
        result.append(processBirth(this.details));
        result.append(processNationality(this.details));
        result.append(processDriving(this.details));
        result.append(processSummary(this.summary));
        return result;
    }
}
