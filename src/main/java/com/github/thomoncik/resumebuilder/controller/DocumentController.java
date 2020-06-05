package com.github.thomoncik.resumebuilder.controller;

import com.github.thomoncik.resumebuilder.model.document.Resume;
import com.github.thomoncik.resumebuilder.model.sections.PersonalInformation;
import com.github.thomoncik.resumebuilder.model.sections.Section;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class DocumentController {
    public static final Logger logger = LoggerFactory.getLogger(DocumentController.class);

    @GetMapping("/example-document")
    public String exampleDocument(Model model) {
        ArrayList<Section> sections = new ArrayList<>();
        PersonalInformation.Summary summary = new PersonalInformation.Summary();
        summary.description = "Big and safe to have at your side if you want to discover the world underneath the sea." +
                " The blue shark can swim very far, dive really deep and hear your heart beating from far away.\n" +
                "I am good at hugging, comforting and listening and are fond of play and mischief. \n\n " +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum vitae nunc dui. Aliquam erat volutpat. " +
                "Nullam lobortis, velit in facilisis ultrices, risus sapien tincidunt sem, bibendum volutpat lacus diam non" +
                " lectus. Proin magna orci, facilisis nec sollicitudin ut, pulvinar vitae urna. Praesent non porttitor nulla. " +
                "Ut faucibus, lorem id pharetra varius, velit magna dignissim mi, vitae pellentesque purus est nec velit. " +
                "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nullam ac imperdiet felis." +
                " Vestibulum sed turpis quis orci fringilla aliquam. Sed in dui sed erat imperdiet maximus. Duis ut quam nunc.\n" +
                "\n" +
                "Vivamus iaculis, lectus vel porttitor volutpat, elit dui facilisis nulla, non iaculis eros est id tortor." +
                " Praesent dolor tellus, tristique eget libero sed, malesuada tristique lacus. Donec pulvinar augue consequat " +
                "congue iaculis. Vestibulum in tincidunt ipsum. Sed tristique pellentesque malesuada. Etiam id sagittis est," +
                " sit amet condimentum lorem. Vivamus suscipit velit accumsan lectus pretium hendrerit. Nulla semper feugiat" +
                " enim. Vivamus lacinia metus ut arcu sodales laoreet.\n" +
                "\n" +
                "Aliquam rhoncus pretium vestibulum. Aenean non accumsan lorem. Nulla porta luctus dolor, sed interdum ligula " +
                "dapibus eget. Etiam finibus sodales ipsum, facilisis rutrum nisl. Pellentesque ligula purus, mattis nec mi vel, " +
                "tempor imperdiet massa. In tincidunt sodales odio, quis pretium metus. Curabitur rhoncus libero ac nisl " +
                "fermentum feugiat. Vestibulum pulvinar felis in consectetur porta. Duis dui sem, rutrum ac pharetra vitae, " +
                "pharetra et orci. Etiam hendrerit velit at suscipit molestie. Ut malesuada finibus fermentum. Aenean aliquam " +
                "ante a lorem auctor aliquam. In vitae diam eget nisi feugiat egestas a vel ligula. Cras quis nisl congue," +
                " luctus ligula vel, pharetra dolor. Vivamus aliquam libero nec rutrum imperdiet";

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
        sections.add(new PersonalInformation(summary, details));

        Resume resume = new Resume(sections);
        model.addAttribute("resume", resume.process());
//        PDFGenerator generator = new PDFGenerator();
//        generator.generate(resume.process(), new File("./src/main/resources/templates/simple.cls"));

        return "resume";
    }
}
