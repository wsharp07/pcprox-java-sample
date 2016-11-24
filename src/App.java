import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {

    private static final Logger logger = LogManager.getLogger();

    static void loadLibs() {
        System.loadLibrary("hidapi-hidraw");
    }
    static void writeJavaLibPaths(){
        String javaLibPath = System.getProperty("java.library.path");
        String jnaLibPath = System.getProperty("jna.library.path");

        System.out.println("Java.library.path = '" + javaLibPath + "'");
        System.out.println("Jna.library.path = '" + jnaLibPath + "'");
    }

    static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void writeGreeting() {
        System.out.println("\n###");
        System.out.println("Starting the console");
        System.out.println("Press CTRL+C to exit");
        System.out.println("###\n");
    }

    public static void main (String[] args) {
        boolean isConnected = false;
        boolean stop = false;
        PcProxAPI api = new PcProxAPI();

        logger.info("Starting up");
        writeJavaLibPaths();
        loadLibs();
        writeGreeting();

        while (!stop) {
            if (isConnected) {

                String cardId = api.getCardId();

                if (cardId.isEmpty() == false) {
                    System.out.println("Card Read: " + cardId);

                    if (api.getLastError() > 0) {
                        System.out.println("Lost reader connection");
                        isConnected = false;
                    }
                }
            }
            else {
                System.out.println("** Please wait... Trying to connect to reader **");
                isConnected = api.connect();

                if (isConnected) {
                    System.out.println("Ready to accept card scan...");
                    api.beepNow(2,0);
                }
            }

            sleep(250);
        }

        api.disconnect();
        System.out.println("Done");
    }
}
