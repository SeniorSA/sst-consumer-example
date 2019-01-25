package br.com.senior.employee.consumer.rest.json;

public class JSONException extends Exception {
    private Throwable cause; //NOSONAR

    public JSONException(String message) {
        super(message);
    }

    public JSONException(Throwable t) {
        super(t.getMessage());
        this.cause = t;
    }

    @Override
    public Throwable getCause() {
        return this.cause;
    }
}
