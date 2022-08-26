package be.raft.legions.objects;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class LegionsObject {
    int save_version = 1;
    String edit_warning = "PLEASE READ: This file stores all data of the legions! If you do not know what you are doing please leave this file!";
    String edit_tutorial = "WARNING: Before editing this file stop the server! Tutorial: For Soon";
    ArrayList<LegionObject> legions;
    @SerializedName("blocked_name")
    ArrayList<String> blockedName;

    public LegionsObject(ArrayList<LegionObject> legions, ArrayList<String> blockedName) {
        assert !legions.isEmpty();
        this.legions = legions;
        this.blockedName = blockedName;
    }

    public ArrayList<LegionObject> getLegions() {
        return legions;
    }

    public void setLegions(ArrayList<LegionObject> legions) {
        assert !legions.isEmpty();
        this.legions = legions;
    }

    public ArrayList<String> getBlockedName() {
        return blockedName;
    }

    public void setBlockedName(ArrayList<String> blockedName) {
        this.blockedName = blockedName;
    }
}
