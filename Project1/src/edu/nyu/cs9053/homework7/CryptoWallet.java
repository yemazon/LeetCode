package edu.nyu.cs9053.homework7;

public class CryptoWallet<T extends Cryptocurrency> extends Wallet {

    public CryptoWallet() {
        super();
    }

    @SuppressWarnings("unchecked")
    public CryptoWallet(T[] array) {
        super(array);
    }
}