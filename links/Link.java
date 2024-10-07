

public class Link implements ILink {
    /// <summary>
    /// The next state to transition to.
    /// </summary>
    final IState nextState;

    /// <summary>
    /// Constructor.
    /// </summary>
    /// <param name="nextState"></param>
    public Link(IState nextState) {
        this.nextState = nextState;
    }

    /// <summary>
    /// Always true, so moves directly to the next state.
    /// </summary>
    /// <param name="nextState"></param>
    /// <returns></returns>
    @Override
    public boolean Validate(Out<IState> nextState) {
        nextState.set(this.nextState);
        return true;
    }

    @Override
    public void Enable() {

    }

    @Override
    public void Disable() {

    }
}
