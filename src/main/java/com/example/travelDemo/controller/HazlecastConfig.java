package com.example.travelDemo.controller;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazlecastConfig {

	@Bean
	Config myConfig(){
		return new Config()
				.setInstanceName("haz-cast-instance")
				.addMapConfig(
						new MapConfig()
						.setName("customers")
						.setEvictionPolicy(EvictionPolicy.LRU)
						.setMaxSizeConfig(new MaxSizeConfig(100, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
						.setTimeToLiveSeconds(3600)
				);
	}

}
