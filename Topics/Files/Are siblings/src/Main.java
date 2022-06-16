import java.io.File;

class Siblings {

    public static boolean areSiblings(File f1, File f2) {
        boolean siblings = true;
        if (f1.getParent().equals(f2.getParent())) {
            siblings = true;
        } else {
            siblings = false;
        }
        return siblings;
        // implement me
    }
}