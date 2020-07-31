public class PokeData {
    public Short cp;
    public Short Atk;
    public Short ivAtk;
    public Short Def;
    public Short ivDef;
    public Short Sta;
    public Short ivSta;
    public Double lvl;

    public PokeData(Short cp, Short atk, Short ivAtk, Short def, Short ivDef, Short sta, Short ivSta, Double lvl) {
        this.cp = cp;
        Atk = atk;
        this.ivAtk = ivAtk;
        Def = def;
        this.ivDef = ivDef;
        Sta = sta;
        this.ivSta = ivSta;
        this.lvl = lvl;
    }


    public void show(){
        System.out.println(cp + " " + Atk + "(" + ivAtk +
                ") " + Def + " (" + ivDef + ") " + Sta + " (" + ivSta + ") " + lvl);
    }

    @Override
    public String toString() {
        return cp +
                " " + Atk +
                " (" + ivAtk +
                ") " + Def +
                " (" + ivDef +
                ") " + Sta +
                " (" + ivSta +
                ") " + lvl;
    }
    public int compareTo(Object o) {
        PokeData p = (PokeData)o;
        if(     (this.Atk < p.Atk && this.Def < p.Def && this.Sta < p.Sta)
                ||
                (this.Atk < p.Atk && this.Def < p.Def && this.Sta == p.Sta)
                ||
                (this.Atk < p.Atk && this.Def == p.Def && this.Sta < p.Sta)
                ||
                (this.Atk < p.Atk && this.Def == p.Def && this.Sta == p.Sta)
                ||
                (this.Atk == p.Atk && this.Def < p.Def && this.Sta < p.Sta)
                ||
                (this.Atk == p.Atk && this.Def < p.Def && this.Sta == p.Sta)
                ||
                (this.Atk == p.Atk && this.Def == p.Def && this.Sta < p.Sta)
        )
            return -1;
        else if((this.Atk > p.Atk && this.Def > p.Def && this.Sta > p.Sta)
                ||
                (this.Atk > p.Atk && this.Def > p.Def && this.Sta == p.Sta)
                ||
                (this.Atk > p.Atk && this.Def == p.Def && this.Sta > p.Sta)
                ||
                (this.Atk > p.Atk && this.Def == p.Def && this.Sta == p.Sta)
                ||
                (this.Atk == p.Atk && this.Def > p.Def && this.Sta > p.Sta)
                ||
                (this.Atk == p.Atk && this.Def > p.Def && this.Sta == p.Sta)
                ||
                (this.Atk == p.Atk && this.Def == p.Def && this.Sta > p.Sta)
        )
            return 1;
        return 0;
    }
}
