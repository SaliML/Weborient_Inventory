package com.weborient.inventory.ui.out

import com.weborient.inventory.handlers.dialog.DialogTypeEnums
import com.weborient.inventory.models.ItemModel

class OutPresenter(private val view: IOutContract.IOutView): IOutContract.IOutPresenter {
    private val interactor = OutInteractor(this)

    override fun onClickedBackButton() {
        view.closeActivity()
    }

    override fun onClickedScanButton() {
        view.navigateToScannerActivity()
    }

    override fun onClickedDoneButton(amount: String) {
        val quantity = amount.toIntOrNull()

        if(quantity != null){
            interactor.decreaseAmount(quantity)
        }
        else{
            view.showInformationDialog("Kérem érvényes mennyiséget adjon meg!", DialogTypeEnums.Warning)
        }
    }

    override fun getItemByID(itemID: String?) {
        itemID?.let{
            interactor.getItemByID(it)
        }
    }

    override fun onFetchedItem(item: ItemModel?) {
        if(item != null){
            //Adatok megjelenítése a VIEW-ban ...
            view.showItemPhoto(item.photoURL)
            view.showItemID(item.id)
            view.showItemName(item.name)
            view.showItemDescription(item.description)

            //Termék konténer megjelenítése
            view.showContainerItem()
            view.hideContainerEmpty()

            //Elvonás gomb megjelenítése
            view.showButtonDone()

            //Mennyiség konténer megjelenítése
            view.showContainerAmount()
        }
        else{
            //Termék konténer megjelenítése
            view.showContainerEmpty()
            view.hideContainerItem()

            //Elvonás gomb megjelenítése
            view.hideButtonDone()

            //Mennyiség konténer megjelenítése
            view.hideContainerAmount()
        }
    }

    override fun onResultDecreaseAmount(isSuccessful: Boolean) {
        if(isSuccessful){
            view.showInformationDialog("Sikeres kiadás!", DialogTypeEnums.Successful)
        }
        else{
            view.showInformationDialog("Sikertelen kiadás!", DialogTypeEnums.Error)
        }
    }
}