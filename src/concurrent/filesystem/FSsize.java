package concurrent.filesystem;

import java.io.File;

/**
 * Created by mark on 3/3/14.
 */
public class FSsize {

    public static void main(String[] args) {
        File f = new File("/tmp/documentum");
        System.out.println("The total size is " + f.getTotalSpace());
        System.out.println("The total free size is " + f.getFreeSpace());
    }
}
