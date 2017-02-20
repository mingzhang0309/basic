package socket.chapter1;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by stephen.zhang on 17/2/15.
 */
public class InetAddressExample {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaceEnumeration = NetworkInterface.getNetworkInterfaces();
            while (interfaceEnumeration.hasMoreElements()) {
                NetworkInterface networkInterface = interfaceEnumeration.nextElement();
                System.out.println(networkInterface.getName());

                Enumeration<InetAddress> addrList = networkInterface.getInetAddresses();
                while (addrList.hasMoreElements()) {
                    InetAddress inetAddress = addrList.nextElement();
                    System.out.println(inetAddress);
                }
            }
        } catch (SocketException e) {
        }
    }
}
