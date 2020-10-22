import java.util.ArrayList;

/**
 * @author James Morand & Chris Manriquez
 */


public class State
{
    private int stateID;
    private ArrayList<Integer> transitions = new ArrayList<>();

    public State()
    {

    }

    public State(int stateID)
    {
        setStateID(stateID);
    }

    public void setStateID(int stateID)
    {
        this.stateID = stateID;
    }

    public void setTransitions(ArrayList<Integer> tnst)
    {

        transitions.addAll(tnst);
        transitions.remove(0);
    }

    public int getStateID()
    {
        return stateID;
    }

    public ArrayList<Integer> getTransitions()
    {
        return transitions;
    }
}
