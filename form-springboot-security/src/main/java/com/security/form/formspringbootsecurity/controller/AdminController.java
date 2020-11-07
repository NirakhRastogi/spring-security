package com.security.form.formspringbootsecurity.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

@RestController
public class AdminController {

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String admin() {
        return "You are an admin";
    }

    @GetMapping("/admin/list/{count}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ArrayNode getAdminList(@PathVariable("count") int count) {
        ArrayNode arrayNode = new ObjectMapper().createArrayNode();
        IntStream.range(0, count).forEach(i -> arrayNode.add("Admin-" + i));
        return arrayNode;
    }

}
