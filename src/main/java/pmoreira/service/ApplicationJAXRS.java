package pmoreira.service;

import org.glassfish.jersey.jettison.JettisonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationJAXRS extends ResourceConfig {

    private static final String PACKAGES_TO_SCAN = "pmoreira.service";

    public ApplicationJAXRS() {
        packages(PACKAGES_TO_SCAN);
        register(new JettisonFeature());
    }

}