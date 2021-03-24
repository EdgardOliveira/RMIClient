package br.edu.fametro;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalculoSalarial extends Remote {
    public Salario calcular(Salario salario) throws RemoteException;
}