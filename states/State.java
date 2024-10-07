
import java.util.Objects;

public class State extends AbstractState {

    final Runnable execute;

    public State(Runnable excute, String stateName, boolean enableDebug) {
        this.execute = excute;
        this.Name = stateName;
        this.debug = enableDebug;

    }

    @Override
    public void Execute() {
        if (Objects.nonNull(execute)) {
            execute.run();
        }
    }
}
