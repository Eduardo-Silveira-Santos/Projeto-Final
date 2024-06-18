package com.eduardosantos.afinal;

public class Prompts {
    public static String getRecipe(String userMessage) {
        if (containsKeywords(userMessage, "obrigado", "obrigada", "agradecido", "grato", "vlw", "valeu", "tamo junto", "tmj")) {
            return "De nada! Se precisar de mais alguma coisa, estou aqui para ajudar.";
        }

        // Se nenhuma correspondência, retorna uma mensagem padrão
        return "Desculpe, não encontrei uma receita correspondente.";
    }

    private static boolean containsKeywords(String userMessage, String... keywords) {
        for (String keyword : keywords) {
            if (!userMessage.toLowerCase().contains(keyword)) {
                return false;
            }
        }
        return true;
    }
}
