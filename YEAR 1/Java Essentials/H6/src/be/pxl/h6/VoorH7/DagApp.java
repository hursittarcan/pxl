package be.pxl.h6.VoorH7;

public class DagApp {
    public static void main(String[] args) {
        for (Dag dag : Dag.values()) {
            System.out.println(dag);
            System.out.println(dag.name());
            System.out.println(dag.ordinal());
            System.out.println(dag.getType());
            System.out.println();
        }

        Dag dag1 = Dag.WOENSDAG;
        Dag dag2 = Dag.VRIJDAG;

        System.out.println(dag1 == dag2);
        System.out.println(dag1.ordinal() < dag2.ordinal());
        System.out.println(dag2.ordinal() - dag1.ordinal());
    }
}
