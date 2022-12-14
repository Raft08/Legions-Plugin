package be.raft.legions.objects;

import com.google.gson.annotations.SerializedName;

public class PlayerObject {
    @SerializedName("player")
    IdentifierObject playerID;
    PlayerDataObject data;

    public PlayerObject(IdentifierObject playerID, PlayerDataObject data) {
        assert (playerID != null || data != null);
        this.playerID = playerID;
        this.data = data;
    }

    public IdentifierObject getPlayerID() {
        return playerID;
    }

    public void setPlayerID(IdentifierObject playerID) {
        assert playerID != null;
        this.playerID = playerID;
    }

    public PlayerDataObject getData() {
        return data;
    }

    public void setData(PlayerDataObject data) {
        assert data != null;
        this.data = data;
    }

    public static class PlayerDataObject {
        @SerializedName("rank")
        IdentifierObject playerRankID;

        public PlayerDataObject(IdentifierObject playerRankID) {
            assert playerRankID != null;
            this.playerRankID = playerRankID;
        }

        public IdentifierObject getPlayerRankID() {
            return playerRankID;
        }

        public void setPlayerRankID(IdentifierObject playerRankID) {
            assert  playerRankID != null;
            this.playerRankID = playerRankID;
        }
    }
}
