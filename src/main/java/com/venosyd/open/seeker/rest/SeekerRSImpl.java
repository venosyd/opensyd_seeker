package com.venosyd.open.seeker.rest;

import java.util.Calendar;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.venosyd.open.commons.util.JSONUtil;
import com.venosyd.open.commons.util.RESTService;
import com.venosyd.open.seeker.Seeker;

/**
 * @author sergio lisan <sels@venosyd.com>
 */
@Path("/")
public class SeekerRSImpl implements SeekerRS, RESTService {

    @Context
    private HttpHeaders headers;

    public SeekerRSImpl() {

    }

    @Override
    public Response echo() {
        String message = "SERVICE SEEKER ECHO GRANTED" + Calendar.getInstance().get(Calendar.YEAR);

        var echoMessage = new HashMap<String, String>();
        echoMessage.put("status", "ok");
        echoMessage.put("message", message);

        return makeResponse(echoMessage);
    }

    @Override
    public Response askService(String body) {
        return process(body, (request) -> {
            var askFor = request.get("askFor");
            return makeResponse(Seeker.askService(askFor), false);
        }, "askService");
    }

    @Override
    public Response askHost(String body) {
        return process(body, (request) -> {
            var host = request.get("host");
            return makeResponse(Seeker.askHost(host), false);
        }, "askHost");
    }

    @Override
    public Response registerService(String body) {
        return process(body, (request) -> {
            var service = request.get("service");
            var privateURL = request.get("privateURL");
            var publicURLs = JSONUtil.<String>fromJSONToList(request.get("publicURLs"));

            return makeResponse(Seeker.registerService(service, privateURL, publicURLs), false);
        }, "registerService");
    }

}
