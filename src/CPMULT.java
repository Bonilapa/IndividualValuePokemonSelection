import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CPMULT {

    TreeMap<Double, Double> treeMap;

    public Double getCpMultiplier(double lvl){
        return treeMap.get(lvl);
    }

    public CPMULT(){
        R r = new R("CpMults.txt");
        this.treeMap = r.read("double");
    }
//    CPMULT(){
//        hashMap = new TreeMap<>();
//        hashMap.put(1.0, 0.094);
//        hashMap.put(1.5,	0.1351374318);
//        hashMap.put(2.0,	0.16639787);
//        hashMap.put(2.5,	0.192650919);
//        hashMap.put(3.0,	0.21573247);
//        hashMap.put(3.5,	0.2365726613);
//        hashMap.put(4.0,	0.25572005);
//        hashMap.put(4.5,	0.2735303812);
//        hashMap.put(5.0,	0.29024988);
//        hashMap.put(5.5,	0.3060573775);
//        hashMap.put(6.0,	0.3210876);
//        hashMap.put(6.5,	0.3354450362);
//        hashMap.put(7.0,	0.34921268);
//        hashMap.put(7.5,	0.3624577511);
//        hashMap.put(8.0,	0.3752356);
//        hashMap.put(8.5,	0.387592416);
//        hashMap.put( 9.0,	0.39956728);
//        hashMap.put( 9.5,	0.4111935514);
//        hashMap.put(10.0,	0.4225);
//        hashMap.put(10.5,	0.4329264091);
//        hashMap.put(11.0,	0.44310755);
//        hashMap.put(11.5,	0.4530599591);
//        hashMap.put(12.0,	0.4627984);
//        hashMap.put(12.5,	0.472336093);
//        hashMap.put(13.0,	0.48168495);
//        hashMap.put(13.5,	0.4908558003);
//        hashMap.put(14.0,	0.49985844);
//        hashMap.put(14.5,	0.508701765);
//        hashMap.put(15.0,	0.51739395);
//        hashMap.put(15.5,	0.5259425113);
//        hashMap.put(16.0,	0.5343543);
//        hashMap.put(16.5,	0.5426357375);
//        hashMap.put(17.0,	0.5507927);
//        hashMap.put(17.5,	0.5588305862);
//        hashMap.put(18.0,	0.5667545);
//        hashMap.put(18.5,	0.5745691333);
//        hashMap.put(19.0,	0.5822789);
//        hashMap.put(19.5,	0.5898879072);
//        hashMap.put(20.0,	0.5974);
//        hashMap.put(20.5,	0.6048236651);
//        hashMap.put(21.0,	0.6121573);
//        hashMap.put(21.5,	0.6194041216);
//        hashMap.put( 22.0,	0.6265671);
//        hashMap.put(22.5,	0.6336491432);
//        hashMap.put(23.0,	0.64065295);
//        hashMap.put(23.5,	0.6475809666);
//        hashMap.put(24.0,	0.65443563);
//        hashMap.put(24.5,	0.6612192524);
//        hashMap.put(25.0,	0.667934);
//        hashMap.put(25.5,	0.6745818959);
//        hashMap.put(26.0,	0.6811649);
//        hashMap.put(26.5,	0.6876849038);
//        hashMap.put(27.0,	0.69414365);
//        hashMap.put(27.5,	0.70054287);
//        hashMap.put(28.0,	0.7068842);
//        hashMap.put(28.5,	0.7131691091);
//        hashMap.put(29.0,	0.7193991);
//        hashMap.put(29.5,	0.7255756136);
//        hashMap.put(30.0,	0.7317);
//        hashMap.put(30.5,	0.7347410093);
//        hashMap.put(31.0,	0.7377695);
//        hashMap.put( 31.5,	0.7407855938);
//        hashMap.put(32.0,	0.74378943);
//        hashMap.put(32.5,	0.7467812109);
//        hashMap.put(33.0,	0.74976104);
//        hashMap.put(33.5,	0.7527290867);
//        hashMap.put(34.0,	0.7556855);
//        hashMap.put(34.5,	0.7586303683);
//        hashMap.put(35.0,	0.76156384);
//        hashMap.put(35.5,	0.7644860647);
//        hashMap.put(36.0,	0.76739717);
//        hashMap.put(36.5,	0.7702972656);
//        hashMap.put(37.0,	0.7731865);
//        hashMap.put(37.5,	0.7760649616);
//        hashMap.put(38.0,	0.77893275);
//        hashMap.put(38.5,	0.7817900548);
//        hashMap.put(39.0,	0.784637);
//        hashMap.put(39.5,	0.7874736075);
//        hashMap.put(40.0,	0.7903);
//        hashMap.put(41.0,	0.79530001);
//        hashMap.put(42.0,	0.8003);
//        hashMap.put(43.0,	0.8053);
//        hashMap.put(44.0,	0.81029999);
//        hashMap.put(45.0,	0.81529999);
//        WR wr = new WR("CpMults.txt");
//        Map.Entry<Double, Double> e;
//        for (Object m:
//             hashMap.entrySet()){
//            e = (Map.Entry<Double, Double>) m;
//            wr.write(e.getKey(), e.getValue());
//        }
//    }
}
