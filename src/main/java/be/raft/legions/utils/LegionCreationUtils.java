package be.raft.legions.utils;

import be.raft.legions.objects.IdentifierObject;
import be.raft.legions.objects.LegionObject;
import be.raft.legions.objects.RankObject;

import java.util.ArrayList;
import java.util.UUID;

public class LegionCreationUtils {
    public static LegionObject createEmptyLegion() {
        return new LegionObject(
                new IdentifierObject("legion.name", UUID.randomUUID()),
                new LegionObject.SettingsObject(false,"Hello I'm an example description!", new IdentifierObject("",  UUID.randomUUID())),
                new LegionObject.DataObject(0),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new LegionObject.DiplomacyObject(new ArrayList<>(), new ArrayList<>()));
    }

    public static RankObject.PermissionsObject createDefaultRanks(UUID recruitUuid, UUID memberUuid, UUID officerUuid, UUID ownerUuid) {
        return null;
    }
}
