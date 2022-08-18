package be.raft.legions.utils;


import be.raft.legions.Legions;
import be.raft.legions.objects.*;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.UUID;

public class LegionUtils {
    public static Boolean validLegion() {
        return true;
    }

    public static Boolean hasLegion(Player player) {
        if (!player.getPersistentDataContainer().has(PersistentDataKeys.legionIDKey, PersistentDataType.STRING)) {
            return false;
        }

        if (player.getPersistentDataContainer().get(PersistentDataKeys.legionIDKey, PersistentDataType.STRING).equals("")) {
            return false;
        }
        return true;
    }

    //Ranks managing

    public static RankObject createRanks (IdentifierObject identifier, RankObject.PermissionsObject perms) {
        return new RankObject(identifier, perms);
    }


    //Create legion
    public static UUID createLegion(String name, String ownerName) {
        LegionObject legion = LegionCreationUtils.createEmptyLegion();
        return null;
    }


}
