package com.example.sulleynguyen.apporderfood.DTO;

/**
 * Created by sulleynguyen on 2/24/18.
 */

public class EmployeeDTO {

    private int EMPCODE;
    private String USERNAME;
    private String PASSWORD;
    private String GENDER;
    private String BIRTHDAY;
    private int IDCARD;

    public EmployeeDTO(String USERNAME, String PASSWORD, String GENDER, String BIRTHDAY, int IDCARD) {

        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
        this.GENDER = GENDER;
        this.BIRTHDAY = BIRTHDAY;
        this.IDCARD = IDCARD;
    }

    public int getEMPCODE() {
        return EMPCODE;
    }

    public void setEMPCODE(int EMPCODE) {
        this.EMPCODE = EMPCODE;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getGENDER() {
        return GENDER;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }

    public String getBIRTHDAY() {
        return BIRTHDAY;
    }

    public void setBIRTHDAY(String BIRTHDAY) {
        this.BIRTHDAY = BIRTHDAY;
    }

    public int getIDCARD() {
        return IDCARD;
    }

    public void setIDCARD(int IDCARD) {
        this.IDCARD = IDCARD;
    }

}
