package com.weborient.inventory.ui.splash

import com.weborient.inventory.handlers.dialog.DialogResultEnums
import com.weborient.inventory.handlers.dialog.DialogTypeEnums

/**
 * MVP minta a töltőképernyőre
 */
interface ISplashContract {

    /**
     * View interfésze
     */
    interface ISplashView{
        /**
         * Jogosultságok ellenőrzése
         * @param permissions Jogosultságtömb
         */
        fun checkPermissions(permissions: Array<String>)

        /**
         * Nyomtató MAC címének kinyerése
         */
        fun getAddressConfigs()

        /**
         * Navigálás a főképernyőre
         */
        fun navigateToMainActivity()

        /**
         * Alkalmazás bezárása
         */
        fun closeApplication()

        /**
         * Jogosultság ablak megjelenítése
         * @param permissions Jogosultságtömb
         * @param requestCode Kérés azonosító
         */
        fun showPermissionDialog(permissions: Array<String>, requestCode: Int)

        /**
         * Információs ablak megjelenítésének definíciója.
         * @param information párbeszédablakban megjelenítendő információ, String típus.
         * @param type párbeszédablak jellegét meghatározó beállítás, DialogTypeEnums típus.
         */
        fun showInformationDialog(information: String, type: DialogTypeEnums)

        /**
         * Konfig adatok párbeszédablak
         */
        fun showConfigDialog(macAddress: String?, apiAddress: String?)
    }

    /**
     * Presenter interfésze
     */
    interface ISplashPresenter{
        /**
         * Jogosultságok lekérdezése
         */
        fun getPermissions()

        /**
         * MAC és API címek ellenőrzése
         * @param macAddress MAC cím
         * @param apiAddress API cím
         */
        fun onFetchedConfigAddresses(macAddress: String?, apiAddress: String?)

        /**
         * Jogosultságok visszaadása
         * @param permissions Jogosultságtömb
         */
        fun onFetchedPermissions(permissions: Array<String>)

        /**
         * Jogosultságok ellenőrzését követően lefutó metódus
         * @param permissions Jogosultságtömb
         */
        fun onCheckedPermissions(permissions: Array<String>?)

        /**
         * Lejárt időzítőhöz tartozó metódus
         */
        fun onFinishedTimer()

        /**
         * Jogosultságok megadása után lefutó metódus
         * @param requestCode Kérés azonosító
         * @param grantResults Jogosultságok állapotát tartalmazó lista
         */
        fun onGrantedPermissions(requestCode: Int, grantResults: IntArray)

        /**
         * Párbeszédablak visszatérő értékének kezelése
         */
        fun onDialogResult(result: DialogResultEnums)
    }

    /**
     * Interactor interfésze
     */
    interface ISplashInteractor{
        /**
         * Jogosultságok lekérdezése
         */
        fun getPermissions()

        /**
         * Időzítő indítása
         * @param intervalHours Óra
         * @param intervalMinutes Perc
         * @param intervalSeconds Másodperc
         * @param countDownIntervalInMillis Léptetés milliszekundumban
         */
        fun startTimer(intervalHours: Long, intervalMinutes: Long, intervalSeconds: Long, countDownIntervalInMillis: Long)

        /**
         * Nyomtató beállítása
         */
        fun setMacAddress(macAddress: String)

        /**
         * API cím beállítása
         */
        fun setApiAddress(apiAddress: String)
    }

}