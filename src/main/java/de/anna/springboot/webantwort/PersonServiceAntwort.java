package de.anna.springboot.webantwort;

public class PersonServiceAntwort {

    private boolean isOk;

    private String error;

    public PersonServiceAntwort(boolean isOk, String error) {
        this.isOk = isOk;
        this.error = error;
    }

    public PersonServiceAntwort() {
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
