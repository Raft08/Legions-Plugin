package be.raft.legions.utils;

import be.raft.legions.objects.IdentifierObject;
import be.raft.legions.objects.LegionObject;
import be.raft.legions.objects.PermissionsObject;
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

    public static ArrayList<RankObject> createDefaultRanks() {
        ArrayList<RankObject> ranks = new ArrayList<>();

        ranks.add(new RankObject(new IdentifierObject("Recruit", UUID.randomUUID()),
                new RankObject.PermissionsObject(
                        new PermissionsObject.WorldEditingPerms(
                                false,
                                false,
                                false,
                                false
                        ),
                        new PermissionsObject.EntityPerms(
                                false,
                                true,
                                false
                        ),
                        new PermissionsObject.CampEditingPerms(
                                false,
                                false,
                                false
                        ),
                        new PermissionsObject.LegionEditingPerms(
                                false,
                                false
                        ),
                        new PermissionsObject.RankEditingPerms(
                                false,
                                false,
                                false
                        ),
                        new PermissionsObject.DiplomacyPerms(
                                false,
                                false,
                                false
                        )
                )));

        ranks.add(new RankObject(new IdentifierObject("Member", UUID.randomUUID()),
                new RankObject.PermissionsObject(
                        new PermissionsObject.WorldEditingPerms(
                                true,
                                true,
                                false,
                                false
                        ),
                        new PermissionsObject.EntityPerms(
                                true,
                                true,
                                true
                        ),
                        new PermissionsObject.CampEditingPerms(
                                false,
                                false,
                                false
                        ),
                        new PermissionsObject.LegionEditingPerms(
                                false,
                                false
                        ),
                        new PermissionsObject.RankEditingPerms(
                                false,
                                false,
                                false
                        ),
                        new PermissionsObject.DiplomacyPerms(
                                false,
                                false,
                                false
                        )
                )));

        ranks.add(new RankObject(new IdentifierObject("Officer", UUID.randomUUID()),
                new RankObject.PermissionsObject(
                        new PermissionsObject.WorldEditingPerms(
                                true,
                                true,
                                true,
                                true
                        ),
                        new PermissionsObject.EntityPerms(
                                true,
                                true,
                                true
                        ),
                        new PermissionsObject.CampEditingPerms(
                                false,
                                false,
                                true
                        ),
                        new PermissionsObject.LegionEditingPerms(
                                false,
                                false
                        ),
                        new PermissionsObject.RankEditingPerms(
                                true,
                                true,
                                true
                        ),
                        new PermissionsObject.DiplomacyPerms(
                                true,
                                true,
                                true
                        )
                )));

        ranks.add(new RankObject(new IdentifierObject("Owner", UUID.randomUUID()),
                new RankObject.PermissionsObject(
                        new PermissionsObject.WorldEditingPerms(
                                true,
                                true,
                                true,
                                true
                        ),
                        new PermissionsObject.EntityPerms(
                                true,
                                true,
                                true
                        ),
                        new PermissionsObject.CampEditingPerms(
                                true,
                                true,
                                true
                        ),
                        new PermissionsObject.LegionEditingPerms(
                                true,
                                true
                        ),
                        new PermissionsObject.RankEditingPerms(
                                true,
                                true,
                                true
                        ),
                        new PermissionsObject.DiplomacyPerms(
                                true,
                                true,
                                true
                        )
                )));

        return ranks;
    }
}
