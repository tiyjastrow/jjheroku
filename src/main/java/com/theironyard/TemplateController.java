package com.theironyard;

import com.theironyard.entities.Assignment;
import com.theironyard.repositories.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class TemplateController {

    @Autowired
    AssignmentRepository assignmentRepository;

    @RequestMapping(path = "/clear")
    public String clear(Model model){
        assignmentRepository.deleteAll();
        return "home";
    }

    @RequestMapping(path = "/")
    public String home(Model model){

        if(assignmentRepository.count() == 0) {
            ArrayList<Assignment> assignments = new ArrayList<>();

            assignments.add(new Assignment("Arrays and Classes", "Project name: HelloWorld", true));
            assignments.add(new Assignment("Methods", "Project name: Methods", true));
            assignments.add(new Assignment("Control Flow", "Project name: ATM", true));
            assignments.add(new Assignment("Dynamic Data Structures", "Project name: Banking", true));
            assignments.add(new Assignment("Review 1", "Project name: InventoryTracker", true));
            assignments.add(new Assignment("Object Oriented Programming", "Project name: OOinventory", true));
            assignments.add(new Assignment("File I/O", "Project name: FileIO", true));
            assignments.add(new Assignment("Testing and Debugging", "Project name: Countries", true));
            assignments.add(new Assignment("Review week 2", "Project name: People", true));
            assignments.add(new Assignment("JavaFX", "project called ContactsDesktop", false));
            assignments.add(new Assignment("Agile User Stories & TDD", "(1) Trello board, plus (2) project name starting TDD-", false));
            assignments.add(new Assignment("Android", "AndroidContacts", false));
            assignments.add(new Assignment("HTTP Routes and HTML Templates", "called Messages", true));
            assignments.add(new Assignment("Review Week 3", "Project Name: HangmanGame", true));
            assignments.add(new Assignment("HTTP Sessions", "Project Name: MoreMessages", true));
            assignments.add(new Assignment("Advanced HTTP Routes", "Fork the PeopleWeb project", true));
            assignments.add(new Assignment("SQL Basics", "GameTrackerDb", true));
            assignments.add(new Assignment("Review HTTP", "Project Name: CrudReviewHTTP", true));
            assignments.add(new Assignment("API Joins", "ToDoDb_Joins", true));
            assignments.add(new Assignment("JSON Routes (Spark)", "RegistrationForm", true));
            assignments.add(new Assignment("(Optional) SQL Review", "Project name: PeopleWebDb", true));
            assignments.add(new Assignment("Spring Basics", "Project Name: MicroblogSpring", true));
            assignments.add(new Assignment("Hibernate Basics", "microblogDb", true));
            assignments.add(new Assignment("Hibernate Query Methods and Joins", "Project: Purchases", false));
            assignments.add(new Assignment("Review Spring 1", "Project: SpringCRUD", false));
            assignments.add(new Assignment("JSON Routes", "Project: AnonUpload", true));
            assignments.add(new Assignment("JSON Routes Continued", "IronGram", true));
            assignments.add(new Assignment("More Spring Review", "Project: HannibalLecturer", false));
            assignments.add(new Assignment("Scala Basics", "Fork HelloScala project", false));
            assignments.add(new Assignment("Functional Scala", "ScalaPurchases", false));
            assignments.add(new Assignment("More Scala and Security", "ScalaTraits", false));
            assignments.add(new Assignment("Group Project", "Ping Pong Games Tracker", false));
            assignments.add(new Assignment("Playframework ...", "PlayGames", false));
            assignmentRepository.save(assignments);
        }

        model.addAttribute("assignments", assignmentRepository.findAll());

        return "home";
    }
}
