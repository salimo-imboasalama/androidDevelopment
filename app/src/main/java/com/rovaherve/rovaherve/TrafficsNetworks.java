package com.rovaherve.rovaherve;

import android.net.TrafficStats;
public class TrafficsNetworks {

    static final Long GB = 1000000000L;
    static final Long MB = 1000000L;
    static final Long KB = 1000L;

    public static String getNetworkSpeed() {
        String downloadSpeedOutput = "";
        String units = "";
        Long mBytesPrevious = TrafficStats.getTotalRxBytes() + TrafficStats.getTotalTxBytes();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Long mBytesCurrent = TrafficStats.getTotalRxBytes() + TrafficStats.getTotalTxBytes();
        Long mNetworkSpeed = mBytesCurrent - mBytesPrevious;
        Float mDownloadSpeedWithDecimals;

        if (mNetworkSpeed >= GB) {
            mDownloadSpeedWithDecimals = mNetworkSpeed.floatValue() / GB.floatValue();
            // mDownloadSpeedWithDecimals = mNetworkSpeed.floatValue();
            units = " GB";
        } else if (mNetworkSpeed >= MB) {
            mDownloadSpeedWithDecimals = mNetworkSpeed.floatValue() / MB.floatValue();
            units = " MB";

        } else {
            mDownloadSpeedWithDecimals = mNetworkSpeed.floatValue() / KB.floatValue();
            units = " KB";
        }

        if (units != " KB" && mDownloadSpeedWithDecimals < 100) {
            downloadSpeedOutput = String.format("%.1f", mDownloadSpeedWithDecimals);
        } else {
            downloadSpeedOutput = Integer.toString(mDownloadSpeedWithDecimals.intValue());
        }

        return (downloadSpeedOutput + units);
    }

}