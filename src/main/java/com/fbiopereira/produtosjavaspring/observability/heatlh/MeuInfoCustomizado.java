package com.fbiopereira.produtosjavaspring.observability.heatlh;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class MeuInfoCustomizado implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        HashMap<String,String> info = new HashMap<>();
        info.put("usuarios online", "10");
        info.put("usuarios inativos", "2");
        builder.withDetail("info-no-codigo", info);
    }
}
