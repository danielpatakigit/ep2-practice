// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisTest1 {

    public static void main(String[] args) {

        Point p1 = new Point(1,2);
        Point p2 = new Point(4,8);
        Point p3 = new Point(3,-4);
        Point p4 = new Point(-2,6);
        Point p5 = new Point(-4,6);
        Point p6 = new Point(2, 3);
        Point p7 = new Point(1, 3);
        Point p8 = new Point(5, 6);

        System.out.println("Test 'countWithinRange' and 'add' method:");
        TreeSetPoint s1 = new TreeSetPoint(new Point(0, 0));
        s1.add(p1); // [1,2]
        s1.add(p2); // [4,8]
        s1.add(p3); // [3,-4]
        s1.add(p4); // [-2,6]
        s1.add(p5); // [-4,6]

        TreeSetPoint s2 = new TreeSetPoint(new Point(5, 5));
        s2.add(p2); // [1,2]
        s2.add(p6); // [2,3]
        s2.add(p7); // [1,3]
        s2.add(p8); // [5,6]

        testValue(s1.countWithinRange(1), 0);
        testValue(s1.countWithinRange(5), 1);
        testValue(s1.countWithinRange(15), 5);

        testValue(s2.countWithinRange(1), 1);
        testValue(s2.countWithinRange(5), 3);
        testValue(s2.countWithinRange(15), 4);

        System.out.println("Test 'addAll' method:");
        s1.addAll(s2);
        testValue(s1.countWithinRange(15), 8);

        System.out.println("Test 'toString' method:");
        testEquals(new TreeSetPoint(new Point(0, 1)).toString(), "[] ref [0,1]");
        testEquals(s1.toString(),
                "[[1,2], [1,3], [2,3], [3,-4], [-2,6], [-4,6], [5,6], [4,8]] ref [0,0] min 3 max 12");
        testEquals(s2.toString(), "[[5,6], [4,8], [2,3], [1,3]] ref [5,5] min 1 max 6");

    }

    public static void testEquals(Object given, Object expected) {
        if (given == expected) {
            System.out.println("Successful test");
            return;
        } else {
            if (given == null) {
                System.out.println("Test NOT successful! Expected value: " +
                        expected +
                        " / Given value: null");
                return;
            }
            if (expected == null) {
                System.out.println("Test NOT successful! Expected value: null / " +
                        "Given value: " + given);
                return;
            }
        }
        if (given.equals(expected)) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + expected.toString() + " / Given " +
                    "value: " + given.toString());
        }
    }

    public static void testEquals(Point given, Point expected) {
        if (given == expected) {
            System.out.println("Successful test");
            return;
        } else {
            if (given == null) {
                System.out.println("Test NOT successful! Expected value: " +
                        "(" + expected.toString() + ")" +
                        " / Given value: null");
                return;
            }
            if (expected == null) {
                System.out.println("Test NOT successful! Expected value: null / " +
                        "Given value: " + "(" + given.toString() + ")");
                return;
            }
        }

        if (given.isEqualTo(expected)) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: (" + expected.toString() +
                    ") / " +
                    "Given value: (" + given.toString() + ")");
        }
    }

    public static void testValue(int given, int expected) {
        if (given == expected) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + expected + " / Given value: " + given);
        }
    }

}
