package com.chaos.crypto.ewbf.watchdog.service;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class MinerStatsDto {

    private static final Logger LOGGER = LoggerFactory.getLogger(MinerStatsDto.class);

    private String method;
    private String error;

    @JsonProperty("start_time")
    private Long startTime;

    @JsonProperty("current_server")
    private String currentServer;

    @JsonProperty("available_servers")
    private Integer availableServers;

    @JsonProperty("server_status")
    private Integer serverStatus;

    private List<GpuStats> result;

    @JsonIgnore
    private Map<String, JsonNode> unknownProperties = new HashMap<>();

    @JsonAnyGetter
    public Map<String, JsonNode> getUnknownProperties() {
        return unknownProperties;
    }

    @JsonAnySetter
    public void setUnknownProperty(String name, JsonNode value) {
        LOGGER.warn("Unknown property `{}` with value `{}`", name, value);
        unknownProperties.put(name, value);
    }

    @Getter
    @Setter
    @ToString
    public static class GpuStats {
        @JsonProperty("gpuid")
        private Integer gpuId;

        @JsonProperty("cudaid")
        private Integer cudaId;

        @JsonProperty("busid")
        private String busId;

        private String name;

        @JsonProperty("gpu_status")
        private Integer gpuStatus;

        private Integer solver;

        private Integer temperature;

        @JsonProperty("gpu_power_usage")
        private Integer gpuPowerUsage;

        @JsonProperty("speed_sps")
        private Integer speedSps;

        @JsonProperty("accepted_shares")
        private Integer acceptedShares;

        @JsonProperty("rejected_shares")
        private Integer rejectedShares;

        @JsonProperty("start_time")
        private Long startTime;

        @JsonIgnore
        private Map<String, JsonNode> unknownProperties = new HashMap<>();

        @JsonAnyGetter
        public Map<String, JsonNode> getUnknownProperties() {
            return unknownProperties;
        }

        @JsonAnySetter
        public void setUnknownProperty(String name, JsonNode value) {
            LOGGER.warn("Unknown property `{}` with value `{}`", name, value);
            unknownProperties.put(name, value);
        }
    }
}
