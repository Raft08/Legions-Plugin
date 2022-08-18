package be.raft.legions.utils;

import be.raft.legions.Legions;
import org.bukkit.NamespacedKey;

public class PersistentDataKeys {
    public static NamespacedKey legionIDKey = new NamespacedKey(Legions.getPlugin(), "legionIdentifier");
    public static NamespacedKey legionFlagKey = new NamespacedKey(Legions.getPlugin(), "legionFlag");
}
