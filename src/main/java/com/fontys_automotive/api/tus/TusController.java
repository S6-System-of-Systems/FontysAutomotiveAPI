package com.fontys_automotive.api.tus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fontys_automotive.api.teacher.Teacher;
import com.fontys_automotive.api.teacher.TeacherRepository;
import com.fontys_automotive.api.teacher.TeacherService;
import com.fontys_automotive.api.tus.Cv;
import com.fontys_automotive.api.tus.models.*;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/tus")

public class TusController {


    private URL url;
    {
        try {
            url = new URL("https://import.8vance.com/data_import/structured_data_import/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private final String token = "Token bede488d6d102a1df433467d632198d11818796a";
    private final TeacherService teacherService;

    @Autowired
    public TusController(TeacherService _teacherService){this.teacherService = _teacherService;}

//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder rtb)
//    {
//        return rtb.build();
//    }



    @GetMapping("/CV")
    public ResponseEntity<?> postTeachers(Teacher teacher){
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


//    @GetMapping("/countries")
//    public ResponseEntity<?> getCountryResponse(RestTemplate restTemplate)
//    {
//        try
//        {
//            return restTemplate.getForEntity(uri + "/countries" , String.class);
//        }
//        catch (Exception e)
//        {
//            return new ResponseEntity<>("kanker", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
