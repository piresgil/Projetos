public class Main {
    public static void main(String[] args) {

        DirecoesEnum cima = DirecoesEnum.CIMA;

        Naipes copas = Naipes.COPAS;

        System.out.println(cima);
        System.out.println("----- " + copas.getNomeNaipe());

        ResponseAPI responseAPI = new ResponseAPI();
        responseAPI.setBody("resposta");
        responseAPI.setResponseCodeEnum(ResponseCodeEnum.OK);
        System.out.println(responseAPI);

        ResponseCodeEnum ok = ResponseCodeEnum.valueOf("OK");
        System.out.println(ok);

        if (ResponseCodeEnum.OK.getStatusCode() == 200) {
            System.out.println("Foi OK");
        }
    }
}