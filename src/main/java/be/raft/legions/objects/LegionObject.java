package be.raft.legions.objects;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class LegionObject {
    @SerializedName("legion")
    IdentifierObject legionID;
    @SerializedName("settings")
    SettingsObject legionSettings;
    DataObject data;
    ArrayList<RankObject> ranks;
    ArrayList<CampObject> camps;
    ArrayList<PlayerObject> players;
    DiplomacyObject diplomacy;

    public LegionObject(IdentifierObject legionID, SettingsObject legionSettings, DataObject data, ArrayList<RankObject> ranks, ArrayList<CampObject> camps, ArrayList<PlayerObject> players, DiplomacyObject diplomacy) {
        assert (legionID != null || legionSettings != null || data != null || !ranks.isEmpty() || !players.isEmpty() || diplomacy != null);
        this.legionID = legionID;
        this.legionSettings = legionSettings;
        this.data = data;
        this.ranks = ranks;
        this.camps = camps;
        this.players = players;
        this.diplomacy = diplomacy;
    }

    public IdentifierObject getLegionID() {
        return legionID;
    }

    public void setLegionID(IdentifierObject legionID) {
        assert legionID != null;
        this.legionID = legionID;
    }

    public SettingsObject getLegionSettings() {
        return legionSettings;
    }

    public void setLegionSettings(SettingsObject legionSettings) {
        assert legionSettings != null;
        this.legionSettings = legionSettings;
    }

    public DataObject getData() {
        return data;
    }

    public void setData(DataObject data) {
        assert data != null;
        this.data = data;
    }

    public ArrayList<RankObject> getRanks() {
        return ranks;
    }

    public void setRanks(ArrayList<RankObject> ranks) {
        assert !ranks.isEmpty();
        this.ranks = ranks;
    }

    public ArrayList<CampObject> getCamps() {
        return camps;
    }

    public void setCamps(ArrayList<CampObject> camps) {
        this.camps = camps;
    }

    public ArrayList<PlayerObject> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<PlayerObject> players) {
        assert !players.isEmpty();
        this.players = players;
    }

    public DiplomacyObject getDiplomacy() {
        return diplomacy;
    }

    public void setDiplomacy(DiplomacyObject diplomacy) {
        assert diplomacy != null;
        this.diplomacy = diplomacy;
    }

    //Classes
    public static class SettingsObject {
        Boolean openForAll;

        @SerializedName("legion_file")
        String legionFlag;
        @SerializedName("description")
        String legionDescription;
        @SerializedName("default_rank")
        IdentifierObject defaultRank;

        public SettingsObject(Boolean openForAll, String legionDescription, IdentifierObject defaultRank, String legionFlag) {
            assert (openForAll != null || legionDescription != null || defaultRank != null || legionFlag != null);
            this.openForAll = openForAll;
            this.legionDescription = legionDescription;
            this.defaultRank = defaultRank;
            this.legionFlag = legionFlag;
        }

        public Boolean getOpenForAll() {
            return openForAll;
        }

        public void setOpenForAll(Boolean openForAll) {
            assert openForAll != null;
            this.openForAll = openForAll;
        }

        public String getLegionDescription() {
            return legionDescription;
        }

        public void setLegionDescription(String legionDescription) {
            assert legionDescription != null;
            this.legionDescription = legionDescription;
        }

        public IdentifierObject getDefaultRank() {
            return defaultRank;
        }

        public void setDefaultRank(IdentifierObject defaultRank) {
            assert defaultRank != null;
            this.defaultRank = defaultRank;
        }

        public String getLegionFlag() {
            return legionFlag;
        }

        public void setLegionFlag(String legionFlag) {
            assert legionFlag != null;
            this.legionFlag = legionFlag;
        }
    }
    public static class DataObject {
        @SerializedName("tier")
        int Tier;
        @SerializedName("amount_players")
        int amountPlayers;
        @SerializedName("amount_ranks")
        int amountRanks;


    }
    public static class DiplomacyObject {
        ArrayList<IdentifierObject> allies;
        ArrayList<IdentifierObject> enemies;

        public DiplomacyObject(ArrayList<IdentifierObject> allies, ArrayList<IdentifierObject> enemies) {
            this.allies = allies;
            this.enemies = enemies;
        }

        public ArrayList<IdentifierObject> getAllies() {
            return allies;
        }

        public void setAllies(ArrayList<IdentifierObject> allies) {
            this.allies = allies;
        }

        public ArrayList<IdentifierObject> getEnemies() {
            return enemies;
        }

        public void setEnemies(ArrayList<IdentifierObject> enemies) {
            this.enemies = enemies;
        }
    }
}
