package com.demo.service;

import com.demo.model.Person;
import com.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public  PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }


    public Iterable<Person> findAll(){

        return personRepository.findAll();
    }

    public Person create(Person person){
        return personRepository.save(person);
    }

    public Person findById(Long id) {
        return personRepository.findById(id).get();
    }


    public Person delete(Long id) {
        Person personToBeDeleted = this.findById(id);
        personRepository.delete(personToBeDeleted);
        return personToBeDeleted;
    }


    public Person update(Long id, Person person) {
        if(personRepository.findById(id) == null){
            return null;
        }
        return personRepository.save(person);
    }
        /*Person person1 = findById(id);
        String newFirstName = person1.setFirstName();
        String newLastName = person1.setLastName();

        String firstName = person1.getFirstName();
        String lastName = person1.getLastName();
        */


}
