package com.venosyd.open.seeker.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author sergio lisan <sels@venosyd.com>
 */
@ApplicationPath(SeekerRS.SEEKER_BASE_URL)
public class SeekerRESTfulAPI extends Application {

    public Set<Class<?>> getClasses() {
        var classes = new HashSet<Class<?>>();
        classes.add(SeekerRSImpl.class);

        return classes;
    }
}
