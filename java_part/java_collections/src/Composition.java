import java.util.concurrent.TimeUnit;

public class Composition {

    private static int count = 0;
    private int compositionId;
    private String name;
    private Style style;
    private double duration;
    private String artist;

    public Composition(String name, Style style, double duration, String artist) {
        this.name = name;
        this.style = style;
        this.duration = duration;
        this.artist = artist;
        setCompositionId(++count);
    }

    public void setCompositionId(int compositionId) {
        this.compositionId = compositionId;
    }

    public String getName() {
        return name;
    }

    public Style getStyle() {
        return style;
    }

    public double getDuration() {
        return duration;
    }

    public String getArtist() {
        return artist;
    }

    public int getDurationInSeconds() {
        int minutes = ((Double) this.duration).intValue();
        return minutes * 60 + (int) ((this.duration - minutes) * 100);

    }
}
