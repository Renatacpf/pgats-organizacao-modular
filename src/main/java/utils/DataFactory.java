package utils;

import java.util.UUID;

public class DataFactory {
    public static String gerarEmailUnico() {
        return "usuario_" + UUID.randomUUID().toString().substring(0, 5) + "@teste.com";
    }

    public static String gerarSenhaForte() {
        return "Senha@" + UUID.randomUUID().toString().substring(0, 5);
    }

    public static String gerarNome() {
        return "Usuário Teste";
    }
}
