package com.cci.spaceoperators.sockets

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.text.format.Formatter
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.*

class SocketViewModel(application: Application): AndroidViewModel(application) {

    private val serverSocket = DatagramSocket(8888)

    val ipAddress = MutableLiveData<String>(null)

    init {
        listenSocket()

        viewModelScope.launch(Dispatchers.IO) {
            val networkInterfaces = NetworkInterface.getNetworkInterfaces()

            val ip =
                networkInterfaces.toList()
                    .find { it.displayName == "wlan0"}
                    ?.inetAddresses
                    ?.toList()
                    ?.find { it is Inet4Address }
                    ?.hostAddress ?: "127.0.0.1"

            ipAddress.postValue(ip)

            ipAddress.postValue(
                networkInterfaces.toList().fold("") { acc, ni ->
                    ni.inetAddresses.toList().fold(acc) { acc2, add ->
                        "$acc2\n${ni.displayName} : ${add.hostAddress}"
                    }
                }
            )
            ipAddress.postValue(InetAddress.getLocalHost().hostAddress)
        }
    }

    fun listenSocket() {
        viewModelScope.launch(Dispatchers.IO) {
            val buffer = ByteArray(256)
            var packet = DatagramPacket(buffer, buffer.size)
            serverSocket.receive(packet)
            val data = String(packet.data)
            Toast.makeText(getApplication(), data, Toast.LENGTH_LONG).show()
            listenSocket()
        }
    }

    fun sendUDPData(data: String, hostIp: String) {
        viewModelScope.launch(Dispatchers.IO) {
            DatagramSocket().use {
                val dataBytes = data.toByteArray()
                val address = InetAddress.getByName(hostIp)

                val packet = DatagramPacket(dataBytes, dataBytes.size, address, 8888)
                it.send(packet)
            }
        }
    }
}
