package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Trip;
import org.junit.jupiter.api.Test;

public class DistanceCalculatorServiceTest {

    private static final String COST_MESSAGE = "%s -> %s:\nDistance: %.2f km.\nCost: $%.2f\n\n";

    private DistanceCalculatorService distanceCalculatorService
            = new DistanceCalculatorService("/interchanges.json", new ObjectMapper());


    @Test
    public void testQEWHighway400() {
        String source = "QEW";
        String destination = "Highway 400";
        Trip trip = distanceCalculatorService.costOfTrip(source, destination);
        System.out.println(String.format(COST_MESSAGE,
                source, destination, trip.getDistance(), trip.getCost()));
    }

    @Test
    public void testSalemRoadQEW() {
        String source = "Salem Road";
        String destination = "QEW";
        Trip trip = distanceCalculatorService.costOfTrip(source, destination);
        System.out.println(String.format(COST_MESSAGE,
                source, destination, trip.getDistance(), trip.getCost()));
    }

    @Test
    public void testQEWSalemRoad() {
        String source = "QEW";
        String destination = "Salem Road";
        Trip trip = distanceCalculatorService.costOfTrip(source, destination);
        System.out.println(String.format(COST_MESSAGE,
                source, destination, trip.getDistance(), trip.getCost()));
    }
}
