package be.raft.legions.objects;

import java.util.ArrayList;
import java.util.UUID;

public class IdentifierObject {
    String name;
    UUID uuid;

    public IdentifierObject(String name, UUID uuid) {
        if (name != null || uuid != null);
        this.name = name;
        this.uuid = uuid;
    }

    public IdentifierObject(String name, UUID uuid, LegionObject.SettingsObject settingsObject, LegionObject.DataObject dataObject, ArrayList<Object> objects, ArrayList<Object> objects1, ArrayList<Object> objects2, LegionObject.DiplomacyObject diplomacyObject) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        assert name != null;
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o){
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof IdentifierObject other)) return false;

        return this.name.equals(other.name) && this.uuid.equals(other.uuid);
    }
}
