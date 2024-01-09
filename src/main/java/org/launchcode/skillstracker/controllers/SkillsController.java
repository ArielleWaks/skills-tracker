package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // tells the project that this is the controller file
public class SkillsController {

    //best practice: name methods after routes they are pushing the web application to
    @ResponseBody //tells it to expect to see HTML
    @GetMapping() //corresponds to a Get request // localhost:8080 //if no arguments/routing, the default route will be the local host port
    public String skillsTracker() {
        return "<html>" +
                "<body>" +
                "<h1>Skills Tracker</h1>" +
                "<br><h2>List of Skills</h2><br>" +
                "<ol>Java</ol>" +
                "<ol>JavaScript</ol>" +
                "<ol>SQL</ol>" +
                "</body>" +
                "</html>"
                ;
    }

    @ResponseBody
//    @RequestMapping(value = "answers", method = {RequestMethod.GET, RequestMethod.POST})
    @GetMapping("form")
    public String form() {
        return """
                <html><body><form method = 'post' action = '/answers'><input type ='text' name = 'name' /><label for="first">Favorite Language</label><select id="first" name="first">
                  <option value="java">Java</option>
                  <option value="javascript">JavaScript</option>
                  <option value="sql">SQL</option>
                </select>
                <label for="second">Second Favorite Language</label><select id="second" name="second">
                  <option value="java">Java</option>
                  <option value="javascript">JavaScript</option>
                  <option value="sql">SQL</option>
                </select>
                 <label for="third">Third Favorite Language</label><select id="third" name="third">
                  <option value="java">Java</option>
                  <option value="javascript">JavaScript</option>
                  <option value="sql">SQL</option>
                </select>
                <input type = 'submit' value = 'Submit' /></form></body></html>""";
    }

    public String formOutput(String name, String a1, String a2, String a3) {
        return "<html><body><h1>" + name +
                "</h1><ol>1. " + a1 + "</ol><ol>2. " + a2 +
                "</ol><ol>3. " + a3 + "</ol>";
    }


    @ResponseBody
    @RequestMapping(value = "answers", method = {RequestMethod.POST})
    public String formPosting(@RequestParam String name, @RequestParam String first, @RequestParam String second, @RequestParam String third) {
        return formOutput(name, first, second, third);
    }


    // Class Examples:

//    @ResponseBody
//    @GetMapping("helloquery") //localhost:8080/helloquery
//    public String helloQuery(@RequestParam String name) {
//        if (name.isEmpty()) { //name.isBlank() would also work
//            name = "LaunchCode";
//        }
//        return String.format("<h1>Hello, %s!", name);
//    }
//
//    @ResponseBody
//    @GetMapping("hello/{name}") //localhost:8080/hello/{name}
//    public String helloPath(@PathVariable String name) {
//        if (name.isEmpty()) {
//            name = "LaunchCode";
//        }
//        return String.format("<h1>Hello, %s!", name);
//    }

}
