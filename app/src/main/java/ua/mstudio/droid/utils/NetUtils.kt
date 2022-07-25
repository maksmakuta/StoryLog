package ua.mstudio.droid.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket
import java.net.SocketAddress
import java.util.concurrent.atomic.AtomicBoolean

object NetUtils {

    fun isInternetAvailable(ctx : Context) : Boolean{
        if(!isNetworkAvailable(ctx)){
            return false
        }else {
            val bool = AtomicBoolean(false)
            val thread = Thread {
                try {
                    val timeoutMs = 1000
                    val sock = Socket()
                    val sockaddr: SocketAddress = InetSocketAddress("8.8.8.8", 53)
                    sock.connect(sockaddr, timeoutMs)
                    sock.close()
                    bool.set(true)
                } catch (e: IOException) {
                    bool.set(false)
                }
            }
            thread.start()
            thread.join()
            return bool.get()
        }
    }

    private fun isNetworkAvailable(ctx : Context): Boolean {
        val connectivityManager =
            ctx.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val nw = connectivityManager.activeNetwork ?: return false
        val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
        return when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)      -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)  -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)  -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
            else -> false
        }
    }

}