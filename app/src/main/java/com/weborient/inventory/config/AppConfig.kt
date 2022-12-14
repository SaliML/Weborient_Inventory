package com.weborient.inventory.config

import android.graphics.Bitmap
import android.os.Environment
import com.brother.sdk.lmprinter.PrinterModel
import com.brother.sdk.lmprinter.setting.PTPrintSettings
import com.weborient.inventory.handlers.api.IApiRequests
import java.io.File

/**
 * Alkalmazás konfigurációját tartalmazó osztály
 */
object AppConfig {
    //API címe
    var apiAddress: String? = null

    //AccessToken
    var accessToken: String? = null

    //ApiServices
    var apiServiceWithBearer: IApiRequests? = null
    var apiServiceWithoutBearer: IApiRequests? = null

    //Mappa útvonalak
    const val TEMP_FOLDER = "Inventory/temp"

    //Fájlnév
    const val TEMP_PHOTO_UPLOAD_FILE = "tempphotoupload.dat"

    //Nyomtató beállításai
    var macAddress: String? = null
    val bitmapCompressFormat = Bitmap.CompressFormat.PNG
    val bitmapCompressQuality = 100

    val imageFile = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString(), "tempCode.png")
    val printerModel = PrinterModel.PT_P300BT
    val printerWorkPath = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString())
    val printerLabelSize = PTPrintSettings.LabelSize.Width12mm
    val printerChainPrint = false

    //Jogosultságkérés kódja
    const val REQUEST_CODE_PERMISSION = 1
    const val REQUEST_PHOTO = 2

    //QR kód szkennelés eredmény kulcs
    const val SCANNING_RESULT = "scanning_result"


    //Kezdőképernyő időzítő beállításai
    const val SPLASH_TIMER_DURATION_HOURS: Long = 0
    const val SPLASH_TIMER_DURATION_MINUTES: Long = 0
    const val SPLASH_TIMER_DURATION_SECONDS: Long = 3
    const val SPLASH_TIMER_DOWN_INTERVAL: Long = 1000

    //QR kód generálás beállításai
    const val DEFAULT_QR_CODE_SIZE: Int = 256

    //SharedPrefences azonosítók
    const val SHAREDPREF_ID = "inventory_app"
    const val SHAREDPREF_KEY_PRINTER_MAC_ADDRESS = "printer_mac_address"
    const val SHAREDPREF_KEY_API_ADDRESS = "api_address"

    //Formátumok
    const val DATETIME_FORMAT_yyyyMMdd_HHmmss = "yyyyMMdd_HHmmss"
}