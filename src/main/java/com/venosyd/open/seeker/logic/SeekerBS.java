package com.venosyd.open.seeker.logic;

import java.util.List;
import java.util.Map;

/**
 * @author sergio lisan <sels@venosyd.com>
 */
public interface SeekerBS {

    /**
     * instancia do seeker
     */
    SeekerBS INSTANCE = new SeekerBSImpl();

    /**
     * registra um servico no seeker
     * 
     * { service: 'map' publicURLs: '[maps.whatever.com]' privateURL:
     * 'http://localhost:4949/maps' }
     */
    Map<String, String> registerService(String service, String privateURL, List<String> publicURLs);

    /**
     * ask for a host in seeker
     * 
     * { host: 'login.whatever.com' }
     * 
     * return 'http://localhost:7030/login'
     */
    Map<String, String> askHost(String host);

    /**
     * ask for a service in seeker
     * 
     * { askFor: 'login' }
     * 
     * return 'http://localhost:7030/login'
     */
    Map<String, String> askService(String askFor);
}
