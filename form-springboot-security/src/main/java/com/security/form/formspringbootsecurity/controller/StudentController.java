package com.security.form.formspringbootsecurity.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.IntStream;

@RestController
public class StudentController {

    @GetMapping("/student")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public String student() {
        return "You are the student";
    }

    @GetMapping("/student/list")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public ArrayNode getStudentList(@RequestParam("count") Optional<Integer> count) {
        ArrayNode arrayNode = new ObjectMapper().createArrayNode();

        IntStream.range(0, count.orElse(5)).forEach(i -> arrayNode.add("Student-" + i));
        return arrayNode;

    }

    @PostMapping("/student/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public boolean addStudent(@RequestBody String name) {
        return true;
    }

}
