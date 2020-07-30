public class IV {

    public short atk;
    public short def;
    public short sta;

    public IV(int atk, int def, int sta){
        this.sta = (short)sta;
        this.def = (short)def;
        this.atk = (short)atk;
    }
    public void atk(int atk){
        this.atk = (short)atk;
    }
    public void def(int def){
        this.def = (short)def;
    }
    public void sta(int sta){
        this.sta = (short)sta;
    }
}
