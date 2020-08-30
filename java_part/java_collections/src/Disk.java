import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Disk {

    private static int counterId = 0;
    private int diskId;
    private List<Composition> compositionList;


    public Disk(List<Composition> compositionList) {
        this.compositionList = compositionList;
        setDiskId(++counterId);
    }

    public void setDiskId(int diskId) {
        this.diskId = diskId;
    }

    public double getTotalDuration() {
        int totalInSeconds = 0;

        for (Composition composition : this.compositionList) {
            totalInSeconds += composition.getDurationInSeconds();
        }
        double totalInMinutes = (totalInSeconds / 60) + ((double) (totalInSeconds) % 60) / 100;
        return totalInMinutes;
    }


    public List<Composition> sortByStyle() {
        Collections.sort(this.compositionList, Comparator.comparing(Composition::getStyle));
        return this.compositionList;
    }


    public List<String> getDisksCompostionsName() {
        List<String> names=new ArrayList<>();
        for(Composition composition: this.compositionList) {
            names.add(composition.getName());
        }
        return names;
    }

    public List<String> getCompositionFromDurationRange(double startRange, double endRange) {
        List<String> filteredList=new ArrayList<>();
        for(Composition composition: this.compositionList) {
            if(composition.getDuration()>=startRange && composition.getDuration()<=endRange) {
                filteredList.add(composition.getName());
            }
        }
        return filteredList;
    }
}
