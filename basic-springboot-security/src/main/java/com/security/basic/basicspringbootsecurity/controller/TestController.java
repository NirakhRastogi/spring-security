package com.security.basic.basicspringbootsecurity.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

@RestController
public class TestController {

    @GetMapping("/admin/{count}")
    public ArrayNode getNames(@PathVariable("count") int count) {
        ArrayNode nodes = new ObjectMapper().createArrayNode();

        IntStream.range(0, count).forEach(i -> nodes.add("Name-" + i));

        return nodes;
    }

    @GetMapping("/user/{count}")
    public ArrayNode getUserNames(@PathVariable("count") int count) {
        ArrayNode nodes = new ObjectMapper().createArrayNode();

        IntStream.range(0, count).forEach(i -> nodes.add("UserName-" + i));

        return nodes;
    }

    @GetMapping("/user/read/{count}")
    public ArrayNode getUserReadNames(@PathVariable("count") int count) {
        ArrayNode nodes = new ObjectMapper().createArrayNode();

        IntStream.range(0, count).forEach(i -> nodes.add("UserReadName-" + i));

        return nodes;
    }

    @PutMapping("/user/write/{count}")
    public ArrayNode getUserWriteNames(@PathVariable("count") int count) {
        ArrayNode nodes = new ObjectMapper().createArrayNode();

        IntStream.range(0, count).forEach(i -> nodes.add("UserWriteName-" + i));

        return nodes;
    }

}
