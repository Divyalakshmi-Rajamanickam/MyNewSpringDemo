package com.demo.controller;

import com.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.demo.service.PersonService;

@Controller
public class PersonController {
    private PersonService service;

    @Autowired
    public PersonController(PersonService service){
        this.service = service;
    }

    @RequestMapping(value = "/person/", method = RequestMethod.GET)
   // @GetMapping("/findAll")  ==> alternative way
    public ResponseEntity<?> findAll(){
        Iterable<Person> allPeople = service.findAll();
        ResponseEntity<?> response = new ResponseEntity<>(allPeople, HttpStatus.OK);
        return  response;
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    // @GetMapping("/findAll")  ==> alternative way
    public ResponseEntity<?> findById(@PathVariable Long id){
        Person person = service.findById(id);
        ResponseEntity<?> response = new ResponseEntity<>(person, HttpStatus.OK);
        return  response;
    }


    @RequestMapping(value = "/person/", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody Person person){
        person = service.create(person);
        ResponseEntity<?> response = new ResponseEntity<>(person,HttpStatus.CREATED);
        return response;
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id){
        Person person = service.delete(id);
        ResponseEntity<?> response = new ResponseEntity<>(person,HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.PUT)
    // @GetMapping("/findAll")  ==> alternative way
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Person person){
        person = service.update(id,person);
        ResponseEntity<?> response = new ResponseEntity<>(person, HttpStatus.OK);
        return  response;
    }



}
