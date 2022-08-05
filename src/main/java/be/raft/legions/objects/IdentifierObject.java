package be.raft.legions.objects;

import java.util.UUID;

public class IdentifierObject {
    String name;
    UUID uuid;

    public IdentifierObject(String name, UUID uuid) {
        assert (name != null || uuid != null);
        this.name = name;
        this.uuid = uuid;
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
}
