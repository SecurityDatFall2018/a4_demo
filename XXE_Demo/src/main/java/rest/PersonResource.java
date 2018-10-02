package rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/person")
public class PersonResource {

  static final Map<Integer, Person> persons = new ConcurrentHashMap<Integer, Person>();
  static volatile int nextId = 0;

  static {
    System.out.println("-----------------------------");
    Person p = new Person("Kurt", "Wonnegut", 45);
    p.setId(nextId);
    persons.put(nextId++, p);
    p = new Person("Jane", "Wonnegut", 43);
    p.setId(nextId);
    persons.put(nextId++, p);
  }

  @GET
  @Produces(MediaType.APPLICATION_XML)
  public List<Person> allPersons() {
    List<Person> result = new ArrayList<>();
    for (Map.Entry<Integer, Person> p : persons.entrySet()) {
      result.add(p.getValue());
    }
    return result;
  }

  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_XML)
  public Person getPerson(@PathParam("id") int id) {
    return persons.get(id);
  }

  @POST
  @Consumes(MediaType.APPLICATION_XML)
  public Response storePerson(Person p) {
    p.setId(++nextId);
    persons.put(nextId, p);
    String output = p.toString();
    return Response.status(200).entity(output).build();
  }

}
