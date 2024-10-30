package fr.uge.poo.uberclient.question3;

public class WeatherServices {
    private static final WeatherServiceTS INSTANCE = new WeatherServiceTS();

    private static WeatherServiceTS getInstance(){
        return INSTANCE;
    }
}
