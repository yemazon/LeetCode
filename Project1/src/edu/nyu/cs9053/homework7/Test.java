package edu.nyu.cs9053.homework7;

public class Test {
    public static void main(String[] args) {
        Bytecoin bytecoin = new Bytecoin(2);
        System.out.println(bytecoin.getAmount());
        CryptoWallet<Bytecoin> wallet = new CryptoWallet<>();

        System.out.println(wallet.size());
        System.out.println(wallet.length());
        System.out.println(wallet.contains(bytecoin));
        System.out.println(wallet.add(bytecoin));
        Bytecoin newByte = (Bytecoin) wallet.get(0);
        System.out.println(newByte.getAmount());

        CryptoWallet<Bytecoin> test = new CryptoWallet<>();
        CryptoWalletTransfer.transfer(wallet, test);

        System.out.println(test.get(0));
    }
}
