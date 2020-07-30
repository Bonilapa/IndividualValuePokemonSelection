import com.sun.javaws.IconUtil;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

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


        new Main().setCpCoefs(cpmult, baseStats);
        // пустить цикл
            //сунуть в СТАТС базовые + ИВ
            //увеличивать уровень с 0 до тех пор пока ЦП не станет больше установки
            //вывести статы цп и уровень на экран
            //изменить ИВ

        //processing(baseStats, cpmult, maxCP);


        //сортировку и удаление точно худших
    }

    public static void processing(STATS stats, CPMULT cpmult, short maxCP){
        short ivMax = 15;
        short ivMin = 0;
        short finalATK = 0;
        short finalDEF = 0;
        short finalSTA = 0;
        Double lvl=1.0;
        short cp = 0;
        short prevCP;
        Double prevLvl;

        for(short atk = ivMin; atk <= ivMax; atk++) {
            for (short def = ivMin; def <= ivMax; def++) {
                for (short sta = ivMin; sta <= ivMax; sta++) {

                    do{
                        prevCP = cp;
                        prevLvl = lvl;
                        lvl = lvl + (float)0.5;

                        cp = (short)(
                                Math.round((stats.atk + atk) * cpmult.getCpMultiplier(lvl))
                                *
                                Math.sqrt(Math.round((stats.def + def) * cpmult.getCpMultiplier(lvl)))
                                *
                                Math.sqrt(Math.round((stats.sta + sta) * cpmult.getCpMultiplier(lvl)))
                                *
                                lvl * lvl
                                /
                                10
                        );
                    }while(cp <= maxCP && lvl <= (float)41);

                    finalATK = (short)(Math.round((stats.atk + atk) * cpmult.getCpMultiplier(prevLvl)));
                    finalDEF = (short)(Math.round((stats.def + def) * cpmult.getCpMultiplier(prevLvl)));
                    finalSTA = (short)(Math.round((stats.sta + sta) * cpmult.getCpMultiplier(prevLvl)));

                    System.out.println(
                            prevCP + " " +
                            finalATK + " " +
                            finalDEF + " " +
                            finalSTA + " " +
                            (prevLvl)
                    );
                }
            }
        }


    }

    public void setCpCoefs(CPMULT cpmult, STATS baseStats){

        WR wr = new WR("CpCoefs.txt");
        R r = new R("Ivysaur.txt");
        TreeMap map = new TreeMap<Double, Double>();
        TreeMap<Double, Short> lvlToCp = r.read("short");
        Double lvl = 1.0;
        Short cp;
        Double coef;
        Double cpMultValue;
        //Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        STATS ivStats = new STATS(15,15,15);

        while (lvl <= 41) {

            //System.out.println(lvl);
            cpMultValue = cpmult.getCpMultiplier(lvl);
            cp = lvlToCp.get(lvl);
            coef = 10
                    *
                    cp
                    /
                    (getAtk(baseStats.atk,
                            ivStats.atk,
                            cpMultValue)
                    *
                    getDef(baseStats.def,
                            ivStats.def,
                            cpMultValue)
                    *
                    getSta(baseStats.sta,
                            ivStats.sta,
                            cpMultValue)
                    );

            map.put(lvl.toString(), coef.toString());

            //System.out.println(cp + "  " + getCP(baseStats, ivStats, cpMultValue, coef));
            lvl += 0.5;
            if(lvl == 40.5)
                lvl += 0.5;
        }
        System.out.println("Writing");

        for (Object m:
             map.entrySet()) {

            Map.Entry<Double, Double> e = (Map.Entry<Double, Double>)m;
            wr.write(String.valueOf(e.getKey()), String.valueOf(e.getValue()));

        }

    }

    public Short getAtk(Short baseAtk, Short ivAtk, double cpMultValue){

        return (short)Math.round((baseAtk + ivAtk) * cpMultValue);
    }

    public Double getDef(Short baseDef, Short ivDef, double cpMultValue){

        return (double)Math.sqrt(Math.round((baseDef + ivDef) * cpMultValue));
    }

    public Double getSta(Short baseSta, Short ivSta, double cpMultValue){

        return (double)Math.sqrt(Math.round((baseSta + ivSta) * cpMultValue));
    }

    public short getCP(STATS baseStats, STATS ivStats, double cpMultValue, double coef){
        return
                (short)
                    (getAtk(baseStats.atk,
                            ivStats.atk,
                            cpMultValue)
                *
                    getDef(baseStats.def,
                            ivStats.def,
                            cpMultValue)
                *
                    getSta(baseStats.sta,
                            ivStats.sta,
                            cpMultValue)
                *
                    coef
                /
                10);

    }
}
