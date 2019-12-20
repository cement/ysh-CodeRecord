package cn.cement.ysh.coderecord.utils;

public class BaiduMapUtil {

    public static double getDistance(double longitudeA,double latitudeA,double longitudeB,double latitudeB){
        double a2 = Math.toRadians(longitudeA);
        double a1 = Math.toRadians(latitudeA);
        double b2 = Math.toRadians(longitudeB);
        double b1 = Math.toRadians(latitudeB);
        double t1 = Math.cos(a1) * Math.cos(a2) * Math.cos(b1) * Math.cos(b2);
        double t2 = Math.cos(a1) * Math.sin(a2) * Math.cos(b1) * Math.sin(b2);
        double t3 = Math.sin(a1) * Math.sin(b1);
        double tt = Math.acos(t1 + t2 + t3);
        return 6371000 * tt;
    }
}
