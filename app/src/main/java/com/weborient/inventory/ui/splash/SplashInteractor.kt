package com.weborient.inventory.ui.splash

import android.os.CountDownTimer
import com.weborient.inventory.handlers.permission.PermissionHandler
import com.weborient.inventory.repositories.permission.PermissionRepository

class SplashInteractor(private val presenter: ISplashContract.ISplashPresenter): ISplashContract.ISplashInteractor {
    private var countDownTimer: CountDownTimer? = null

    /**
     * Jogosultságok lekérdezése
     */
    override fun getPermissions() {
        presenter.onFetchedPermissions(PermissionRepository.getPermissions())
    }

    /**
     * Időzítő indítása
     * @param intervalHours Óra
     * @param intervalMinutes Perc
     * @param intervalSeconds Másodperc
     * @param countDownIntervalInMillis Léptetés milliszekundumban
     */
    override fun startTimer(intervalHours: Long, intervalMinutes: Long, intervalSeconds: Long, countDownIntervalInMillis: Long) {
        val interval = ((intervalHours * 3600) + (intervalMinutes * 60) + intervalSeconds) * 1000
        val countDownInterval = countDownIntervalInMillis

        countDownTimer = object : CountDownTimer(interval, countDownInterval){
            override fun onTick(p0: Long) {}

            override fun onFinish() {
                presenter.onFinishedTimer()
            }

        }.start()
    }
}