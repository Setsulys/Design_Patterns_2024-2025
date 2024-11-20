package fr.uge.visitor.exo1.stpfixed;

public interface CommandProcessor {
    public void visit(HelloCmd cmd);
    public void visit(ElapsedTimeCmd cmd);
    public void visit(StartTimerCmd cmd);
    public void visit(StopTimerCmd cmd);

    default public void visit(STPCommand cmd){
        switch(cmd){
            case HelloCmd Hcmd-> visit(Hcmd);
            case ElapsedTimeCmd Ecmd -> visit(Ecmd);
            case StartTimerCmd stcmd -> visit(stcmd);
            case StopTimerCmd scmd -> visit(scmd);
        }
    }
}
