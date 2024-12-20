package fr.uge.ex2;

import java.util.Map;
import com.evilcorp.imagine.Image;

public class Main {
    public static void main(String[] args) {
        var map = Map.of("cat","http://www.example.com/cat.png",
                "dog","http://www.example.com/dog.png",
                "mice","http://www.example.com/mice.png");
        var images =map.values().stream().map(ImageGenerator::lazyDownload).toList();
        System.out.println(images.get(0).hue());
    }
}
