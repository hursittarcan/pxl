package be.pxl.h6;

public class Opdracht2 {
    public static void main(String args[]) {

        System.out.println("min.value = " + Integer.MIN_VALUE);
        System.out.println("max.value = " + Integer.MAX_VALUE);
        //

        // New Interger(...) is depricated.
        Integer iObj = Integer.valueOf("1234567"),
                jObj = Integer.valueOf(1234567);
        //

        System.out.println("waarden van de integer objecten vergeleken : "
                + iObj.equals(jObj));
        //

        System.out.println("referenties vergeleken : "
                + (iObj == jObj));
        //

        System.out.println("int-waarden vergeleken met constante: "
                + (iObj.intValue() == 1234567));
        //

        System.out.println("int-waarden vd objecten vergeleken : "
                + (iObj.intValue() == jObj.intValue()));
        //

        int k = 255;
        Integer kObj = new Integer(k);
        System.out.println(k);
        System.out.println(kObj.toString());
        //
        System.out.println(Integer.toString(k));
        //
        System.out.println(Integer.toString(k, 2));
        //
        System.out.println(Integer.toBinaryString(k));
        //
        System.out.println(Integer.toHexString(k));
        //
        System.out.println(Integer.toString(k, 16));
    }

}
