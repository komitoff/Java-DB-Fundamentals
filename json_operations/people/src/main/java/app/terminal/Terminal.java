package app.terminal;

import app.domain.dto.DTOConvertUtil;
import app.domain.dto.json.AddressJsonDto;
import app.domain.dto.json.PersonJsonDto;
import app.domain.dto.json.PhoneJsonDto;
import app.domain.model.Address;
import app.domain.model.Person;
import app.domain.model.PhoneNumber;
import app.io.JsonParser;
import app.io.XmlParser;
import app.service.PersonService;
import app.service.PhoneService;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private PersonService personService;

    @Autowired
    private PhoneService phoneService;

    @Autowired
    private JsonParser jsonParser;

    @Autowired
    private XmlParser xmlParser;

    @Override
    public void run(String... strings) throws Exception {
        this.importJson();
        this.importJsons();
        this.exportJson();
        this.exportXML();
        this.exportJsons();


    }

    private void exportXML() throws JAXBException, IOException {
        Person person = this.personService.findById(1);
        PersonJsonDto personJsonDto = DTOConvertUtil.convert(person, PersonJsonDto.class);

        long startTime = System.currentTimeMillis();
        this.xmlParser.writeXML(personJsonDto, "src/main/resources/files/output/xml/person.xml");
        long endTime = System.currentTimeMillis();
        double time = (endTime - startTime);
        System.out.println("XML " + time);
    }

    private void exportJson() throws IOException {
        Person person = this.personService.findById(1);
        PersonJsonDto personJsonDto = DTOConvertUtil.convert(person, PersonJsonDto.class);

        long startTime = System.currentTimeMillis();
        this.jsonParser.exportJson(personJsonDto, "src/main/resources/files/output/json/person.json");
        long endTime = System.currentTimeMillis();
        double time = (endTime - startTime);
        System.out.println("JSON " + time);

    }

    private void exportJsons() {
        List<PersonJsonDto> personJsonDto = this.personService.findByCountry("Bulgaria");
        try {
            this.jsonParser.exportJson(personJsonDto, "src/main/resources/files/output/json/persons.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importJson() throws IOException {
        PersonJsonDto personJsonDto = this.jsonParser.importJson(PersonJsonDto.class, "/files/input/json/person.json");
        storeDto(personJsonDto);
    }

    private void storeDto(PersonJsonDto personJsonDto) {
        Person person = DTOConvertUtil.convert(personJsonDto, Person.class);

        for (Iterator<PhoneNumber> i = person.getPhoneNumbers().iterator(); i.hasNext();) {
            PhoneNumber phoneNumber = i.next();
            try {
                //phoneNumber.setPerson(person);
                phoneService.create(phoneNumber);
            } catch (ConstraintViolationException e) {
                i.remove();
                System.out.println("Invalid number detected. Not stored in DB : " + phoneNumber.getNumber());
            }
        }

        personService.create(person);



    }

    private void importJsons() throws IOException {
        PersonJsonDto[] personJsonDtos = this.jsonParser.importJson(PersonJsonDto[].class, "/files/input/json/persons.json");

        for (PersonJsonDto personJsonDto : personJsonDtos) {
            storeDto(personJsonDto);
        }
    }
}
