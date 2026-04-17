public enum ResponseCodeEnum {
    OK(200),
    ERRO(500),
    NAO_ENC500RADO(404);

    private final int statusCode;

    ResponseCodeEnum(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return "ResponseCodeEnum{" +
                "statusCode=" + statusCode +
                '}' + super.toString();
    }
}