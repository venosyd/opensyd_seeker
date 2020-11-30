package com.venosyd.open.seeker.logic;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.venosyd.open.commons.log.Debuggable;
import com.venosyd.open.seeker.lib.Service;

/**
 * @author sergio lisan <sels@venosyd.com>
 */
class SeekerBSImpl implements SeekerBS, Debuggable {

    /** */
    private Map<String, String> _services;

    /** */
    private Map<String, String> _hosts;

    SeekerBSImpl() {
        _services = new ConcurrentHashMap<>();
        _hosts = new ConcurrentHashMap<>();
    }

    @Override
    public Map<String, String> registerService(String service, String privateURL, List<String> publicURLs) {

        _services.put(service, privateURL);
        publicURLs.forEach(url -> _hosts.put(url, privateURL));

        var srvce = new Service();

        srvce.setService(service);
        srvce.setPrivateURL(privateURL);
        srvce.setPublicURLs(publicURLs);

        var result = new HashMap<String, String>();
        result.put("status", "ok");

        return result;
    }

    @Override
    public Map<String, String> askHost(String host) {
        var response = new HashMap<String, String>();
        try {
            if (!host.isEmpty() && _hosts.containsKey(host)) {
                var uri = new URI(_hosts.get(host));

                var serviceAddress = uri.getScheme() + "://" + uri.getHost();
                if (uri.getPort() > 0) {
                    serviceAddress += ":" + uri.getPort();
                }

                response.put("status", "open");
                response.put("url", serviceAddress);

            } else {
                response.put("status", "thereisno");
                response.put("message", "Este servico nao existe");
            }

        } catch (Exception e) {
            err.exception("SERVICE SEEKER LOAD SERVICES ERROR", e);

            response.put("status", "error");
            response.put("message", "Este servico nao existe");
        }

        return response;
    }

    @Override
    public Map<String, String> askService(String askFor) {
        var response = new HashMap<String, String>();

        if (_services.containsKey(askFor)) {
            response.put("status", "open");
            response.put("url", _services.get(askFor));
        } else {
            response.put("status", "thereisno");
            response.put("message", "Este servico nao existe");
        }

        return response;
    }

}
