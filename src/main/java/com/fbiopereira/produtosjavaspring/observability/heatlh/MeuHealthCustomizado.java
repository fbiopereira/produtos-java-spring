package com.fbiopereira.produtosjavaspring.observability.heatlh;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
public class MeuHealthCustomizado extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        builder.up()
                .withDetail("servico", "Estou vivo!");

        builder.down().withDetail("outroServico", "morri");
    }
}
