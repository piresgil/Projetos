public class ResponseAPI {

    private String body;
    private ResponseCodeEnum responseCodeEnum;

    public ResponseAPI() {
    }

    public ResponseAPI(String body, ResponseCodeEnum responseCodeEnum) {
        this.body = body;
        this.responseCodeEnum = responseCodeEnum;
    }

    public ResponseCodeEnum getResponseCodeEnum() {
        return responseCodeEnum;
    }

    public void setResponseCodeEnum(ResponseCodeEnum responseCodeEnum) {
        this.responseCodeEnum = responseCodeEnum;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "ResponseAPI{" +
                "body='" + body + '\'' +
                ", responseCodeEnum=" + responseCodeEnum +
                '}';
    }
}
