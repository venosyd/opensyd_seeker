package com.venosyd.open.seeker.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author sergio lisan <sels@venosyd.com>
 */
public interface SeekerRS {

    String SEEKER_BASE_URL = "/seeker";

    String SEEKER_ASK = "/ask";

    String SEEKER_HOST = "/host";

    String SEEKER_REGISTER = "/register";

    /**
     * Hello from the server siiiiiiide!
     */
    @GET
    @Path("/echo")
    @Produces({ MediaType.APPLICATION_JSON })
    Response echo();

    /**
     * ask for a service in seeker { "askFor": "" }
     */
    @POST
    @Path(SEEKER_ASK)
    @Produces({ MediaType.APPLICATION_JSON })
    Response askService(String body);

    /**
     * ask for a host in seeker { "host": "" }
     */
    @POST
    @Path(SEEKER_HOST)
    @Produces({ MediaType.APPLICATION_JSON })
    Response askHost(String body);

    /**
     * registra um servico no seeker { "service": "", "privateURL": "",
     * "publicURLs": "", }
     */
    @POST
    @Path(SEEKER_REGISTER)
    @Produces({ MediaType.APPLICATION_JSON })
    Response registerService(String body);

}
