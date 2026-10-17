package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract /* synthetic */ class w {
    public static /* synthetic */ java.lang.String b(int i) {
        switch (i) {
            case 1:
                return "-10104";
            case 2:
                return "-10108";
            case 3:
                return "-10109";
            case 4:
                return "-10200";
            case 5:
                return "-10201";
            case 6:
                return "-10202";
            case 7:
                return "-10203";
            case 8:
                return "-10204";
            case 9:
                return "-10205";
            case 10:
                return "-10400";
            case 11:
                return "-10403";
            case 12:
                return "-10405";
            case 13:
                return "-10406";
            case 14:
                return "-10408";
            case 15:
                return "-10409";
            case 16:
                return "-10410";
            case 17:
                return "-10411";
            case 18:
                return "-10415";
            case 19:
                return "-10416";
            case 20:
                return "-10417";
            case 21:
                return "-10418";
            case 22:
                return "-10419";
            case 23:
                return "-10421";
            case 24:
                return "-10424";
            case 25:
                return "-10501";
            default:
                throw null;
        }
    }

    public static /* synthetic */ java.lang.String c(int i) {
        switch (i) {
            case 1:
                return "Unauthorized access.";
            case 2:
                return "Bad file path.";
            case 3:
                return "Not Found file.";
            case 4:
                return "Failed to encrypt data using SM2 public key.";
            case 5:
                return "Failed to decrypt data using SM2 private key.";
            case 6:
                return "Failed to signature data using SM2 private key.";
            case 7:
                return "Failed to verify data using SM2 public key.";
            case 8:
                return "Failed to encrypt data using SM4 algorithm.";
            case 9:
                return "Failed to decrypt data using SM4 algorithm.";
            case 10:
                return "Illegal Argument: cannot be NULL.";
            case 11:
                return "Illegal Argument: SM2 public key error, must be 65 bytes and in the format 04||X||Y.";
            case 12:
                return "Illegal Argument: SM2 signature error, must be 64 bytes and in the format r||s.";
            case 13:
                return "Illegal Argument: SM2 cipher text error, must be more than 96 bytes and in the format C1||C3||C2.";
            case 14:
                return "Illegal Argument: The plaintext data length error, The data length must be a multiple of 16.";
            case 15:
                return "Illegal Argument: The cipher text length error, The data length must be a multiple of 16.";
            case 16:
                return "Illegal Argument: SM4 secret key error, must be 16 bytes.";
            case 17:
                return "Illegal Argument: The size of IV error, must be 16 bytes.";
            case 18:
                return "Illegal Argument: The size of msg too small.";
            case 19:
                return "Illegal Argument: SM2 public key error.";
            case 20:
                return "Illegal Argument: SM2 public key error, must be 65 bytes.";
            case 21:
                return "Illegal Argument: SM2 private key error, must be 32 bytes.";
            case 22:
                return "Illegal Argument: SM2 cipher text error, must be more than 97 bytes.";
            case 23:
                return "Illegal Argument: Wrong public key.";
            case 24:
                return "Illegal Argument: SM2 cipher text format error, must be start with 04.";
            case 25:
                return "DER encoded data encoding or decoding error.";
            default:
                throw null;
        }
    }
}
