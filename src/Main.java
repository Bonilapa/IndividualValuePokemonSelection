import com.sun.javaws.IconUtil;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.Console;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        CPMULT cpmult = new CPMULT();
        //вбить максимум ЦП
        short maxCP = 1500;

        //вбить базовые статы
        STATS baseStats = new STATS(151,
                143,
                155);

        //new Main().setCpCoefs(cpmult, baseStats);
        // пустить цикл
        //сунуть в СТАТС базовые + ИВ
        //увеличивать уровень с 0 до тех пор пока ЦП не станет больше установки
        //вывести статы цп и уровень на экран
        //изменить ИВ
        new Main().processing(baseStats, cpmult, maxCP);


        //сортировку и удаление точно худших
    }

    public void processing(STATS baseStats, CPMULT cpmult, short maxCP) {
        short ivMax = 15;
        short ivMin = 0;
        short finalATK = 0;
        short finalDEF = 0;
        short finalSTA = 0;
        Double lvl;
        short cp;
        short prevCP = 0;
        Double prevLvl = 0.5;
        Double mult;
        List<PokeData> pokeDataListTop = new LinkedList<>();
        List<PokeData> pokeDataListMaybe = new LinkedList<>();
        PokeData pokeData;
        WR wrTop = new WR("IvysaurTop.txt");
        WR wrMaybe = new WR("IvysaurMaybe.txt");
        boolean forty = false;

        for (short atk = ivMin; atk <= ivMax; atk++) {
            for (short def = ivMin; def <= ivMax; def++) {
                for (short sta = ivMin; sta <= ivMax; sta++) {

                    cp = 0;
                    lvl = 1.0;
                    prevCP = cp;
                    prevLvl = lvl;
                    forty = false;

                    while (lvl < 40.9) {

                        if (lvl.equals(40.5))
                            lvl += 0.5;

                        mult = cpmult.getCpMultiplier(lvl);

                        STATS s = new STATS(atk, def, sta);
                        // System.out.println(lvl);
                        cp = getCP(baseStats,
                                s,
                                mult);
                        if (cp < maxCP) {
                            prevLvl = lvl;
                            prevCP = cp;
                            lvl += 0.5;
                            if (prevLvl.equals(40.0)) {
                                forty = true;
                                pokeData = new PokeData(prevCP, finalATK, atk, finalDEF, def, finalSTA, sta, prevLvl);
                                pokeDataListMaybe.add(pokeData);
                                System.out.println(pokeData);
                            }
                        } else {
                            lvl = 41.0;
                        }
                    }
                    mult = cpmult.getCpMultiplier(prevLvl);
                    finalATK = (short) Math.round(getStat(baseStats.atk,
                            atk,
                            mult));
                    finalDEF = (short) Math.round(getStat(baseStats.def,
                            def,
                            mult));
                    finalSTA = (short) Math.round(getStat(baseStats.sta,
                            sta,
                            mult));
                    if (!forty) {
                        pokeData = new PokeData(prevCP, finalATK, atk, finalDEF, def, finalSTA, sta, prevLvl);
                        pokeDataListTop.add(pokeData);
                    }


                }
            }
        }
        //clarify lists
        System.out.println(pokeDataListTop.size());
        for (int i = 0; i < pokeDataListTop.size(); i++) {
            for (int j = i + 1; j < pokeDataListTop.size(); j++) {
                if (pokeDataListTop.get(i).compareTo(pokeDataListTop.get(j)) < 0) {
                    pokeDataListTop.remove(i);
                    i = 0;
                    j = 1;
                } else if (pokeDataListTop.get(i).compareTo(pokeDataListTop.get(j)) > 0) {
                    pokeDataListTop.remove(j);
                    j--;
                }
            }
        }
        System.out.println(pokeDataListTop.size());
        System.out.println(pokeDataListMaybe.size());
            for (int i = 0; i < pokeDataListMaybe.size(); i++) {
                for (int j = i + 1; j < pokeDataListMaybe.size(); j++) {
                    if (pokeDataListMaybe.get(i).compareTo(pokeDataListMaybe.get(j)) < 0) {
                        pokeDataListMaybe.remove(i);
                        i = 0;
                        j = 1;
                    } else if (pokeDataListMaybe.get(i).compareTo(pokeDataListMaybe.get(j)) > 0) {
                        pokeDataListMaybe.remove(j);
                        j--;
                    }
                }
            }
        System.out.println(pokeDataListMaybe.size());
        //file-output
        for (PokeData pd :
                pokeDataListMaybe) {

            wrMaybe.write(pd.toString());
        }
    }


//    public void setCpCoefs(CPMULT cpmult, STATS baseStats){
//
//        R r = new R("Blastoise151515.txt");
//        TreeMap map = new TreeMap<Double, Double>();
//        //TreeMap<Double, Short> lvlToCp = r.read("short");
//        Double lvl = 1.0;
//        Short cp;
//        Short cpGot;
//        Double cpMultValue;
//        //Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
//        STATS ivStats = new STATS(15,15,15);
//
//        while (lvl <= 41) {
//
//            //System.out.println(lvl);
//            cpMultValue = cpmult.getCpMultiplier(lvl);
//            //cp = lvlToCp.get(lvl);
//            System.out.println(">>>>>" + lvl + " " +
//                    String.valueOf(getAtk(baseStats.atk,
//                            ivStats.atk)
//                            *
//                            getDef(baseStats.def,
//                                    ivStats.def)
//                            *
//                            getSta(baseStats.sta,
//                                    ivStats.sta)
//                            *
//                            cpMultValue
//                            *
//                            cpMultValue
//                            /
//                            10) + "<<<<<");
//            System.out.println("____" + lvl + " " + getCP(baseStats, ivStats, cpMultValue) + "____");
////            if(!cp.equals(cpGot))
////                System.out.println(lvl + " " + cp + " " + cpGot);
//
//            //System.out.println(cp + "  " + getCP(baseStats, ivStats, cpMultValue, coef));
//            lvl += 0.5;
//            if(lvl == 40.5)
//                lvl += 0.5;
//        }
//
//    }

    public Double getStat(Short baseAtk, Short ivAtk, double cpMultValue) {
//        System.out.println((baseAtk + ivAtk) * cpMultValue);
        return (baseAtk + ivAtk) * cpMultValue;
    }

    public short getCP(STATS baseStats, STATS ivStats, double cpMultValue) {
//        System.out.println(
//                (baseStats.atk +
//                        ivStats.atk)
//                        *
//                        Math.sqrt(baseStats.def +
//                                ivStats.def)
//                        *
//                        Math.sqrt(baseStats.sta +
//                                ivStats.sta)
//                        *
//                        cpMultValue
//                        *
//                        cpMultValue
//                        /
//                        10);
        return
                (short) (
                        (baseStats.atk +
                                ivStats.atk)
                                *
                                Math.sqrt(baseStats.def +
                                        ivStats.def)
                                *
                                Math.sqrt(baseStats.sta +
                                        ivStats.sta)
                                *
                                cpMultValue
                                *
                                cpMultValue
                                /
                                10);

    }

    public boolean ifThereAreSmallest(List<PokeData> list) {

        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0 || list.get(i).compareTo(list.get(j)) < 0)
                    return true;
            }
        }
        return false;
    }
}