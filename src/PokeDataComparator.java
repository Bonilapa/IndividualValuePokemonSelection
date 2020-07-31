import java.util.Comparator;

public class PokeDataComparator implements Comparator<PokeData> {
    @Override
    public int compare(PokeData o1, PokeData o2) {
        if(o1.Atk < o2.Atk && o1.Def < o2.Def && o1.Sta < o2.Sta)
            return -1;
        else if(o1.Atk > o2.Atk && o1.Def > o2.Def && o1.Sta > o2.Sta)
            return 1;
        return 0;
    }
}
