package com.eduardosantos.afinal;

public class Prompts {
    public static String getRecipe(String userMessage) {
        if (containsKeywords(userMessage, "obrigado", "obrigada", "agradecido", "grato", "vlw", "valeu", "tamo junto", "tmj")) {
            return "De nada! Se precisar de mais alguma coisa, estou aqui para ajudar.";
        }

        if (containsKeywords(userMessage, "risoto", "frutos do mar")) {
            return risotoFrutosDoMar();
        } else if (containsKeywords(userMessage, "strogonoff", "frango")) {
            return strogonoffFrango();
        } else if (containsKeywords(userMessage, "nhoque", "molho de tomate")) {
            return nhoqueMolhoTomate();
        } else if (containsKeywords(userMessage, "penne", "alho e óleo")) {
            return penneAlhoOleo();
        } else if (containsKeywords(userMessage, "parmegiana", "carne")) {
            return parmegianaCarne();
        } else if (containsKeywords(userMessage, "feijoada")) {
            return feijoada();
        } else if (containsKeywords(userMessage, "escondidinho", "carne seca")) {
            return escondidinhoCarneSeca();
        } else if (containsKeywords(userMessage, "yakissoba", "vegetariano")) {
            return yakissobaVegetariano();
        } else if (containsKeywords(userMessage, "quiche", "queijo e presunto")) {
            return quicheQueijoPresunto();
        } else if (containsKeywords(userMessage, "paella", "frutos do mar")) {
            return paellaMariscos();
        } else if (containsKeywords(userMessage, "moqueca", "peixe")) {
            return moquecaPeixe();
        } else if (containsKeywords(userMessage, "tacos", "carnitas")) {
            return tacosCarnitas();
        } else if (containsKeywords(userMessage, "arroz", "carreteiro")) {
            return arrozCarreteiro();
        } else if (containsKeywords(userMessage, "empada", "frango")) {
            return empadaFrango();
        } else if (containsKeywords(userMessage, "picadinho", "carne")) {
            return picadinhoCarne();
        } else if (containsKeywords(userMessage, "bife", "acebolado")) {
            return bifeAcebolado();
        } else if (containsKeywords(userMessage, "penne", "alfredo")) {
            return penneAlfredo();
        } else if (containsKeywords(userMessage, "frango", "assado com ervas")) {
            return frangoAssadoErvas();
        } else if (containsKeywords(userMessage, "canja", "galinha")) {
            return canjaGalinha();
        } else if (containsKeywords(userMessage, "pizza", "calabresa")) {
            return pizzaCalabresa();
        }

        else if (containsKeywords(userMessage, "bolo", "chocolate")) {
            return boloChocolate();
        } else if (containsKeywords(userMessage, "brigadeiro", "tradicional")) {
            return brigadeiroTradicional();
        } else if (containsKeywords(userMessage, "pavlova", "frutas", "vermelhas")) {
            return pavlovaFrutasVermelhas();
        } else if (containsKeywords(userMessage, "torta", "limão")) {
            return tortaLimao();
        } else if (containsKeywords(userMessage, "mousse", "maracujá")) {
            return mousseMaracuja();
        } else if (containsKeywords(userMessage, "brownie", "nozes")) {
            return brownieNozes();
        } else if (containsKeywords(userMessage, "cheesecake", "morango")) {
            return cheesecakeMorango();
        } else if (containsKeywords(userMessage, "pudim", "leite", "condensado")) {
            return pudimLeiteCondensado();
        } else if (containsKeywords(userMessage, "tapioca", "chocolate", "banana")) {
            return tapiocaChocolateBanana();
        } else if (containsKeywords(userMessage, "sorvete", "creme", "frutas")) {
            return sorveteCremeFrutas();
        } else if (containsKeywords(userMessage, "torta", "banoffee")) {
            return tortaBanoffee();
        } else if (containsKeywords(userMessage, "crepe", "nutella", "morango")) {
            return crepeNutellaMorango();
        } else if (containsKeywords(userMessage, "petit", "gateau", "chocolate")) {
            return petitGateauChocolate();
        } else if (containsKeywords(userMessage, "torta", "holandesa")) {
            return tortaHolandesa();
        } else if (containsKeywords(userMessage, "cocada", "cremosa")) {
            return cocadaCremosa();
        } else if (containsKeywords(userMessage, "pavlova", "limão")) {
            return pavlovaLimao();
        } else if (containsKeywords(userMessage, "trufas", "chocolate")) {
            return trufasChocolate();
        } else if (containsKeywords(userMessage, "creme", "papaya")) {
            return cremePapaya();
        } else if (containsKeywords(userMessage, "pudim", "chocolate")) {
            return pudimChocolate();
        } else if (containsKeywords(userMessage, "rocambole", "doce", "leite")) {
            return rocamboleDoceLeite();
        }

        else if (containsKeywords(userMessage, "caipirinha", "limão")) {
            return caipirinhaLimao();
        } else if (containsKeywords(userMessage, "margarita")) {
            return margarita();
        } else if (containsKeywords(userMessage, "mojito")) {
            return mojito();
        } else if (containsKeywords(userMessage, "piña", "colada")) {
            return piñaColada();
        } else if (containsKeywords(userMessage, "cosmopolitan")) {
            return cosmopolitan();
        } else if (containsKeywords(userMessage, "negroni")) {
            return negroni();
        } else if (containsKeywords(userMessage, "sangria")) {
            return sangria();
        } else if (containsKeywords(userMessage, "caipiroska", "morango")) {
            return caipiroskaMorango();
        } else if (containsKeywords(userMessage, "hot", "toddy")) {
            return hotToddy();
        } else if (containsKeywords(userMessage, "mimosa")) {
            return mimosa();
        } else if (containsKeywords(userMessage, "amaretto", "sour")) {
            return amarettoSour();
        } else if (containsKeywords(userMessage, "daiquiri")) {
            return daiquiri();
        } else if (containsKeywords(userMessage, "café", "irlandês")) {
            return caféIrlandes();
        } else if (containsKeywords(userMessage, "moscow", "mule")) {
            return moscowMule();
        } else if (containsKeywords(userMessage, "punch", "frutas")) {
            return punchFrutas();
        } else if (containsKeywords(userMessage, "bellini")) {
            return bellini();
        } else if (containsKeywords(userMessage, "piña", "colada", "sem", "álcool")) {
            return piñaColadaSemAlcool();
        } else if (containsKeywords(userMessage, "caipirinha", "morango")) {
            return caipirinhaMorango();
        } else if (containsKeywords(userMessage, "mojito", "morango")) {
            return mojitoMorango();
        } else if (containsKeywords(userMessage, "bloody", "mary")) {
            return bloodyMary();
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

    //Salgados
    public static String risotoFrutosDoMar() {
        return "Risoto de Frutos do Mar:\n" +
                "1. Ingredientes: Arroz arbóreo, camarões, lulas, mexilhões, caldo de peixe, cebola picada, alho, vinho branco, açafrão, manteiga, sal, pimenta.\n" +
                "2. Preparo: Refogue a cebola e o alho na manteiga, adicione os frutos do mar e refogue rapidamente. Acrescente o arroz e o vinho, depois cozinhe com caldo até ficar cremoso. Finalize com temperos e açafrão.";
//1
    }

    public static String strogonoffFrango() {
        return "Strogonoff de Frango:\n" +
                "1. Ingredientes: Peito de frango, creme de leite, champignon, cebola picada, alho, ketchup, mostarda, molho inglês, manteiga, sal, pimenta.\n" +
                "2. Preparo: Refogue o frango na manteiga com cebola e alho, adicione os champignons e os temperos. Acrescente o creme de leite e deixe apurar até ficar cremoso.";
//2
    }

    public static String nhoqueMolhoTomate() {
        return "Nhoque ao Molho de Tomate:\n" +
                "1. Ingredientes: Nhoque (de batata), tomates frescos, cebola picada, alho, manjericão fresco, azeite, queijo parmesão ralado, sal, pimenta.\n" +
                "2. Preparo: Refogue a cebola e o alho no azeite, adicione os tomates picados e o manjericão. Cozinhe até formar um molho encorpado e sirva sobre o nhoque com queijo parmesão.";
//3
    }

    public static String penneAlhoOleo() {
        return "Penne ao Alho e Óleo:\n" +
                "1. Ingredientes: Penne, alho fatiado, pimenta vermelha, salsinha fresca, azeite de oliva extra virgem, sal.\n" +
                "2. Preparo: Cozinhe o penne al dente, enquanto isso, doure o alho fatiado no azeite com pimenta vermelha. Misture o penne ao alho e óleo, finalize com salsinha e sirva.";
//4
    }

    public static String parmegianaCarne() {
        return "Filé à Parmegiana:\n" +
                "1. Ingredientes: Filé mignon, farinha de trigo, ovos, farinha de rosca, queijo muçarela, molho de tomate, queijo parmesão ralado, sal, pimenta.\n" +
                "2. Preparo: Passe o filé na farinha de trigo, nos ovos batidos e na farinha de rosca. Frite até dourar e coloque em um refratário. Cubra com molho de tomate, queijo muçarela e parmesão. Leve ao forno até gratinar.";
//5
    }

    public static String feijoada() {
        return "Feijoada:\n" +
                "1. Ingredientes: Feijão preto, linguiça calabresa, carne seca, costelinha de porco, bacon, cebola picada, alho, folha de louro, laranja, farinha de mandioca, sal, pimenta.\n" +
                "2. Preparo: Cozinhe as carnes e o feijão separadamente. Refogue cebola, alho e folha de louro, adicione as carnes e o feijão. Sirva com farinha de mandioca e laranja.";
//6
    }

    public static String escondidinhoCarneSeca() {
        return "Escondidinho de Carne Seca:\n" +
                "1. Ingredientes: Carne seca, mandioca (aipim), queijo muçarela, cebola picada, alho, leite, manteiga, sal, pimenta.\n" +
                "2. Preparo: Cozinhe a carne seca e desfie. Cozinhe a mandioca até ficar macia e faça um purê com leite e manteiga. Monte em um refratário camadas de purê, carne seca e queijo. Asse até dourar.";
//7
    }

    public static String yakissobaVegetariano() {
        return "Yakissoba Vegetariano:\n" +
                "1. Ingredientes: Macarrão para yakissoba, brócolis, cenoura, pimentão, cogumelos variados, molho de soja, óleo de gergelim, alho, gengibre, sal, pimenta.\n" +
                "2. Preparo: Cozinhe o macarrão e reserve. Refogue os vegetais no óleo com alho e gengibre, adicione molho de soja. Junte o macarrão e salteie até aquecer tudo.";
//8
    }

    public static String quicheQueijoPresunto() {
        return "Quiche de Queijo e Presunto:\n" +
                "1. Ingredientes: Massa para quiche, queijo muçarela, presunto picado, ovos, creme de leite, leite, noz-moscada, sal, pimenta.\n" +
                "2. Preparo: Forre uma forma com a massa, cubra com queijo e presunto. Bata os ovos com creme de leite, leite, noz-moscada, sal e pimenta. Despeje sobre a massa e asse até dourar.";
//9
    }

    public static String paellaMariscos() {
        return "Paella de Frutos do Mar:\n" +
                "1. Ingredientes: Arroz bomba, camarões, mexilhões, lulas, pimentão vermelho, tomate, ervilhas, açafrão, caldo de peixe, alho, azeite, sal, pimenta.\n" +
                "2. Preparo: Refogue o alho no azeite, adicione o arroz e mexa. Acrescente os frutos do mar, legumes, açafrão e caldo de peixe. Cozinhe até o arroz absorver o líquido e os frutos do mar estiverem cozidos.";
//10
    }

    public static String moquecaPeixe() {
        return "Moqueca de Peixe:\n" +
                "1. Ingredientes: Filés de peixe (robalo, dourado, ou outro de sua preferência), leite de coco, pimentões coloridos, cebola picada, tomate, coentro fresco, azeite de dendê, limão, sal, pimenta.\n" +
                "2. Preparo: Refogue a cebola no azeite de dendê, adicione os pimentões e tomate picados. Coloque os filés de peixe, regue com leite de coco, limão, sal e pimenta. Cozinhe até o peixe ficar macio.";
//11
    }

    public static String tacosCarnitas() {
        return "Tacos de Carnitas:\n" +
                "1. Ingredientes: Carne de porco (pernil), cebola roxa fatiada, coentro fresco, limão, tortillas de milho, molho de pimenta, sal, pimenta.\n" +
                "2. Preparo: Cozinhe a carne de porco lentamente até ficar macia e dourada. Desfie a carne, aqueça as tortillas, monte os tacos com carne, cebola, coentro, molho de pimenta, limão e temperos.";
//12
    }

    public static String arrozCarreteiro() {
        return "Arroz Carreteiro:\n" +
                "1. Ingredientes: Arroz, carne bovina (preferencialmente sobras de churrasco), linguiça calabresa, cebola picada, alho, tomate, pimentão, cheiro-verde, óleo, sal, pimenta.\n" +
                "2. Preparo: Refogue a cebola e o alho no óleo, adicione a linguiça calabresa cortada em rodelas. Junte a carne bovina desfiada, tomate, pimentão picados. Acrescente o arroz, água quente, sal e pimenta. Cozinhe até o arroz ficar macio.";
//13
    }

    public static String empadaFrango() {
        return "Empada de Frango:\n" +
                "1. Ingredientes: Massa para empada, peito de frango cozido e desfiado, cebola picada, azeitonas verdes picadas, cheiro-verde, requeijão cremoso, ovos, sal, pimenta.\n" +
                "2. Preparo: Refogue a cebola no azeite, adicione o frango desfiado, azeitonas, cheiro-verde, sal e pimenta. Deixe esfriar. Forre forminhas com a massa, recheie com o refogado de frango, cubra com requeijão cremoso, feche as empadas, pincele com ovo batido e leve ao forno até dourar.";
//14
    }

    public static String picadinhoCarne() {
        return "Picadinho de Carne:\n" +
                "1. Ingredientes: Carne bovina (coxão mole ou alcatra), cebola picada, alho, tomate, pimentão, cenoura, batata, óleo, vinho tinto, caldo de carne, sal, pimenta.\n" +
                "2. Preparo: Refogue a cebola e o alho no óleo, adicione a carne cortada em cubos, deixe dourar. Junte o tomate, pimentão, cenoura e batata em cubos, vinho tinto, caldo de carne, sal e pimenta. Cozinhe até os legumes ficarem macios e o molho reduzir.";
//15
    }

    public static String bifeAcebolado() {
        return "Bife Acebolado:\n" +
                "1. Ingredientes: Bifes de carne bovina (contrafilé, alcatra), cebolas cortadas em rodelas, alho, vinagre, óleo, sal, pimenta.\n" +
                "2. Preparo: Tempere os bifes com sal, pimenta e alho. Frite os bifes em óleo quente até dourar. Na mesma frigideira, refogue as cebolas até caramelizar. Acrescente um pouco de vinagre para deglaçar. Sirva os bifes com as cebolas por cima.";
//16
    }

    public static String penneAlfredo() {
        return "Penne Alfredo:\n" +
                "1. Ingredientes: Penne, creme de leite fresco, queijo parmesão ralado, manteiga, alho, noz-moscada, sal, pimenta.\n" +
                "2. Preparo: Cozinhe o penne al dente. Enquanto isso, derreta a manteiga em uma panela, adicione o alho picado, o creme de leite e o queijo parmesão ralado. Tempere com noz-moscada, sal e pimenta. Misture o molho com o penne cozido e sirva.";
//17
    }

    public static String frangoAssadoErvas() {
        return "Frango Assado com Ervas:\n" +
                "1. Ingredientes: Frango inteiro, alecrim fresco, tomilho fresco, alho, limão, azeite de oliva, sal, pimenta.\n" +
                "2. Preparo: Tempere o frango com sal, pimenta, alho picado, alecrim e tomilho frescos. Regue com suco de limão e azeite. Asse no forno pré-aquecido até dourar e ficar bem cozido.";
//18
    }

    public static String canjaGalinha() {
        return "Canja de Galinha:\n" +
                "1. Ingredientes: Peito de frango, arroz, cenoura, batata, cebola picada, alho, caldo de galinha, salsinha, sal, pimenta.\n" +
                "2. Preparo: Cozinhe o peito de frango em água com caldo de galinha até ficar macio. Retire o frango, desfie e reserve. Adicione arroz, cenoura, batata, cebola e alho na panela com o caldo. Cozinhe até os legumes e o arroz estarem macios. Devolva o frango desfiado, ajuste o tempero e finalize com salsinha.";
//19
    }

    public static String pizzaCalabresa() {
        return "Pizza de Calabresa:\n" +
                "1. Ingredientes: Massa de pizza, molho de tomate, queijo muçarela, linguiça calabresa fatiada, cebola em rodelas, orégano, azeite, sal, pimenta.\n" +
                "2. Preparo: Abra a massa de pizza, espalhe o molho de tomate e cubra com queijo muçarela. Distribua a linguiça calabresa e a cebola. Tempere com orégano, azeite, sal e pimenta a gosto. Asse em forno pré-aquecido até a massa estar crocante e o queijo derretido.";
//20
    }

    //Doces
    public static String boloChocolate() {
        return "Bolo de Chocolate:\n" +
                "1. Ingredientes: Farinha de trigo, açúcar, chocolate em pó, ovos, leite, óleo, fermento em pó, sal, essência de baunilha.\n" +
                "2. Preparo: Bata os ovos com o açúcar até obter uma mistura clara e fofa. Adicione o óleo, o leite e a essência de baunilha. Peneire os ingredientes secos (farinha, chocolate em pó, fermento e sal) e adicione à mistura líquida, mexendo delicadamente até incorporar. Asse em forno pré-aquecido até o bolo passar no teste do palito.";
//1
    }

    public static String brigadeiroTradicional() {
        return "Brigadeiro Tradicional:\n" +
                "1. Ingredientes: Leite condensado, chocolate em pó, manteiga sem sal, granulado de chocolate.\n" +
                "2. Preparo: Em uma panela, misture o leite condensado, o chocolate em pó e a manteiga. Cozinhe em fogo baixo, mexendo sempre, até que a mistura desgrude do fundo da panela. Transfira para um prato untado e deixe esfriar. Modele os brigadeiros, passe pelo granulado de chocolate e sirva.";
//2
    }

    public static String pavlovaFrutasVermelhas() {
        return "Pavlova de Frutas Vermelhas:\n" +
                "1. Ingredientes: Claras de ovos, açúcar refinado, vinagre branco, amido de milho, creme de leite fresco, açúcar de confeiteiro, frutas vermelhas (morangos, amoras, framboesas), geleia de frutas vermelhas.\n" +
                "2. Preparo: Bata as claras em neve, adicionando o açúcar aos poucos, até obter picos firmes. Incorpore o vinagre e o amido de milho. Modele a pavlova em um círculo no papel manteiga e leve ao forno baixo por 1 hora. Bata o creme de leite com açúcar de confeiteiro até o ponto de chantilly. Monte a pavlova com o chantilly, frutas vermelhas e geleia.";
//3
    }

    public static String tortaLimao() {
        return "Torta de Limão:\n" +
                "1. Ingredientes: Massa para torta, leite condensado, suco de limão, raspas de limão, creme de leite fresco, açúcar de confeiteiro.\n" +
                "2. Preparo: Asse a massa para torta até dourar. Em um bowl, misture o leite condensado com o suco de limão até obter um creme espesso. Acrescente as raspas de limão e o creme de leite fresco batido com açúcar de confeiteiro até formar um creme leve. Espalhe sobre a massa assada e leve à geladeira. Decore com raspas de limão antes de servir.";
//4
    }

    public static String mousseMaracuja() {
        return "Mousse de Maracujá:\n" +
                "1. Ingredientes: Polpa de maracujá, leite condensado, creme de leite fresco, gelatina incolor.\n" +
                "2. Preparo: Dissolva a gelatina conforme instruções da embalagem. No liquidificador, bata a polpa de maracujá com o leite condensado e o creme de leite fresco até obter um creme homogêneo. Adicione a gelatina dissolvida e bata novamente. Distribua em taças individuais e leve à geladeira por algumas horas até firmar. Decore com sementes de maracujá.";
//5
    }

    public static String brownieNozes() {
        return "Brownie de Nozes:\n" +
                "1. Ingredientes: Chocolate meio amargo, manteiga sem sal, açúcar mascavo, ovos, farinha de trigo, nozes picadas, fermento em pó.\n" +
                "2. Preparo: Derreta o chocolate com a manteiga em banho-maria. Bata os ovos com o açúcar até obter uma mistura clara e fofa. Incorpore o chocolate derretido. Adicione a farinha de trigo peneirada, as nozes picadas e o fermento em pó. Misture delicadamente. Asse em forma untada e enfarinhada em forno pré-aquecido. Deixe esfriar antes de cortar em quadrados.";
//6
    }

    public static String cheesecakeMorango() {
        return "Cheesecake de Morango:\n" +
                "1. Ingredientes: Biscoitos tipo maisena, cream cheese, açúcar, suco de limão, ovos, creme de leite fresco, morangos frescos, gelatina incolor.\n" +
                "2. Preparo: Triture os biscoitos e misture com manteiga derretida. Forre o fundo de uma forma removível e reserve. Bata o cream cheese com açúcar até ficar cremoso. Adicione o suco de limão, os ovos e o creme de leite fresco. Misture bem. Hidrate a gelatina conforme instruções da embalagem e incorpore à mistura de cream cheese. Despeje sobre a base de biscoitos e leve à geladeira por algumas horas. Decore com morangos frescos antes de servir.";
//7
    }

    public static String pudimLeiteCondensado() {
        return "Pudim de Leite Condensado:\n" +
                "1. Ingredientes: Leite condensado, leite integral, ovos, açúcar para caramelizar.\n" +
                "2. Preparo: Prepare a calda caramelizando açúcar em uma forma para pudim. No liquidificador, bata o leite condensado, o leite integral e os ovos até obter uma mistura homogênea. Despeje na forma caramelizada e leve ao forno em banho-maria por cerca de 1 hora ou até firmar. Deixe esfriar completamente antes de desenformar.";
//8
    }

    public static String tapiocaChocolateBanana() {
        return "Tapioca de Chocolate com Banana:\n" +
                "1. Ingredientes: Goma de tapioca, chocolate meio amargo picado, banana em rodelas, coco ralado.\n" +
                "2. Preparo: Aqueça uma frigideira antiaderente e espalhe a goma de tapioca formando uma camada fina. Quando começar a desgrudar, vire para aquecer do outro lado. Retire do fogo e recheie com o chocolate meio amargo picado, banana em rodelas e coco ralado. Dobre ao meio e sirva quente.";
//9
    }

    public static String sorveteCremeFrutas() {
        return "Sorvete Creme com Frutas Frescas:\n" +
                "1. Ingredientes: Creme de leite fresco, leite condensado, essência de baunilha, frutas frescas picadas (morangos, kiwi, manga, etc.).\n" +
                "2. Preparo: Bata o creme de leite fresco até o ponto de chantilly. Adicione o leite condensado e a essência de baunilha, batendo até incorporar. Misture delicadamente as frutas frescas picadas. Transfira para um recipiente adequado e leve ao congelador por algumas horas até firmar. Sirva gelado.";
//10
    }

    public static String tortaBanoffee() {
        return "Torta Banoffee:\n" +
                "1. Ingredientes: Biscoitos tipo maisena, manteiga sem sal, bananas maduras, doce de leite pronto, creme de leite fresco, cacau em pó.\n" +
                "2. Preparo: Triture os biscoitos e misture com manteiga derretida. Forre o fundo de uma forma de torta e leve ao forno para firmar. Deixe esfriar. Espalhe uma camada de doce de leite sobre a base de biscoitos. Fatie as bananas e coloque sobre o doce de leite. Bata o creme de leite fresco com cacau em pó até obter chantilly. Cubra a torta com o chantilly e decore com raspas de chocolate antes de servir.";
//11
    }

    public static String crepeNutellaMorango() {
        return "Crepe de Nutella com Morango:\n" +
                "1. Ingredientes: Farinha de trigo, leite, ovos, manteiga derretida, Nutella, morangos frescos, açúcar de confeiteiro.\n" +
                "2. Preparo: Misture a farinha de trigo, leite, ovos e manteiga derretida até obter uma massa homogênea. Aqueça uma frigideira antiaderente e despeje uma concha pequena de massa, espalhando bem para formar um crepe fino. Cozinhe dos dois lados até dourar. Espalhe Nutella sobre o crepe e distribua morangos fatiados. Dobre ao meio e polvilhe açúcar de confeiteiro por cima.";
//12
    }

    public static String petitGateauChocolate() {
        return "Petit Gateau de Chocolate:\n" +
                "1. Ingredientes: Chocolate meio amargo, manteiga sem sal, ovos, açúcar, farinha de trigo, cacau em pó.\n" +
                "2. Preparo: Derreta o chocolate com a manteiga em banho-maria. Em uma tigela, bata os ovos com o açúcar até obter uma mistura clara. Incorpore o chocolate derretido. Adicione a farinha de trigo peneirada com o cacau em pó e misture delicadamente. Unte forminhas individuais com manteiga e farinha, despeje a massa e leve ao forno pré-aquecido por cerca de 10 minutos. Desenforme imediatamente e sirva quente com sorvete de creme.";
//13
    }

    public static String tortaHolandesa() {
        return "Torta Holandesa:\n" +
                "1. Ingredientes: Biscoito maisena, manteiga sem sal, chocolate meio amargo, creme de leite fresco, cream cheese, leite condensado, gelatina incolor, raspas de chocolate para decorar.\n" +
                "2. Preparo: Triture os biscoitos e misture com manteiga derretida. Forre o fundo de uma forma de aro removível e leve à geladeira. Derreta o chocolate com o creme de leite fresco em banho-maria e reserve. Bata o cream cheese com leite condensado até ficar cremoso. Hidrate a gelatina conforme instruções da embalagem e adicione ao creme de cream cheese. Misture bem e adicione o chocolate derretido. Despeje sobre a base de biscoitos e leve à geladeira por algumas horas até firmar. Decore com raspas de chocolate antes de servir.";
//14
    }

    public static String cocadaCremosa() {
        return "Cocada Cremosa:\n" +
                "1. Ingredientes: Coco fresco ralado, leite condensado, leite de coco, açúcar, manteiga sem sal.\n" +
                "2. Preparo: Em uma panela, misture o coco ralado, leite condensado, leite de coco, açúcar e manteiga. Cozinhe em fogo baixo, mexendo sempre, até obter uma cocada cremosa e homogênea. Deixe esfriar antes de servir.";
//15
    }

    public static String pavlovaLimao() {
        return "Pavlova de Limão:\n" +
                "1. Ingredientes: Claras de ovos, açúcar refinado, vinagre branco, amido de milho, creme de leite fresco, açúcar de confeiteiro, suco e raspas de limão.\n" +
                "2. Preparo: Bata as claras em neve, adicionando o açúcar aos poucos, até obter picos firmes. Incorpore o vinagre e o amido de milho. Modele a pavlova em um círculo no papel manteiga e leve ao forno baixo por 1 hora. Bata o creme de leite com açúcar de confeiteiro até o ponto de chantilly. Misture o suco e as raspas de limão. Monte a pavlova com o chantilly de limão e decore com mais raspas de limão antes de servir.";
//16
    }

    public static String trufasChocolate() {
        return "Trufas de Chocolate:\n" +
                "1. Ingredientes: Chocolate meio amargo, creme de leite fresco, conhaque ou rum (opcional), cacau em pó.\n" +
                "2. Preparo: Derreta o chocolate com o creme de leite fresco em banho-maria. Se desejar, adicione o conhaque ou rum. Deixe esfriar e leve à geladeira por algumas horas até firmar. Modele bolinhas com as mãos untadas com manteiga e passe no cacau em pó. Sirva em forminhas de papel.";
//17
    }

    public static String cremePapaya() {
        return "Creme de Papaya com Cassis:\n" +
                "1. Ingredientes: Mamão papaya, sorvete de creme, licor de cassis, açúcar.\n" +
                "2. Preparo: Descasque e retire as sementes do papaya. Corte em pedaços e bata no liquidificador com sorvete de creme e licor de cassis a gosto até obter uma mistura cremosa. Adoce com açúcar a gosto. Sirva gelado.";
//18
    }

    public static String pudimChocolate() {
        return "Pudim de Chocolate:\n" +
                "1. Ingredientes: Leite condensado, leite integral, ovos, chocolate em pó, açúcar para caramelizar.\n" +
                "2. Preparo: Prepare a calda caramelizando açúcar em uma forma para pudim. No liquidificador, bata o leite condensado, o leite integral, os ovos e o chocolate em pó até obter uma mistura homogênea. Despeje na forma caramelizada e leve ao forno em banho-maria por cerca de 1 hora ou até firmar. Deixe esfriar completamente antes de desenformar.";
//19
    }

    public static String rocamboleDoceLeite() {
        return "Rocambole de Doce de Leite:\n" +
                "1. Ingredientes: Ovos, açúcar, farinha de trigo, fermento em pó, doce de leite pronto, açúcar de confeiteiro.\n" +
                "2. Preparo: Bata os ovos com o açúcar até obter um creme fofo. Adicione a farinha de trigo peneirada com o fermento e misture delicadamente. Despeje a massa em uma forma retangular forrada com papel manteiga e leve ao forno pré-aquecido até dourar. Retire do forno, desenforme sobre um pano de prato úmido, espalhe o doce de leite e enrole com cuidado. Polvilhe açúcar de confeiteiro por cima.";
//20
    }

    //Bebidas
    public static String caipirinhaLimao() {
        return "Caipirinha de Limão:\n" +
                "1. Ingredientes: Limão Tahiti, açúcar, cachaça, gelo.\n" +
                "2. Preparo: Corte o limão em rodelas, retire o miolo branco. Macere as rodelas de limão com açúcar em um copo. Adicione gelo e complete com cachaça. Mexa bem e sirva.";
//1
    }

    public static String margarita() {
        return "Margarita:\n" +
                "1. Ingredientes: Tequila, licor de laranja (Cointreau ou Triple Sec), suco de limão, sal, gelo.\n" +
                "2. Preparo: Esfregue a borda de um copo com limão e depois passe no sal. Em um shaker, misture tequila, licor de laranja, suco de limão e gelo. Agite bem e coe para o copo preparado.";
//2
    }

    public static String mojito() {
        return "Mojito:\n" +
                "1. Ingredientes: Hortelã fresca, limão, açúcar, rum branco, água com gás, gelo.\n" +
                "2. Preparo: Macere folhas de hortelã com limão cortado em pedaços e açúcar em um copo. Adicione rum branco e gelo. Complete com água com gás, mexa suavemente e decore com folhas de hortelã.";
//3
    }

    public static String piñaColada() {
        return "Piña Colada:\n" +
                "1. Ingredientes: Rum branco, leite de coco, suco de abacaxi, açúcar, abacaxi em pedaços, gelo.\n" +
                "2. Preparo: Em um liquidificador, bata rum branco, leite de coco, suco de abacaxi, açúcar e gelo até obter uma mistura homogênea. Sirva em um copo decorado com um pedaço de abacaxi.";
//4
    }

    public static String cosmopolitan() {
        return "Cosmopolitan:\n" +
                "1. Ingredientes: Vodka, licor de laranja (Cointreau), suco de cranberry, suco de limão, gelo.\n" +
                "2. Preparo: Em um shaker, misture vodka, licor de laranja, suco de cranberry, suco de limão e gelo. Agite bem e coe para uma taça de martini previamente gelada.";
//5
    }

    public static String negroni() {
        return "Negroni:\n" +
                "1. Ingredientes: Gin, vermute tinto, Campari, gelo.\n" +
                "2. Preparo: Em um copo baixo com gelo, misture gin, vermute tinto e Campari. Mexa bem e sirva com uma casca de laranja para decorar.";
//6
    }

    public static String sangria() {
        return "Sangria:\n" +
                "1. Ingredientes: Vinho tinto, refrigerante de limão, suco de laranja, frutas frescas (como laranja, limão, maçã, morangos), açúcar, gelo.\n" +
                "2. Preparo: Em uma jarra grande, misture vinho tinto, refrigerante de limão, suco de laranja e frutas cortadas em pedaços. Adicione açúcar a gosto e mexa bem. Sirva com bastante gelo.";
//7
    }

    public static String caipiroskaMorango() {
        return "Caipiroska de Morango:\n" +
                "1. Ingredientes: Morangos, vodka, açúcar, limão, gelo.\n" +
                "2. Preparo: Corte os morangos em pedaços e coloque em um copo. Adicione açúcar e macere levemente. Acrescente vodka, suco de limão e gelo. Mexa bem e sirva.";
//8
    }

    public static String hotToddy() {
        return "Hot Toddy:\n" +
                "1. Ingredientes: Whisky, mel, suco de limão, água quente, cravo-da-índia, canela em pau.\n" +
                "2. Preparo: Em uma caneca, misture whisky, mel, suco de limão, cravo-da-índia e canela em pau. Complete com água quente e mexa bem. Sirva quente.";
//9
    }

    public static String mimosa() {
        return "Mimosa:\n" +
                "1. Ingredientes: Champagne (ou espumante brut), suco de laranja.\n" +
                "2. Preparo: Em uma taça de champagne, despeje champagne gelado até a metade. Complete com suco de laranja gelado. Mexa suavemente e sirva.";
//10
    }

    public static String amarettoSour() {
        return "Amaretto Sour:\n" +
                "1. Ingredientes: Amaretto, suco de limão, açúcar, clara de ovo, cereja para decorar, gelo.\n" +
                "2. Preparo: Em um shaker, misture amaretto, suco de limão, açúcar, clara de ovo e gelo. Agite bem. Coe para um copo baixo com gelo e decore com uma cereja.";
//11
    }

    public static String daiquiri() {
        return "Daiquiri:\n" +
                "1. Ingredientes: Rum branco, suco de limão, açúcar, gelo.\n" +
                "2. Preparo: Em um shaker, misture rum branco, suco de limão, açúcar e gelo. Agite bem e coe para uma taça de coquetel previamente gelada.";
//12
    }

    public static String caféIrlandes() {
        return "Café Irlandês:\n" +
                "1. Ingredientes: Café quente, whisky, chantilly, açúcar a gosto.\n" +
                "2. Preparo: Prepare um café quente e adicione whisky a gosto. Mexa bem e finalize com chantilly por cima. Sirva quente.";
//13
    }

    public static String moscowMule() {
        return "Moscow Mule:\n" +
                "1. Ingredientes: Vodka, suco de limão, ginger beer, gelo, fatia de limão para decorar.\n" +
                "2. Preparo: Em um copo alto com gelo, misture vodka e suco de limão. Complete com ginger beer. Mexa suavemente e decore com uma fatia de limão.";
//14
    }

    public static String punchFrutas() {
        return "Punch de Frutas:\n" +
                "1. Ingredientes: Rum branco, suco de laranja, suco de limão, suco de abacaxi, soda limonada, frutas frescas (como laranja, limão, abacaxi), gelo.\n" +
                "2. Preparo: Em uma jarra grande, misture rum branco, suco de laranja, suco de limão, suco de abacaxi e soda limonada. Adicione frutas cortadas em pedaços e gelo. Mexa bem e sirva.";
//15
    }

    public static String bellini() {
        return "Bellini:\n" +
                "1. Ingredientes: Purê de pêssego, prosecco (ou champagne).\n" +
                "2. Preparo: Em uma taça de champagne, coloque uma colher de sopa de purê de pêssego. Complete com prosecco bem gelado. Mexa delicadamente e sirva.";
//16
    }

    public static String piñaColadaSemAlcool() {
        return "Piña Colada Sem Álcool:\n" +
                "1. Ingredientes: Leite de coco, suco de abacaxi, açúcar, abacaxi em pedaços, gelo.\n" +
                "2. Preparo: Em um liquidificador, bata leite de coco, suco de abacaxi, açúcar e gelo até obter uma mistura homogênea. Sirva em um copo decorado com um pedaço de abacaxi.";
//17
    }

    public static String caipirinhaMorango() {
        return "Caipirinha de Morango:\n" +
                "1. Ingredientes: Morangos, açúcar, cachaça, limão, gelo.\n" +
                "2. Preparo: Corte os morangos em pedaços e coloque em um copo. Adicione açúcar e macere levemente. Acrescente cachaça, suco de limão e gelo. Mexa bem e sirva.";
//18
    }

    public static String mojitoMorango() {
        return "Mojito de Morango:\n" +
                "1. Ingredientes: Morangos, hortelã fresca, limão, açúcar, rum branco, água com gás, gelo.\n" +
                "2. Preparo: Em um copo, macere morangos, folhas de hortelã, limão cortado em pedaços e açúcar. Adicione rum branco e gelo. Complete com água com gás, mexa suavemente e decore com uma fatia de limão.";
//19
    }

    public static String bloodyMary() {
        return "Bloody Mary:\n" +
                "1. Ingredientes: Vodka, suco de tomate, suco de limão, molho inglês, molho de pimenta, sal, pimenta-do-reino, aipo (opcional), gelo.\n" +
                "2. Preparo: Em um copo alto com gelo, misture vodka, suco de tomate, suco de limão, molho inglês, molho de pimenta, sal e pimenta-do-reino a gosto. Mexa bem. Decore com um talo de aipo e uma rodela de limão, se desejar.";
//20
    }
}
