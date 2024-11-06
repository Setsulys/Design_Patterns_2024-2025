package fr.uge.poo.uberclient.question3;

public class WeatherServices implements WeatherService{
    private  WeatherServices(){
        System.out.println("Creating a connection to WeatherServiceNTS");
    }
    private static final WeatherService INSTANCE = new WeatherService() {
        private final Object lock = new Object();
        private final WeatherServiceNTS service =new WeatherServiceNTS();

        @Override
        public int query(String city) {
            synchronized (lock) {
                return service.query(city);
            }
        }
    };

    private static WeatherService getInstance(){
        return INSTANCE;
    }

    @Override
    public int query(String city) {
        return 0;
    }
}
