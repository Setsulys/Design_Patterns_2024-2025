package fr.uge.poo.uberclient.question3;

public class WeatherServiceNTS implements WeatherService{
    private final Object lock = new Object();
    public WeatherServiceNTS(){
        System.out.println("Creating a connection to WeatherServiceNTS");
    }

    private static final WeatherServiceNTS INSTANCE = new WeatherServiceNTS();

    private static WeatherServiceNTS getInstance(){return INSTANCE;}

    @Override
    public int query(String city) {
        synchronized (lock){
            return city.hashCode()%30;
        }
    }
}
