package be.raft.legions.utils;

import be.raft.legions.objects.*;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

import java.util.*;
import java.util.stream.Collectors;

public class LegionUtils {

    public static Boolean hasLegion(Player player) {
        if (!player.getPersistentDataContainer().has(PersistentDataKeys.legionIDKey, PersistentDataType.STRING)) {
            return false;
        }
        return !player.getPersistentDataContainer().get(PersistentDataKeys.legionIDKey, PersistentDataType.STRING).isEmpty();
    }


    //Create legion
    public static LegionObject createLegion(String name, Player player) {
        LegionObject legion = LegionCreationUtils.createEmptyLegion();
        legion.getLegionID().setName(name);
        legion.setRanks(LegionCreationUtils.createDefaultRanks());
        legion.getLegionSettings().setDefaultRank(legion.getRanks().get(0).getRankID());
        legion.getPlayers().add(addPlayer(player, legion.getLegionID().getUuid(), legion.getRanks().get(3).getRankID()));
        return legion;
    }

    //Player Managing
    public static PlayerObject addPlayer(Player player, UUID legionUUID, IdentifierObject rank) {
        player.getPersistentDataContainer().set(PersistentDataKeys.legionIDKey, PersistentDataType.STRING, legionUUID.toString());
        return new PlayerObject(new IdentifierObject(
                player.getDisplayName(),
                player.getUniqueId()
        ), new PlayerObject.PlayerDataObject(rank));
    }

    private static <T> Set<T> findDuplicates(List<T> list) {
        Set<T> seen = new HashSet<>();
        return list.stream()
                .filter(e -> !seen.add(e))
                .collect(Collectors.toSet());
    }


    //Verify legions
    public static Boolean legionsValid(LegionsObject legions) {
        System.out.println("Verifying " + legions.getLegions().size() + " legions..");
        int amountVerified = 0;

        ArrayList<UUID> legionsIDs = new ArrayList<>();
        for (LegionObject legion : legions.getLegions()) {
            legionsIDs.add(legion.getLegionID().getUuid());

            //Check default rank
            boolean defaultRankExists = false;
            for (RankObject rank : legion.getRanks()) {
                if (rank.getRankID().equals(legion.getLegionSettings().getDefaultRank())) {
                    defaultRankExists = true;
                    break;
                }
            }
            if (!defaultRankExists) {
                System.err.println("Default rank of " + legion.getLegionID().getName() + " doesn't exists! "
                        + TextUtils.toJson(legion.getLegionSettings().getDefaultRank()));
                return false;
            }

            ArrayList<UUID> playersIDs = new ArrayList<>();

            //Check all players
            for (PlayerObject player : legion.getPlayers()) {
                playersIDs.add(player.getPlayerID().getUuid());

                boolean hasValidRank = false;
                for (RankObject rank : legion.getRanks()) {
                    if (rank.getRankID().equals(player.getData().getPlayerRankID())) {
                        hasValidRank = true;
                        break;
                    }
                }
                if (!hasValidRank) {
                    System.err.println("Rank of " + player.getPlayerID().getName() + " from "
                            + legion.getLegionID().getName() + " Doesn't exists! " +
                            TextUtils.toJson(player.getData().getPlayerRankID()));
                    return false;
                }
            }

            Set<UUID> playerDuplicates = findDuplicates(playersIDs);
            if (playerDuplicates.size() > 0) {
                System.err.println("Duplicated player!");
                for (UUID legionDuplicate : playerDuplicates) {
                    System.err.println("UUID: " + legionDuplicate);
                }
                return false;
            }

            //Ranks
            ArrayList<UUID> rankIDs = new ArrayList<>();
            for (RankObject rank : legion.getRanks()) {
                rankIDs.add(rank.getRankID().getUuid());
            }

            Set<UUID> ranksDuplicates = findDuplicates(rankIDs);
            if (ranksDuplicates.size() > 0) {
                System.err.println("Duplicated rank!");
                for (UUID rankDuplicate : ranksDuplicates) {
                    System.err.println("UUID: " + rankDuplicate);
                }
                return false;
            }

            //Camps
            ArrayList<UUID> campsID = new ArrayList<>();
            for (CampObject camp : legion.getCamps()) {
                campsID.add(camp.getCampID().getUuid());
            }

            Set<UUID> campsDuplicates = findDuplicates(campsID);
            if (campsDuplicates.size() > 0) {
                System.err.println("Duplicated camp!");
                for (UUID campDuplicate : campsDuplicates) {
                    System.err.println("UUID: " + campDuplicate);
                }
            }

            //Diplomacy

            //Enemies
            ArrayList<UUID> enemyIDs = new ArrayList<>();
            for (IdentifierObject enemy : legion.getDiplomacy().getEnemies()) {
                if (enemy.equals(legion.getLegionID())) {
                    System.err.println("Legion enemy can not be itself! Inside " + legion.getLegionID().getName() + "!" +
                            TextUtils.toJson(enemy));
                    return false;
                }
                boolean enemyExists = false;
                enemyIDs.add(enemy.getUuid());
                for (LegionObject legionList : legions.getLegions()) {
                    if (legionList.getLegionID().equals(enemy)) {
                        enemyExists = true;
                        break;
                    }
                }

                if (!enemyExists) {
                    System.err.println("Enemy of "  + legion.getLegionID().getName() + " " +  enemy.getName() + " doesn't exists!" +
                            TextUtils.toJson(enemy));
                    return false;
                }
            }

            Set<UUID> enemyDuplicates = findDuplicates(enemyIDs);
            if (playerDuplicates.size() > 0) {
                System.err.println("Duplicated enemy!");
                for (UUID enemyDuplicate : enemyDuplicates) {
                    System.err.println("UUID: " + enemyDuplicate);
                }
                return false;
            }

            //Allies
            ArrayList<UUID> allyIDs = new ArrayList<>();
            for (IdentifierObject ally : legion.getDiplomacy().getAllies()) {
                allyIDs.add(ally.getUuid());

                if (ally.equals(legion.getLegionID())) {
                    System.err.println("Legion ally can not be itself! Inside " + legion.getLegionID().getName() + "!" +
                            TextUtils.toJson(ally));
                    return false;
                }

                boolean alliesExists = false;
                for (LegionObject legionList : legions.getLegions()) {
                    if (legionList.getLegionID().equals(ally)) {
                        alliesExists = true;
                        break;
                    }
                }

                if (!alliesExists) {
                    System.err.println("Ally of "  + legion.getLegionID().getName() + " " +  ally.getName() + " doesn't exists!" +
                            TextUtils.toJson(ally));
                    return false;
                }
            }

            Set<UUID> allyDuplicates = findDuplicates(allyIDs);
            if (playerDuplicates.size() > 0) {
                System.out.println("Duplicated ally!");
                for (UUID allyDuplicate : allyDuplicates) {
                    System.out.println("UUID: " + allyDuplicate);
                }
                return false;
            }

            amountVerified++;
            System.out.println("Successfully verified " +
                    legion.getLegionID().getName() + " (" + amountVerified + "/" + legions.getLegions().size() + ")");
        }

        Set<UUID> legionDuplicates = findDuplicates(legionsIDs);
        if (legionDuplicates.size() > 0) {
            System.out.println("Duplicated legions!");
            for (UUID legionDuplicate : legionDuplicates) {
                System.out.println("UUID: " + legionDuplicate);
            }
            return false;
        }
        return true;
    }
}