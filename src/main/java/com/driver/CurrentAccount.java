package com.driver;

import java.util.Arrays;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, 5000);
        if (balance < 5000){
            throw new Exception("Insufficient Balance");
        }
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        char[] chArr = tradeLicenseId.toCharArray();
        boolean flag;
        for (int i=0;i<chArr.length-1;i++){
            if (chArr[i] == chArr[i+1]){
                flag = false;
                for (int j=i+1;j<chArr.length;j++){
                    if (chArr[j] != chArr[i]){
                        char temp = chArr[i+1];
                        chArr[i+1] = chArr[j];
                        chArr[j] = temp;
                        flag = true;
                        break;
                    }
                }

                if (!flag){
                    throw new Exception("Valid License can not be generated");
                }
            }
        }

        this.tradeLicenseId = Arrays.toString(chArr);
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }
}
