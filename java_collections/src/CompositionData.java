import java.util.ArrayList;
import java.util.List;

public class CompositionData {

    public static List<Composition> getCompositionData() {
        List<Composition> compositionData = new ArrayList<>();
        compositionData.add(new Composition("Yerstaday", Style.ROCK, 6.00, "Beatles"));
        compositionData.add(new Composition("Let it be", Style.ROCK, 4.20, "Beatles"));
        compositionData.add(new Composition("Fire", Style.ROCK, 3.50, "Kassabian"));
        compositionData.add(new Composition("The Thrill Is Gone", Style.BLUES, 3.00, "B.B.King"));
        compositionData.add(new Composition("Californication", Style.ROCK, 3.50, "Red Hot Chili Peppers"));
        compositionData.add(new Composition("Diamonds", Style.POP, 3.00, "Rihana"));
        compositionData.add(new Composition("No woman no cry", Style.REGGAE, 1.10, "Bob Marley"));
        return compositionData;
    }

}
