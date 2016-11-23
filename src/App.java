import com.sun.jna.Library;
import com.sun.jna.Native;

public class App {
    public interface pcProxSO extends Library {
        pcProxSO INSTANCE = (pcProxSO) Native.loadLibrary("pcProxAPI", pcProxSO.class);
        int _Z10usbConnectv();
        int _Z17pcprox_usbConnectv();
    }

    public static void main (String[] args) {
        String javaLibPath = System.getProperty("java.library.path");
        String jnaLibPath = System.getProperty("jna.library.path");

        System.out.println("Starting the app");

        System.out.println("Java.library.path = '" + javaLibPath + "'");
        System.out.println("Jna.library.path = '" + jnaLibPath + "'");

        System.loadLibrary("hidapi-hidraw");
        //System.loadLibrary("pcProxAPI");

        int count = 1;
        while (count <= 10) {

            int result = pcProxSO.INSTANCE._Z17pcprox_usbConnectv();
            System.out.println("[Attempt " + count + "] USB Connect Result: " + result);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }

        System.out.println("Done");
    }
}
