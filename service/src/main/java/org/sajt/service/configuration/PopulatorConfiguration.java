package org.sajt.service.configuration;

import org.sajt.service.util.ChainBuilder;
import org.sajt.service.worldpopulator.WorldPopulator;
import org.sajt.service.worldpopulator.impl.PlanetWorldPopulator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PopulatorConfiguration {

    @Bean
    public WorldPopulator worldPopulatorChain() {
        ChainBuilder<WorldPopulator> chainBuilder = new ChainBuilder<>();
        return chainBuilder.withNext(new PlanetWorldPopulator())
                .build().get();
    }
}
