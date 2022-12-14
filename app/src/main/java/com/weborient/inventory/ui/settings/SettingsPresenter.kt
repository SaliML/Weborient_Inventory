package com.weborient.inventory.ui.settings

import android.bluetooth.BluetoothDevice
import com.weborient.inventory.handlers.dialog.DialogTypeEnums
import com.weborient.inventory.models.PrinterModel
import java.util.*

class SettingsPresenter(private val view: ISettingsContract.ISettingsView): ISettingsContract.ISettingsPresenter {
    private val interactor = SettingsInteractor(this)

    override fun getApiAddress() {
        interactor.getApiAddress()
    }

    override fun getMacAddress() {
        interactor.getMacAddress()
    }

    override fun getAppVersion() {
        interactor.getAppVersion()
    }

    override fun onFetchedApiAddress(apiAddress: String) {
        view.showApiAddress(apiAddress)
    }

    override fun onFetchedMacAddress(macAddress: String?) {
        view.showPrinterMacAddress(macAddress)
    }

    override fun onFetchedPrinterName(printerName: String) {
        view.showPrinterName(printerName)
    }

    override fun onFetchedPrinterPairStatus(printerPairStatus: String) {
        view.showPrinterStatus(printerPairStatus)
    }

    override fun onFetchedAppVersion(version: String) {
        view.showAppVersion(version)
    }

    override fun refreshPrinter(pairedDevices: Set<BluetoothDevice>?) {
        interactor.searchPrinter(pairedDevices)
    }

    override fun onClickedBackButton() {
        view.closeActivity()
    }

    override fun onClickedApiSaveButton(apiAddress: String?) {
        if(!apiAddress.isNullOrEmpty()){
            view.showApiError(null)
            view.saveApiAddress(apiAddress)
            interactor.setApiAddress(apiAddress)

            view.showInformationDialog("Sikeres mentés", DialogTypeEnums.Successful)
        }
        else{
            view.showApiError("Kérem töltse ki a mezőt!")
        }
    }

    override fun onClickedPrinterMacAddressSaveButton(macAddress: String?) {
        if(!macAddress.isNullOrEmpty()){
            view.showMacAddressError(null)
            view.saveMacAddress(macAddress.uppercase(Locale.getDefault()))
            interactor.setMacAddress(macAddress)

            view.showInformationDialog("Sikeres mentés", DialogTypeEnums.Successful)
        }
        else{
            view.showMacAddressError("Kérem töltse ki a mezőt!")
        }
    }
}