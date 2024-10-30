package fr.uge.poo.uberclient.question3;

public class WeatherServiceTS implements WeatherService {

    public WeatherServiceTS() {
        System.out.println("Creating a connection to WeatherServiceTS");
    }

    public int query(String city) {
        return city.hashCode() % 30;
    }
}
