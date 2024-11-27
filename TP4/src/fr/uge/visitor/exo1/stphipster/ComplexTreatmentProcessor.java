package fr.uge.visitor.exo1.stphipster;

import java.time.LocalDateTime;
import java.util.HashMap;

public class ComplexTreatmentProcessor implements  /*STPCommandVisitor*/CommandProcessor{

    HashMap<Integer,Long> timers = new HashMap<>();
    @Override
    public void visit(HelloCmd visitor) {
        System.out.println("Hello the current date is "+ LocalDateTime.now());
    }

    @Override
    public void visit(StartTimerCmd visitor) {
        var timerId = visitor.getTimerId();
        if (timers.get(timerId)!=null){
            System.out.println("Timer "+timerId+" was already started");
            return;
        }
        var currentTime =  System.currentTimeMillis();
        timers.put(timerId,currentTime);
        System.out.println("Timer "+timerId+" started");
    }

    @Override
    public void visit(StopTimerCmd visitor) {
        var timerId = visitor.getTimerId();
        var startTime = timers.get(timerId);
        if (startTime==null){
            System.out.println("Timer "+timerId+" was never started");
            return;
        }
        var currentTime =  System.currentTimeMillis();
        System.out.println("Timer "+timerId+" was stopped after running for "+(currentTime-startTime)+"ms");
        timers.put(timerId,null);
    }

    @Override
    public void visit(ElapsedTimeCmd visitor) {
        var currentTime =  System.currentTimeMillis();
        for(var timerId : visitor.getTimers()){
            var startTime = timers.get(timerId);
            if (startTime==null){
                System.out.println("Unknown timer "+timerId);
                continue;
            }
            System.out.println("Ellapsed time on timerId "+timerId+" : "+(currentTime-startTime)+"ms");
        }
    }
}
