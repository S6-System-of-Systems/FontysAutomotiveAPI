package com.fontys_automotive.api.tus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fontys_automotive.api.teacher.Teacher;
import com.fontys_automotive.api.teacher.TeacherService;
import com.fontys_automotive.api.tus.models.project.*;
import com.fontys_automotive.api.tus.models.teacher.*;
import com.fontys_automotive.api.tus.models.teacher.Address;
import com.fontys_automotive.api.tus.models.teacher.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tus")

public class TusController {


    

    private final String token = "Token bede488d6d102a1df433467d632198d11818796a";
    private final TeacherService teacherService;

    @Autowired
    public TusController(TeacherService _teacherService){this.teacherService = _teacherService;}
    @GetMapping("/CV")
    public ResponseEntity<?> postTeachers(Teacher teacher){

        URL url = null;
        {
            try {
                url = new URL("https://import.8vance.com/data_import/structured_data_import/");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        
        teacher = teacherService.getTeachers().get(0);

        ArrayList<String> skills = new ArrayList<>();
        skills.addAll(teacher.getSkills());
        skills.addAll(teacher.getResponsibilities());

        //ROOT
        Cv cv = new Cv(
                Long.toString(teacher.getId()),
                //PERSON
                new Person(
                        new Name(teacher.getFirstName() + " " + teacher.getLastName()),
                        new Communication(
                                new Address("The Netherlands", "Eindhoven"),
                                teacher.getEmail(),
                                new ArrayList<>(
                                        List.of(
                                            new Web("https://google.com", "Google"),
                                            new Web("https://Hyves.com", "Hyves rip"),
                                            new Web(teacher.getLinkedIn(), "LinkedIn"))
                                )
                        ),
                        "female",
                        new ArrayList<>()
                ),
               //PROFILE
               new Profile(
                       "es",
                       new Source(
                               "linkedin",
                               teacher.getLinkedIn(),
                               LocalDate.now().toString()
                       ),
                       //QUALIFICATIONS,
                       skills,

                       //HOBBIES
                       new ArrayList<>(teacher.getAmbitions()),

                       //LANGUAGES
                       new ArrayList<>(
                               List.of(
                                       new Language("English", "Full Professionaly proficiency"),
                                       new Language("Dutch", "Native or bilingual proficiency")
                               )
                       ),

                       //GROUPS
                       new ArrayList<>(
                               List.of(
                                       new Group( "https://www.linkedin.com/groups", "Talent Management")
                               )
                       ),
                       teacher.getAboutMe()
               )

        );

        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(cv);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        HttpURLConnection connection;
        String result = "";
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", token);
            connection.setRequestMethod("POST");


            OutputStream stream = connection.getOutputStream();
            stream.write(json.getBytes("UTF-8"));
            stream.close();

            InputStream inputstream = new BufferedInputStream(connection.getInputStream());
            //String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
            result = new BufferedReader(new InputStreamReader(inputstream))
                    .lines().collect(Collectors.joining("\n"));



            inputstream.close();
            connection.disconnect();


        } catch (IOException e) {
            e.printStackTrace();
        }


        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/job")
    public ResponseEntity<?> postJob(){

        URL url = null;
        {
            try {
                url = new URL("https://import.8vance.com/data_import/structured_data_import_for_job/");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        //ROOT
        Job job = new Job("1234567891232342341",
        "Active",
                false,
                "https://www.linkedin.com/jobs/view/1605828894/",
                "72d36bee67019db6c8d14b552cd7932d6db5a803469bb3cbd4513188bc833df1",
                "FONTYS",
                "2017-12-12",
                "2022-05-17",
                "en",
                new Position(
                        new Function(
                                "Stagebegeleider",
                                "Senior",
                                new ArrayList<Classification>(
                                        List.of(new Classification(
                                                18723027,
                                                1568316,
                                                "1920NJ",
                                                1567284,
                                                "S5B-STAGE",
                                                true,
                                                6)

                                    )
                                )
                        ),
                        new Location( new com.fontys_automotive.api.tus.models.project.Address("Achtseweg-zuid 159",
                        "Netherlands",
                        "Noord-Brabant",
                        "Eindhoven",
                        "5651 GW")
                        ),
                        "VT Stagebegeleiding (incl. intervisie) 4 studenten Indien 2 studenten gewenst, kies factor 0,5. Eindhoven 7, Tilburg 3 "
                )
        );

        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(job);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        HttpURLConnection connection;
        String result = "";
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", token);
            connection.setRequestMethod("POST");


            OutputStream stream = connection.getOutputStream();
            stream.write(json.getBytes("UTF-8"));
            stream.close();

            InputStream inputstream = new BufferedInputStream(connection.getInputStream());
            //String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
            result = new BufferedReader(new InputStreamReader(inputstream))
                    .lines().collect(Collectors.joining("\n"));



            inputstream.close();
            connection.disconnect();


        } catch (IOException e) {
            e.printStackTrace();
        }


        return new ResponseEntity<>(result, HttpStatus.OK);
    }



}
