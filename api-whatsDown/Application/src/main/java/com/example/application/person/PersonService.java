package com.example.application.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service // same as @Component functionally but this adds readability
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPeople() {
        return personRepository.findAll();
    }

    public void addNewPerson(Person person) {
        Optional<Person> personOptional = personRepository.findPersonByEmail(person.getEmail());

        if (personOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }

        personRepository.save(person);
    }

    public void deletePerson(Long personId) {
        boolean exists = personRepository.existsById(personId);

        if (!exists) {
            throw new IllegalStateException("person with id " + personId + " does not exist");
        }
        personRepository.deleteById(personId);
    }

    @Transactional
    public void updatePerson(Long personId, String name, String email) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new IllegalStateException(
                        "person with id " + personId + " does not exist"
                ));

        if (name != null && name.length() > 0 && !Objects.equals(person.getName(), name)) {
            person.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(person.getEmail(), email)) {
            Optional<Person> personOptional = personRepository.findPersonByEmail(email);

            if (personOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            person.setEmail(email);
        }
    }
}
