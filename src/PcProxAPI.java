public class PcProxAPI {
    private boolean isConnected = false;
    private int numberOfDevices = 0;

    public boolean connect(){
        if (isConnected) return true;

        boolean rc = tryToConnect();
        if (rc) {
            numberOfDevices = PcProxSO.getDeviceCount();
            isConnected = true;
        }

        return numberOfDevices > 0;
    }

    private boolean tryToConnect(){
        PcProxSO.usbDisconnect();
        PcProxSO.setDeviceSearchType(0); // usb
        return PcProxSO.usbConnect() > 0;
    }

    public void disconnect() {
        PcProxSO.usbDisconnect();
    }

    public int getLastError(){
        return PcProxSO.getLastLibErr();
    }

    public String getCardId() {

        byte[] byteArray = new byte[36];

        PcProxSO.getQueuedId(1,1);

        for (int j=0;j<35;j++) {
            byteArray[j] = PcProxSO.getQueuedIdIndex(j);
        }

        int nbits = byteArray[32];
        if (nbits == 0) return "";

        return getHexString(byteArray);
    }

    private String getHexString(byte[] buf) {
        StringBuilder sb = new StringBuilder();

        for (int i=0;i<6; i++) {
            String formattedString = String.format("%02X ", buf[i] & 255);
            sb.append(formattedString);
        }

        return sb.toString();
    }
}
