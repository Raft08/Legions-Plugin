package be.raft.legions.objects;

import java.util.ArrayList;

public class LegionsObject {
    ArrayList<LegionObject> legions;

    public LegionsObject(ArrayList<LegionObject> legions) {
        assert !legions.isEmpty();
        this.legions = legions;
    }

    public ArrayList<LegionObject> getLegions() {
        return legions;
    }

    public void setLegions(ArrayList<LegionObject> legions) {
        assert !legions.isEmpty();
        this.legions = legions;
    }
}
