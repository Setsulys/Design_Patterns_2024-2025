package fr.uge.poo.cmdline.ex2;

import java.util.*;
import java.util.function.Consumer;

public class CmdLineParser {

    private final HashMap<String, Consumer<Iterator<String>>> registeredOptions = new HashMap<>();

    public void addFlag(String option,Runnable runnable){
        Objects.requireNonNull(option);
        Objects.requireNonNull(runnable);
        if(registeredOptions.containsKey(option)){
            throw new IllegalStateException("Option "+option+" already defined");
        }
        registeredOptions.put(option,it-> runnable.run());
    }

    public void addOptionWithOneParameter(String option, Consumer<String> consumer){
        Objects.requireNonNull(option);
        Objects.requireNonNull(consumer);
        if(registeredOptions.containsKey(option)){
            throw new IllegalStateException("Option "+option+" already defined");
        }
        registeredOptions.put(option,it->{
            if(!it.hasNext()){
                throw new IllegalStateException();
            }
            consumer.accept(it.next());
        });
    }

    public List<String> process(String[] arguments) {
        ArrayList<String> files = new ArrayList<>();
        var it = Arrays.stream(arguments).iterator();
        while (it.hasNext()){
            var arg= it.next();
            if(registeredOptions.containsKey(arg)){
                var action = registeredOptions.get(arg);
                if(action!=null){
                    action.accept(it);
                }

            }
            else{
                files.add(arg);
            }
        }
//        for (String argument : arguments) {
//            if (registeredOptions.containsKey(argument)) {
//                registeredOptions.get(argument);
//            } else {
//                files.add(argument);
//            }
//        }
        return files;
    }
}