package com.github.thomoncik.resumebuilder.model.tempate;

import com.github.thomoncik.resumebuilder.model.sections.*;
import com.github.thomoncik.resumebuilder.model.sections.grading.GradingScale;
import com.github.thomoncik.resumebuilder.model.sections.grading.NumberScale;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

class TemplateTest {

    private WorkExperience workExperience;
    private Education education;
    private Courses courses;
    private PersonalInformation personalInformation;
    private Hobby hobby;
    private Languages languages;
    private Links links;
    private AccessibleSkills accessibleSkills;

    void setUpWorkExperience(){
        WorkExperience.Job toyJob = new WorkExperience.Job();
        toyJob.title = "Stuffed animal toy";
        toyJob.employer = "Julia's home";
        toyJob.startDate = "Oct 2019";
        toyJob.endDate = "Present";
        toyJob.location = "Krakow, Poland";
        toyJob.description = "Promoted fun and learning each and every day.\nWas very good boy for hugging";

        WorkExperience.Job ikeaJob = new WorkExperience.Job();
        ikeaJob.title = "Blahaj toy";
        ikeaJob.employer = "IKEA";
        ikeaJob.startDate = "Jan 2019";
        ikeaJob.endDate = "Oct 2019";
        ikeaJob.location = "Warsaw, Poland";

        ArrayList<WorkExperience.Job> jobs = new ArrayList<>();
        jobs.add(ikeaJob);
        jobs.add(toyJob);

        this.workExperience = new WorkExperience(jobs);
    }

    void setUpEducation(){
        Education.University university = new Education.University();
        university.name = "IKEA University";
        university.degree = "Bachelor degree";
        university.startDate = "Jan 2019";
        university.endDate = "Oct 2019";
        university.location = "Warsaw, Poland";
        university.description = "Faculty of Philosophy";

        ArrayList<Education.University> universities = new ArrayList<>();
        universities.add(university);

        this.education = new Education(universities);
    }

    void setUpCourses(){
        Courses.Course soft = new Courses.Course();
        soft.name = "Sharks Softness Course";
        soft.institution = "IKEA";
        soft.startDate = "Jan 2019";
        soft.endDate = "Jul 2019";

        Courses.Course polite = new Courses.Course();
        polite.name = "Sharks Politeness Course";
        polite.institution = "IKEA";
        polite.startDate = "Jan 2019";
        polite.endDate = "May 2019";

        ArrayList<Courses.Course> courses = new ArrayList<>();
        courses.add(soft);
        courses.add(polite);

        this.courses = new Courses(courses);
    }

    void setUpPersonalInformation(){
        PersonalInformation.Summary summary = new PersonalInformation.Summary();
        summary.description = "Big and safe to have at your side if you want to discover the world underneath the sea." +
                " The blue shark can swim very far, dive really deep and hear your heart beating from far away.\n" +
                "I am good at hugging, comforting and listening and are fond of play and mischief.";

        PersonalInformation.Details details = new PersonalInformation.Details();
        details.firstName = "Rekin";
        details.lastName = "Blahaj";
        details.city = "Krakow";
        details.jobTitle = "Blue Shark";
        details.address = "Toy Street, 7";
        details.country = "Poland";
        details.postalCode = "30-404";
        details.phone = "123 456 789";
        details.email = "rekin.blahaj@ikea.com";

        this.personalInformation = new PersonalInformation(summary, details);
    }

    void setUpHobby(){
        this.hobby = new Hobby("I like philosophy and sleeping");
    }

    void setUpLanguages(){
        Languages.Language english = new Languages.Language();
        english.name = "English";
        english.level = Languages.Level.A1;

        Languages.Language sharks = new Languages.Language();
        sharks.name = "Sharks";
        sharks.level = Languages.Level.C1;

        Languages.Language polish = new Languages.Language();
        polish.name = "Polish";

        ArrayList<Languages.Language> languages = new ArrayList<>();
        languages.add(english);
        languages.add(sharks);
        languages.add(polish);

        this.languages = new Languages(languages);
    }

    void setUpLinks(){
        Links.Website ikea = new Links.Website();
        ikea.label = "IKEA";
        ikea.link = "ikea.com";

        ArrayList<Links.Website> websites = new ArrayList<>();
        websites.add(ikea);

        this.links = new Links(websites);
    }


    void setUpSkills(){
        AccessibleSkills.Skill cute = new AccessibleSkills.Skill();
        cute.name = "Being cute";
        cute.level = GradingScale.Level.FIVE;

        AccessibleSkills.Skill nice = new AccessibleSkills.Skill();
        nice.name = "Being nice";
        nice.level = GradingScale.Level.FOUR;

        ArrayList<AccessibleSkills.Skill> skills = new ArrayList<>();
        skills.add(cute);
        skills.add(nice);

        this.accessibleSkills = new AccessibleSkills(new NumberScale(), skills);
    }

    @BeforeEach
    void setUp() {
        setUpPersonalInformation();
        setUpEducation();
        setUpWorkExperience();
        setUpCourses();
        setUpHobby();
        setUpLanguages();
        setUpLinks();
        setUpSkills();
    }

    public String process() {
        ArrayList<Section> sections = new ArrayList<>();
        sections.add(this.personalInformation);
        sections.add(this.education);
        sections.add(this.workExperience);
        sections.add(this.courses);
        sections.add(this.accessibleSkills);
        sections.add(this.languages);
        sections.add(this.links);
        sections.add(this.hobby);
        Template template = new Template(sections);
        return template.process();
    }
}