

public class StateMachine {
    private IState currentState;

    public StateMachine(IState initialState) {
        this.currentState = initialState;
    }

    public void setState(IState state) {
        this.currentState = state;
    }

    void update() {
        Out<IState> nextState = Out.of();
        if (currentState.ValidateLinks(nextState)) {
            currentState.DisableLinks();
            setState(nextState.get());
            currentState.EnableLinks();
        }
    }

}

