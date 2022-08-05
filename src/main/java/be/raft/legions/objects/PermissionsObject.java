package be.raft.legions.objects;

import com.google.gson.annotations.SerializedName;

public class PermissionsObject {
    @SerializedName("world_editing_permissions")
    WorldEditingPerms worldEditingPerms;
    @SerializedName("entity_permissions")
    EntityPerms entityPerms;
    @SerializedName("camp_editing_permissions")
    CampEditingPerms campEditingPerms;
    @SerializedName("legion_editing_permissions")
    LegionEditingPerms legionEditingPerms;
    @SerializedName("rank_editing_permissions")
    RankEditingPerms rankEditingPerms;
    @SerializedName("diplomacy_permissions")
    DiplomacyPerms diplomacyPerms;

    public PermissionsObject(WorldEditingPerms worldEditingPerms, EntityPerms entityPerms, CampEditingPerms campEditingPerms, LegionEditingPerms legionEditingPerms, RankEditingPerms rankEditingPerms, DiplomacyPerms diplomacyPerms) {
        assert (worldEditingPerms != null || entityPerms != null || campEditingPerms != null || legionEditingPerms != null || rankEditingPerms != null || diplomacyPerms != null);
        this.worldEditingPerms = worldEditingPerms;
        this.entityPerms = entityPerms;
        this.campEditingPerms = campEditingPerms;
        this.legionEditingPerms = legionEditingPerms;
        this.rankEditingPerms = rankEditingPerms;
        this.diplomacyPerms = diplomacyPerms;
    }

    public WorldEditingPerms getWorldEditingPerms() {
        return worldEditingPerms;
    }

    public void setWorldEditingPerms(WorldEditingPerms worldEditingPerms) {
        assert worldEditingPerms != null;
        this.worldEditingPerms = worldEditingPerms;
    }

    public EntityPerms getEntityPerms() {
        return entityPerms;
    }

    public void setEntityPerms(EntityPerms entityPerms) {
        assert entityPerms != null;
        this.entityPerms = entityPerms;
    }

    public CampEditingPerms getCampEditingPerms() {
        return campEditingPerms;
    }

    public void setCampEditingPerms(CampEditingPerms campEditingPerms) {
        assert campEditingPerms != null;
        this.campEditingPerms = campEditingPerms;
    }

    public LegionEditingPerms getLegionEditingPerms() {
        return legionEditingPerms;
    }

    public void setLegionEditingPerms(LegionEditingPerms legionEditingPerms) {
        assert legionEditingPerms != null;
        this.legionEditingPerms = legionEditingPerms;
    }

    public RankEditingPerms getRankEditingPerms() {
        return rankEditingPerms;
    }

    public void setRankEditingPerms(RankEditingPerms rankEditingPerms) {
        assert rankEditingPerms != null;
        this.rankEditingPerms = rankEditingPerms;
    }

    public DiplomacyPerms getDiplomacyPerms() {
        return diplomacyPerms;
    }

    public void setDiplomacyPerms(DiplomacyPerms diplomacyPerms) {
        assert diplomacyPerms != null;
        this.diplomacyPerms = diplomacyPerms;
    }

    //Nested permissions classes
    public static class WorldEditingPerms {
        Boolean canBreakBlocks;
        Boolean canPlaceBlocks;
        Boolean canCreateBuildings;
        Boolean canRemoveBuildings;

        public WorldEditingPerms(Boolean canBreakBlocks, Boolean canPlaceBlocks, Boolean canCreateBuildings, Boolean canRemoveBuildings) {
            assert (canBreakBlocks != null || canPlaceBlocks != null || canCreateBuildings != null || canRemoveBuildings != null);
            this.canBreakBlocks = canBreakBlocks;
            this.canPlaceBlocks = canPlaceBlocks;
            this.canCreateBuildings = canCreateBuildings;
            this.canRemoveBuildings = canRemoveBuildings;
        }

        public Boolean getCanBreakBlocks() {
            return canBreakBlocks;
        }

        public void setCanBreakBlocks(Boolean canBreakBlocks) {
            assert canBreakBlocks != null;
            this.canBreakBlocks = canBreakBlocks;
        }

        public Boolean getCanPlaceBlocks() {
            return canPlaceBlocks;
        }

        public void setCanPlaceBlocks(Boolean canPlaceBlocks) {
            assert canPlaceBlocks != null;
            this.canPlaceBlocks = canPlaceBlocks;
        }

        public Boolean getCanCreateBuildings() {
            return canCreateBuildings;
        }

        public void setCanCreateBuildings(Boolean canCreateBuildings) {
            assert canCreateBuildings != null;
            this.canCreateBuildings = canCreateBuildings;
        }

        public Boolean getCanRemoveBuildings() {
            return canRemoveBuildings;
        }

        public void setCanRemoveBuildings(Boolean canRemoveBuildings) {
            assert canRemoveBuildings != null;
            this.canRemoveBuildings = canRemoveBuildings;
        }
    }
    public static class EntityPerms {
        Boolean canDamagePassive;
        Boolean canDamageHostile;
        Boolean canBreedEntities;

        public EntityPerms(Boolean canDamagePassive, Boolean canDamageHostile, Boolean canBreedEntities) {
            assert (canDamagePassive != null || canDamageHostile != null || canBreedEntities != null);
            this.canDamagePassive = canDamagePassive;
            this.canDamageHostile = canDamageHostile;
            this.canBreedEntities = canBreedEntities;
        }

