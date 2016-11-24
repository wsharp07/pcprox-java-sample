import com.sun.jna.Library;
import com.sun.jna.Native;

public interface IPcProxSO extends Library {
    IPcProxSO INSTANCE = (IPcProxSO) Native.loadLibrary("pcProxAPI", IPcProxSO.class);
    int _Z17pcprox_usbConnectv();
    int _Z13USBDisconnectv();
    int _Z18pcprox_GetQueuedIDss(int clearUID, int clearHold);
    byte _Z24pcprox_GetQueuedID_indexs(int index);
    int _Z13GetLastLibErrv();
    int _Z21pcprox_SetDevTypeSrchs(int devSearchType);
    int _Z14pcprox_BeepNowhi(byte count, int beepType);
    int _Z16pcprox_GetDevCntv();
}