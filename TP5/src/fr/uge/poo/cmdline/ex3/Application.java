package fr.uge.poo.cmdline.ex3;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    // The record ApplicationSettings is used to store the settings of the application,
    // does the application start with a border, does it uses the legacy drawing engine.
    public record ApplicationSettings(boolean legacy, boolean bordered,int value,String name){

        public static Builder builder() {
            return new Builder();
        }

        static public class Builder {

            private boolean legacy = false;
            private boolean bordered = true;
            private int width;
            private String name;

            public Builder legacy(boolean legacy){
                this.legacy = legacy;
                return this;
            }

            public Builder bordered(boolean bordered){
                this.bordered = bordered;
                return this;
            }

            public Builder border(int width){
                this.width = width;
                return this;
            }
            public Builder name(String name){
                this.name = name;
                return this;
            }

            public ApplicationSettings build(){
                return new ApplicationSettings(legacy,bordered,width,name);
            }
        }

    };



    public static void main(String[] args) {
        var settingsBuilder = ApplicationSettings.builder();
        String[] arguments={"-legacy","-no-borders","filename1","filename2","-border-with","-window-name"};
        var cmdParser = new CmdLineParser();
        cmdParser.addFlag("-legacy",()->settingsBuilder.legacy(true));
        cmdParser.addFlag("-with-borders",()->settingsBuilder.bordered(true));
        cmdParser.addFlag("-no-borders",()->settingsBuilder.legacy(false));
        cmdParser.addOptionWithOneParameter("-border-with",t->settingsBuilder.border(6));
        cmdParser.addOptionWithOneParameter("-window-name",t->settingsBuilder.name("appole"));
        List<String> result = cmdParser.process(arguments);
        List<Path> files = result.stream().map(Path::of).collect(Collectors.toList());
        // this code replaces the rest of the application
        files.forEach(p -> System.out.println(p));
        var settings = settingsBuilder.build();
        System.out.println(settings);

    }
}
/**
 * Enrichir votre classe CmdLineParser avec une méthode addOptionWithOneParameter.
 * Quel doit être le type de cette méthode ? Que doit-on faire quand le paramètre d'une option n'est pas présent lors de l'appel à process ?
 *
 *
 */