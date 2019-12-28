package com.ugurcangursen.ticketingapp.util;

public class RestPaths {

    private static final String BASE_PATH = "/rest";

    public static final class AirlineCompanyRest {
        public static final String REST = BASE_PATH + "/airlines";
    }

    public static final class AirportRest {
        public static final String REST = BASE_PATH + "/airports";
    }

    public static final class FlightRest {
        public static final String REST = BASE_PATH + "/flights";
    }

    public static final class PlaneRest {
        public static final String REST = BASE_PATH + "/planes";
    }

    public static final class RouteRest {
        public static final String REST = BASE_PATH + "/routes";
    }

    public static final class TicketRest {
        public static final String REST = BASE_PATH + "/tickets";
    }

}
