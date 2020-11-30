import Tiles.Tile;

import java.util.ArrayList;
import java.util.List;

public class SaveState {

    private List<List<Tile>> state = new ArrayList<List<Tile>>();

    public SaveState(List<List<Tile>> inputState){
        this.state  = inputState;
    }

    public List<List<Tile>> getState(){
        return (this.state);
    }

}
