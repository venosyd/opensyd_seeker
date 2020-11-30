package com.venosyd.open.seeker;

import java.util.List;
import java.util.Map;

import com.venosyd.open.seeker.logic.SeekerBS;

/**
 * @author sergio lisan <sels@venosyd.com>
 */
public abstract class Seeker {

    /**
     * registra um servico no seeker
     * 
     * { service: 'map' publicURLs: '[maps.whatever.com]' privateURL:
     * 'http://localhost:4949/maps' }
     */
    public static Map<String, String> registerService(String service, String privateURL, List<String> publicURLs) {
        return SeekerBS.INSTANCE.registerService(service, privateURL, publicURLs);
    }

    /**
     * ask for a host in seeker
     * 
     * { host: 'login.whatever.com' }
     * 
     * return 'http://localhost:7030/login'
     */
    public static Map<String, String> askHost(String host) {
        return SeekerBS.INSTANCE.askHost(host);
    }

    /**
     * ask for a service in seeker
     * 
     * { askFor: 'login' }
     * 
     * return 'http://localhost:7030/login'
     */
    public static Map<String, String> askService(String askFor) {
        return SeekerBS.INSTANCE.askService(askFor);
    }
}
