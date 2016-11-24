public final class PcProxSO {
    public static int usbConnect() {
        return IPcProxSO.INSTANCE._Z17pcprox_usbConnectv();
    }
    public static int usbDisconnect(){
        return IPcProxSO.INSTANCE._Z13USBDisconnectv();
    }
    public static int getQueuedId(int clearUID, int clearHold) {
        return IPcProxSO.INSTANCE._Z18pcprox_GetQueuedIDss(clearUID, clearHold);
    }
    public static int getQueuedIdIndex(int index) {
        return IPcProxSO.INSTANCE._Z24pcprox_GetQueuedID_indexs(index);
    }
    public static int getLastLibErr() {
        return IPcProxSO.INSTANCE._Z13GetLastLibErrv();
    }
    public static int setDeviceSearchType(int devSearchType) {
        return IPcProxSO.INSTANCE._Z21pcprox_SetDevTypeSrchs(devSearchType);
    }
    public static int beepNow(byte count, int beepType) {
        return IPcProxSO.INSTANCE._Z14pcprox_BeepNowhi(count, beepType);
    }
    public static int getDeviceCount(){
        return IPcProxSO.INSTANCE._Z16pcprox_GetDevCntv();
    }
}