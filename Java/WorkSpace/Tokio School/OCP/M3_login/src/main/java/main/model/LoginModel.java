package main.model;

// class responsavel por validar o user e pass
public class LoginModel {
    public boolean autenticar(String username, String password){
        return "daniel".equals(username) && "1234".equals(password);
    }
}
