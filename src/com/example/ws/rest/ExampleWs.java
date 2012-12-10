package com.example.ws.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.example.domain.Person;

@Path("/example")
public class ExampleWs {

	@GET
	@Path("/getPerson")
	@Produces({"application/xml", "application/json"})
	public Person getPerson(){
		Person p = new Person();
		p.setEmail("john@email.com");
		p.setAge(30);
		p.setName("Jhon");

		return p;
	}
	
	@GET
	@Path("/getPerson/{name}")
	@Produces("text/plain")
	public String getPerson(@PathParam("name")String name){
		return "Hello "+name;
	}
	
	@POST
	@Path("/insertPerson")
	@Produces({"application/json"})
	@Consumes({"application/xml", "application/json"})
	public Person insertPerson(Person person){
		return person;
	}
}