        public Boolean getCanDamagePassive() {
            return canDamagePassive;
        }

        public void setCanDamagePassive(Boolean canDamagePassive) {
            assert canDamagePassive != null;
            this.canDamagePassive = canDamagePassive;
        }

        public Boolean getCanDamageHostile() {
            return canDamageHostile;
        }

        public void setCanDamageHostile(Boolean canDamageHostile) {
            assert canDamageHostile != null;
            this.canDamageHostile = canDamageHostile;
        }

        public Boolean getCanBreedEntities() {
            return canBreedEntities;
        }

        public void setCanBreedEntities(Boolean canBreedEntities) {
            assert canBreedEntities != null;
            this.canBreedEntities = canBreedEntities;
        }
    }
    public static class CampEditingPerms {
        Boolean canCreateCamp;
        Boolean canDeleteCamp;
        Boolean canChangeCampSettings;

        public CampEditingPerms(Boolean canCreateCamp, Boolean canDeleteCamp, Boolean canChangeCampSettings) {
            assert (canCreateCamp != null || canDeleteCamp != null || canChangeCampSettings != null);
            this.canCreateCamp = canCreateCamp;
            this.canDeleteCamp = canDeleteCamp;
            this.canChangeCampSettings = canChangeCampSettings;
        }

        public Boolean getCanCreateCamp() {
            return canCreateCamp;
        }

        public void setCanCreateCamp(Boolean canCreateCamp) {
            assert canCreateCamp != null;
            this.canCreateCamp = canCreateCamp;
        }

        public Boolean getCanDeleteCamp() {
            return canDeleteCamp;
        }

        public void setCanDeleteCamp(Boolean canDeleteCamp) {
            assert canDeleteCamp != null;
            this.canDeleteCamp = canDeleteCamp;
        }

        public Boolean getCanChangeCampSettings() {
            return canChangeCampSettings;
        }

        public void setCanChangeCampSettings(Boolean canChangeCampSettings) {
            assert canChangeCampSettings != null;
            this.canChangeCampSettings = canChangeCampSettings;
        }
    }
    public static class LegionEditingPerms {
        Boolean canDeleteLegion;
        Boolean canChangeLegionSettings;

        public LegionEditingPerms(Boolean canDeleteLegion, Boolean canChangeLegionSettings) {
            assert (canDeleteLegion != null || canChangeLegionSettings != null);
            this.canDeleteLegion = canDeleteLegion;
            this.canChangeLegionSettings = canChangeLegionSettings;
        }

        public Boolean getCanDeleteLegion() {
            return canDeleteLegion;
        }

        public void setCanDeleteLegion(Boolean canDeleteLegion) {
            assert canDeleteLegion != null;
            this.canDeleteLegion = canDeleteLegion;
        }

        public Boolean getCanChangeLegionSettings() {
            return canChangeLegionSettings;
        }

        public void setCanChangeLegionSettings(Boolean canChangeLegionSettings) {
            assert canChangeLegionSettings != null;
            this.canChangeLegionSettings = canChangeLegionSettings;
        }
    }
    public static class RankEditingPerms {
        Boolean canCreateRank;
        Boolean canDeleteRank;
        Boolean canEditRank;

        public RankEditingPerms(Boolean canCreateRank, Boolean canDeleteRank, Boolean canEditRank) {
            assert (canCreateRank != null || canDeleteRank != null || canEditRank != null);
            this.canCreateRank = canCreateRank;
            this.canDeleteRank = canDeleteRank;
            this.canEditRank = canEditRank;
        }

        public Boolean getCanCreateRank() {
            return canCreateRank;
        }

        public void setCanCreateRank(Boolean canCreateRank) {
            assert canCreateRank != null;
            this.canCreateRank = canCreateRank;
        }

        public Boolean getCanDeleteRank() {
            return canDeleteRank;
        }

        public void setCanDeleteRank(Boolean canDeleteRank) {
            assert canDeleteRank != null;
            this.canDeleteRank = canDeleteRank;
        }

        public Boolean getCanEditRank() {
            return canEditRank;
        }

        public void setCanEditRank(Boolean canEditRank) {
            assert canEditRank != null;
            this.canEditRank = canEditRank;
        }
    }
    public static class DiplomacyPerms {
        Boolean canEnemyLegion;
        Boolean canAllyLegion;
        Boolean canStartRaid;

        public DiplomacyPerms(Boolean canEnemyLegion, Boolean canAllyLegion, Boolean canStartRaid) {
            assert (canEnemyLegion != null || canAllyLegion != null || canStartRaid != null);
            this.canEnemyLegion = canEnemyLegion;
            this.canAllyLegion = canAllyLegion;
            this.canStartRaid = canStartRaid;
        }

        public Boolean getCanEnemyLegion() {
            return canEnemyLegion;
        }

        public void setCanEnemyLegion(Boolean canEnemyLegion) {
            assert canEnemyLegion != null;
            this.canEnemyLegion = canEnemyLegion;
        }

        public Boolean getCanAllyLegion() {
            return canAllyLegion;
        }

        public void setCanAllyLegion(Boolean canAllyLegion) {
            assert canAllyLegion != null;
            this.canAllyLegion = canAllyLegion;
        }

        public Boolean getCanStartRaid() {
            return canStartRaid;
        }

        public void setCanStartRaid(Boolean canStartRaid) {
            assert  canStartRaid != null;
            this.canStartRaid = canStartRaid;
        }
    }
}