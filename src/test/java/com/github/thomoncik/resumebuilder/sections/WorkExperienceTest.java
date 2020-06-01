package com.github.thomoncik.resumebuilder.sections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WorkExperienceTest {

    @Test
    void canNotProcessNull() {
        WorkExperience workExperience = new WorkExperience(null);
        assertNull(workExperience.process());
    }

    @Test
    void canNotProcessEmpty() {
        WorkExperience workExperience = new WorkExperience(new ArrayList<>());
        assertNull(workExperience.process());
    }

    @Test
    void emptyFields() {
        WorkExperience.Job emptyJob = new WorkExperience.Job();
        ArrayList<WorkExperience.Job> jobs = new ArrayList<>();
        jobs.add(emptyJob);
        WorkExperience workExperience = new WorkExperience(jobs);
        assertEquals(beginning() +
                "\\begin{WORK}{}{}{}{}\n" +
                "\\end{WORK}\n\n" +
                ending(), workExperience.process().toString());
    }

    @Test
    void allFields() {
        ArrayList<WorkExperience.Job> jobs = new ArrayList<>();
        jobs.add(exampleJob());
        WorkExperience workExperience = new WorkExperience(jobs);
        assertEquals(beginning() +
                "\\begin{WORK}{Software architect}{Jan 2012 - Feb 2020}{Employer}{Warsaw, Poland}\n" +
                "\\end{WORK}\n\n" +
                ending(), workExperience.process().toString());
    }

    @Test
    void noStartDate(){
        ArrayList<WorkExperience.Job> jobs = new ArrayList<>();
        WorkExperience.Job job = exampleJob();
        job.startDate = null;
        jobs.add(job);
        WorkExperience workExperience = new WorkExperience(jobs);
        assertEquals(beginning() +
                "\\begin{WORK}{Software architect}{}{Employer}{Warsaw, Poland}\n" +
                "\\end{WORK}\n\n" +
                ending(), workExperience.process().toString());
    }

    @Test
    void noEndDate(){
        ArrayList<WorkExperience.Job> jobs = new ArrayList<>();
        WorkExperience.Job job = exampleJob();
        job.endDate = null;
        jobs.add(job);
        WorkExperience workExperience = new WorkExperience(jobs);
        assertEquals(beginning() +
                "\\begin{WORK}{Software architect}{Jan 2012}{Employer}{Warsaw, Poland}\n" +
                "\\end{WORK}\n\n" +
                ending(), workExperience.process().toString());
    }

    @Test
    void startEqualsEndDate(){
        ArrayList<WorkExperience.Job> jobs = new ArrayList<>();
        WorkExperience.Job job = exampleJob();
        job.endDate = job.startDate;
        jobs.add(job);
        WorkExperience workExperience = new WorkExperience(jobs);
        assertEquals(beginning() +
                "\\begin{WORK}{Software architect}{Jan 2012}{Employer}{Warsaw, Poland}\n" +
                "\\end{WORK}\n\n" +
                ending(), workExperience.process().toString());
    }



    private WorkExperience.Job exampleJob(){
        WorkExperience.Job job = new WorkExperience.Job();
        job.title = "Software architect";
        job.employer = "Employer";
        job.startDate = "Jan 2012";
        job.endDate = "Feb 2020";
        job.location = "Warsaw, Poland";
        return job;
    }

    private String beginning(){
        return "\\begin{cvsection}{Employment history}\n\n";
    }

    private String ending(){
        return "\\end{cvsection}\n\n";
    }



//
//    @Test
//    void processAllNull() {
//        Education.University university = new Education.University();
//        ArrayList<Education.University> universities = new ArrayList<>();
//        universities.add(university);
//        Education education = new Education(universities);
//        assertEquals("\\begin{cvsection}{Education}\n\n" +
//                "\\begin{EDUCATION}{}{}{}{}\n" +
//                "\\end{EDUCATION}\n\n" +
//                "\\end{cvsection}", education.process());
//    }

}