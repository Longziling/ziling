package com.ziling.goodlife.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Warehouse extends Remote {
    double getPrice(String description) throws RemoteException;
}
