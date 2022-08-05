package be.raft.legions.objects.coords;

public class XZ {
    double x;
    double z;

    public XZ(Double x, Double z) {
        assert (x != null || z != null);
        this.x = x;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(Double x) {
        assert x != null;
        this.x = x;
    }

    public double getZ() {
        return z;
    }

    public void setZ(Double z) {
        assert z != null;
        this.z = z;
    }
}
