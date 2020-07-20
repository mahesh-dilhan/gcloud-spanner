package com.gcloud.gcloudspanner;

import com.google.cloud.spanner.Key;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gcp.data.spanner.core.mapping.PrimaryKey;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Table;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Log4j2
@SpringBootApplication
public class GcloudSpannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GcloudSpannerApplication.class, args);
	}

}
@Log4j2
@RestController
class PersonController{

	private final PersonRepository personRepository;

	 PersonController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@GetMapping("/greet/{name}")
	public List<Person> greet(@PathVariable String name){
		Person p = new Person();
		p.setName(name);
		log.info(this.personRepository);
		this.personRepository.save(p);
		return this.personRepository.findAllByName(name);
	}
}

@RepositoryRestResource
interface PersonRepository extends PagingAndSortingRepository<Person, Key> {
 	 List<Person> findAllByName(String name);
}

@Data
@Table(name = "people")
class Person {
	@PrimaryKey
	String id = UUID.randomUUID().toString();
	String name;

}
