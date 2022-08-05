package be.raft.legions.objects;

import be.raft.legions.objects.coords.XZ;
import com.google.gson.annotations.SerializedName;

public class CampObject {
    @SerializedName("camp")
    IdentifierObject campID;
    CampSettingsObject settings;
    CampDataObject data;

    public CampObject(IdentifierObject campID, CampSettingsObject settings, CampDataObject data) {
        assert (campID != null || settings != null || data != null);
        this.campID = campID;
        this.settings = settings;
        this.data = data;
    }

    public IdentifierObject getCampID() {
        return campID;
    }

    public void setCampID(IdentifierObject campID) {
        assert campID != null;
        this.campID = campID;
    }

    public CampSettingsObject getSettings() {
        return settings;
    }

    public void setSettings(CampSettingsObject settings) {
        assert settings != null;
        this.settings = settings;
    }

    public CampDataObject getData() {
        return data;
    }

    public void setData(CampDataObject data) {
        assert data != null;
        this.data = data;
    }

    public static class CampSettingsObject {
        Boolean isOpen;

        public CampSettingsObject(Boolean isOpen) {
            assert isOpen != null;
            this.isOpen = isOpen;
        }

        public Boolean getOpen() {
            return isOpen;
        }

        public void setOpen(Boolean open) {
            assert isOpen != null;
            isOpen = open;
        }
    }
    public static class CampDataObject {
        Integer tier;
        XZ xz;

        public CampDataObject(Integer tier, XZ xz) {
            assert (tier != null || xz != null);
            this.tier = tier;
            this.xz = xz;
        }

        public Integer getTier() {
            return tier;
        }

        public void setTier(Integer tier) {
            assert tier != null;
            this.tier = tier;
        }

        public XZ getXz() {
            return xz;
        }

        public void setXz(XZ xz) {
            assert xz != null;
            this.xz = xz;
        }
    }
}
