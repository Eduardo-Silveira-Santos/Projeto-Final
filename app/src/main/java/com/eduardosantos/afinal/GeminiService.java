package com.eduardosantos.afinal;

import com.google.ai.client.generativeai.GenerativeModel;
import com.google.ai.client.generativeai.java.GenerativeModelFutures;
import com.google.ai.client.generativeai.type.BlockThreshold;
import com.google.ai.client.generativeai.type.Content;
import com.google.ai.client.generativeai.type.GenerateContentResponse;
import com.google.ai.client.generativeai.type.GenerationConfig;
import com.google.ai.client.generativeai.type.HarmCategory;
import com.google.ai.client.generativeai.type.SafetySetting;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class GeminiService {
    public ListenableFuture<GenerateContentResponse> getResponse(String prompt) {
        prompt = "Descreva um passo a passo simplificado sem linhas vazias, " +
                "espeaçamentos inutis, responda a agradecimentos, sem listas e com um máximo de 50 caractéries de como:" + prompt;
        GenerativeModelFutures model = GenerativeModelFutures.from(getModel());
        Content content = new Content.Builder()
                .addText(prompt)
                .build();
        Executor executor = Executors.newSingleThreadExecutor();
        ListenableFuture<GenerateContentResponse> response = model.generateContent(content);
        Futures.addCallback(response, new FutureCallback<GenerateContentResponse>() {
            @Override
            public void onSuccess(GenerateContentResponse result) {
                // Lógica para lidar com o texto gerado com sucesso
                String resultText = result.getText();
                System.out.println("Texto gerado: " + resultText);

            }
            @Override
            public void onFailure(Throwable t) {
                // Lógica para lidar com falha na geração de conteúdo
                t.printStackTrace();
            }
        }, executor);
        return response; // Retornando o ListenableFuture para quem chamar este método poder esperar pela resposta
    }

    public GenerativeModel getModel(){
        GenerationConfig.Builder configBuilder = new GenerationConfig.Builder();
        configBuilder.temperature = 0.15f;
        configBuilder.topK = 32;
        configBuilder.topP = 1f;
        configBuilder.maxOutputTokens = 4096;

        ArrayList<SafetySetting> safetySettings = new ArrayList();
        safetySettings.add(new SafetySetting( HarmCategory.HARASSMENT, BlockThreshold.MEDIUM_AND_ABOVE));
        safetySettings.add(new SafetySetting(HarmCategory.HATE_SPEECH, BlockThreshold.MEDIUM_AND_ABOVE));
        safetySettings.add(new SafetySetting(HarmCategory.SEXUALLY_EXPLICIT, BlockThreshold.MEDIUM_AND_ABOVE));
        safetySettings.add(new SafetySetting(HarmCategory.DANGEROUS_CONTENT, BlockThreshold.MEDIUM_AND_ABOVE));

        GenerativeModel gm = new GenerativeModel(
                "gemini-1.5-flash-001",
                "AIzaSyB4JkEW52jLk5AaA2sSvp3xhdHFPbZs-c8",
                configBuilder.build(),
                safetySettings
        );
        return gm;
    }
}
