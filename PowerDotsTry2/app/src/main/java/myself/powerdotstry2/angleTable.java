package myself.powerdotstry2;

import android.util.Log;

/**
 * Created by j on 2016-01-16.
 */
final public class angleTable {

    static final float[] sin = new float[6283];
    static final float[] cos = new float[6283];
    static {
        // a static initializer fills the table
        // in this implementation, units are in degrees
        for (int i = 0; i<sin.length; i++) {
            sin[i]=(float)Math.sin(i/1000);
            cos[i]=(float)Math.cos(i / 1000);
        }
    }
    // Private function for table lookup
    private static float sinLookup(int a) {
        return a>=0 ? sin[a%6283] : -sin[-a%6283];
    }
    private static float cosLookup(int a) {
        return a>=0 ? cos[a%6283] : cos[-a%6283];
    }

    // These are your working functions:
    public static float sin(float a) {
        return sinLookup((int)a*1000);
    }
    public static float cos(float a) {
        return cosLookup((int)a*1000);
    }

//    static final int precision = 100; // gradations per degree, adjust to suit
//    static final int modulus = 360*precision;
//    static final float[] sin = new float[modulus]; // lookup table
//    static float halfPi =  1.570796326794896619231321691639751442098584699687552910487472f;
//    static {
//        // a static initializer fills the table
//        // in this implementation, units are in degrees
//        for (int i = 0; i<sin.length; i++) {
//            sin[i]=(float)Math.sin(i/precision);
//        }
//    }
//    // Private function for table lookup
//    private static float sinLookup(int a) {
//        return a>=0 ? sin[a%(modulus)] : -sin[-a%(modulus)];
//    }
//
//    // These are your working functions:
//    public static float sin(float a) {
//        return sinLookup((int)(a * precision + 0.5f));
//    }
//    public static float cos(float a) {
//        return sin((float)( a + Math.PI/2 ));
//    }
}
