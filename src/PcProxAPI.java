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

        return bytesToHex(byteArray);
    }

    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
    private static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

}
