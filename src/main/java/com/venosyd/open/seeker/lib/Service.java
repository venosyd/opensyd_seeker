package com.venosyd.open.seeker.lib;

import java.util.List;

import com.venosyd.open.entities.infra.SerializableEntity;

/**
 * @author sergio lisan <sels@venosyd.com>
 */
public class Service extends SerializableEntity {

    /** */
    private String service;

    /** */
    private String privateURL;

    /** */
    private List<String> publicURLs;

    /** */
    public Service() {
        setCollection_key("Service");
    }

    /** */
    public String getService() {
        return service;
    }

    /** */
    public void setService(String service) {
        this.service = service;
    }

    /** */
    public List<String> getPublicURLs() {
        return publicURLs;
    }

    /** */
    public void setPublicURLs(List<String> publicURLs) {
        this.publicURLs = publicURLs;
    }

    /** */
    public String getPrivateURL() {
        return privateURL;
    }

    /** */
    public void setPrivateURL(String privateURL) {
        this.privateURL = privateURL;
    }

}
