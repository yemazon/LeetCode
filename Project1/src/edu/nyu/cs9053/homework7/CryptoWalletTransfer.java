package edu.nyu.cs9053.homework7;

public class CryptoWalletTransfer {

    @SuppressWarnings("unchecked")
    public static <T extends Cryptocurrency> void transfer(CryptoWallet<? extends T> original, CryptoWallet<? super T> copy) {

        for (int i = 0; i < original.length(); i++) {
            if (original.get(i) != null && !copy.contains(original.get(i))) {
                copy.add(original.get(i));
            }
        }
    }
}
