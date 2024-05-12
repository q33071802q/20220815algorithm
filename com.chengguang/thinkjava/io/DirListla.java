package thinkjava.io;

import java.io.File;

public class DirListla {
    public static void main(String[] args) {
        File path = new File(".");
        final String[] list;
        if (args.length<2){
            list = path.list();
            System.out.println("regex");
        }
    }
}
