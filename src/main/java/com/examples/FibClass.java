package com.examples;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("fib")
public class FibClass {
    private static final int FIB_SIZE = 10;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String fibList() {
        return "[1, 2]";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{index}")
    public String fibIndex(@PathParam("index") int index) {
        return "Test" + index;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/range")
    public String fibIndex(@QueryParam("startIndex") int startIndex, @QueryParam("endIndex") int endIndex) {
        return "Test" + startIndex + " : " + endIndex;
    }
}
