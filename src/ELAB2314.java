public class ELAB2314 {
}

class Hanhtinh{
    private double khoiluong;
    private double bankinh;
    static double G = 6.67300e-11;

    public Hanhtinh(double khoiluong, double bankinh){
        this.bankinh = bankinh;
        this.khoiluong = khoiluong;
    }

    public double tronglucbemat(){
        return (khoiluong * G) / (bankinh * bankinh);
    }
}