package com.example.helloworld.resources;

import com.example.helloworld.core.Saying;
import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world/{myID}")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final String template;
    private final String firstNameTemplate;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloWorldResource(String template, String firstNameTemplate, String defaultName) {
        this.template = template;
        this.firstNameTemplate = firstNameTemplate;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name
                          ,@QueryParam("firstName") Optional<String> firstName
                          ,@PathParam("myID") LongParam myId
                          ) {
        final String value;
        if (firstName.isPresent()) {
            value = String.format(firstNameTemplate, name.or(defaultName), firstName.orNull());
        } else {
            value = String.format(template, name.or(defaultName), "");
        }
        System.out.println("myID was " + myId);
        return new Saying(counter.incrementAndGet(), value);
    }
}
