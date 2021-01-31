package week13.d02.midlevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirportManager {

    List<Flight> flights = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void readFromFile(InputStream in) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("cannot read file", ioe);
        }
    }

    public Status getMaxStatus() {
        int arrivalCount = 0;
        int departureCount = 0;

        for (Flight flight : flights) {
            if (flight.getStatus() == Status.ARRIVAL) {
                arrivalCount++;
            } else {
                departureCount++;
            }
        }

        return arrivalCount > departureCount ? Status.ARRIVAL : Status.DEPARTURE;
    }

    public Flight getFlightByFlightNumber(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    public String requestCityFromUser() {
        System.out.print("Kérem a várost: ");
        return scanner.nextLine();
    }

    public String requestStatusFromUser() {
        String status;
        do {
            System.out.println("Kérem a státuszt...");
            System.out.print("(Arrival (A), Departure (D): ");
            status = scanner.nextLine();
        } while (!status.equals("A") && !status.equals("D"));
        return status;
    }

    public List<Flight> getFlightsByCityAndStatus(String city, Status status) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getCity().equals(city) && flight.getStatus() == status) {
                result.add(flight);
            }
        }
        return result;
    }

    public Flight getEarlierDepartureFlight() {
        LocalDateTime earliestTime = flights.get(0).getTime();
        Flight earlierFlight = flights.get(0);
        for (Flight flight : flights) {
            if (flight.getTime().isBefore(earliestTime)) {
                earliestTime = flight.getTime();
                earlierFlight = flight;
            }
        }
        return earlierFlight;
    }

    private void processLine(String line) {
        String[] temp = line.split(" ");
        checkData(temp);
        String[] timeTemp = temp[3].split(":");
        try {
            Status status = temp[1].equals("Arrival") ? Status.ARRIVAL : Status.DEPARTURE;
            int year = LocalDateTime.now().getYear();
            int month = LocalDateTime.now().getMonthValue();
            int day = LocalDateTime.now().getDayOfMonth();
            int hour = Integer.parseInt(timeTemp[0]);
            int minute = Integer.parseInt(timeTemp[1]);
            flights.add(new Flight(temp[0], status, temp[2], LocalDateTime.of(year, month, day, hour, minute)));
        } catch (NumberFormatException nfe) {
            throw new IllegalStateException("invalid time-format in file");
        }
    }

    private void checkData(String[] temp) {
        if (temp.length != 4) {
            throw new IllegalStateException("invalid data in file");
        }
        if (!temp[3].contains(":")) {
            throw new IllegalStateException("invalid time-format in file");
        }
    }

    public List<Flight> getFlights() {
        return new ArrayList<>(flights);
    }
}
