package es.udc.ws.races.model.raceservice;

import es.udc.ws.util.configuration.ConfigurationParametersManager;

public class RaceServiceFactory {
    private final static String CLASS_NAME_PARAMETER = "RaceFactory.className";
    private static RaceService service = null;

    private RaceServiceFactory() {
    }

    @SuppressWarnings("rawtypes")
    private static RaceService getInstance() {
        try {
            String serviceClassName = ConfigurationParametersManager
                    .getParameter(CLASS_NAME_PARAMETER);
            Class serviceClass = Class.forName(serviceClassName);
            return (RaceService) serviceClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public synchronized static RaceService getService() {

        if (service == null) {
            service = getInstance();
        }
        return service;

    }
}
