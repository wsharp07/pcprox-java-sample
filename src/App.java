import com.sun.jna.Library;
import com.sun.jna.Native;

public class App {

    static void loadLibs() {
        System.loadLibrary("hidapi-hidraw");
    }
    static void writeJavaLibPaths(){
        String javaLibPath = System.getProperty("java.library.path");
        String jnaLibPath = System.getProperty("jna.library.path");

        System.out.println("Java.library.path = '" + javaLibPath + "'");
        System.out.println("Jna.library.path = '" + jnaLibPath + "'");
    }
    public static void main (String[] args) {
        System.out.println("Starting the app");
        writeJavaLibPaths();
        loadLibs();

        PcProxAPI api = new PcProxAPI();
        int count = 1;
        while (count <= 10) {

            boolean result = api.connect();
            System.out.println("[Attempt " + count + "] USB Connect Result: " + result);

            if (result) break;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }

        api.disconnect();

        System.out.println("Done");
    }
}
