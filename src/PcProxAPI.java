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

}
