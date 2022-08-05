package be.raft.legions.utils;

import be.raft.legions.objects.LegionsObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.Bukkit;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Objects;

public class SaveManager {
    private static final String worldName = Bukkit.getWorlds().get(0).getName();
    private static final String legionFile =Objects.requireNonNull(Bukkit.getWorld(worldName)).getWorldFolder() + "/legions.json";
    private static final String legionFileBack =Objects.requireNonNull(Bukkit.getWorld(worldName)).getWorldFolder() + "/legions.json.bak";

    public static LegionsObject loadLegions() {
        if (!new File(legionFile).exists()) {
            System.out.println("No legion file save was found! Creating a new one..");
            LegionsObject legions = new LegionsObject(new ArrayList<>());
            saveLegions(legions);
            System.out.println("Legion save file has been created!");
            return new LegionsObject(new ArrayList<>());
        }
        System.out.println("Loading legions for " + worldName);
        Gson gson = new Gson();
        try {
            FileReader jsonReader = new FileReader(legionFile);
            LegionsObject legions = gson.fromJson(jsonReader, LegionsObject.class);
            jsonReader.close();
            System.out.println("Successfully loaded legions for " + worldName);
            return legions;
        } catch (IOException e) {
            System.out.println("UNABLE TO LOAD LEGIONS : " + e.getMessage());
            return null;
        }
    }

    public static void saveLegions(LegionsObject legions) {
        System.out.println("Saving legions for " + worldName);
        writeJson(legions, legionFile);
        System.out.println("Successfully saved legions for " + worldName);
    }

    public static void createBackupLegions(LegionsObject legions) {
        writeJson(legions, legionFileBack);
        System.out.println("Successfully saved legions for " + worldName);
    }

    public static void backupLegionFile() {
        if (new File(legionFileBack).exists()) new File(legionFileBack).delete();
        try {
            Files.copy(new File(legionFile).toPath(), new File(legionFileBack).toPath());
        } catch (IOException e) {
            System.out.println("UNABLE TO CREATE BACKUP FILE :");
            e.printStackTrace();
        }
    }

    private static void writeJson(LegionsObject legions, String file) {
        Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();
        String legionJson = gsonBuilder.toJson(legions);
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(legionJson);
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("UNABLE TO WRITE LEGIONS : ");
            e.printStackTrace();
        }
    }
}
