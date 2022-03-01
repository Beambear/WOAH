package util;


import java.sql.SQLException;

public class ErrorExceptionWOAH extends SQLException {
    public ErrorExceptionWOAH(String errorCode) {
        System.out.println("Your input is invalid,please try again.");
        switch(errorCode) {
            case "inserScoreError":
                break;
            case "0":
                break;
            case"NI":
        }
    }
}
