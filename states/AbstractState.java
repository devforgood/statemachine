

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractState implements IState {

    public String Name;

    // Enable debug messages
    protected boolean debug = false;
    final List<ILink> links = new ArrayList<>();

    public boolean DebugEnabled;

    @Override
    public void Enter() {
        EnableLinks();
    }

    public abstract void Execute();

    @Override
    public void Exit() {

    }

    @Override
    public void AddLink(ILink link) {
        if (!links.contains(link)) {
            links.add(link);
        }
    }

    @Override
    public void RemoveLink(ILink link) {
        if (!links.contains(link)) {
            links.remove(link);
        }
    }

    @Override
    public void RemoveAllLinks() {
        links.clear();
    }

    @Override
    public boolean ValidateLinks(Out<IState> nextState) {
        if (!links.isEmpty()) {
            for (var link : links) {
                var result = link.Validate(nextState);
                if (result) {
                    return true;
                }
            }
        }

        // By default, return false without a valid IState
        nextState.set(null);
        return false;
    }

    @Override
    public void EnableLinks() {
        for (var link : links) {
            link.Enable();
        }
    }

    @Override
    public void DisableLinks() {
        for (var link : links) {
            link.Disable();
        }
    }
}
