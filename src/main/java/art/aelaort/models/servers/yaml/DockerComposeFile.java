package art.aelaort.models.servers.yaml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DockerComposeFile {
	Map<String, Service> services;

	@Getter
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Service {
		@JsonProperty("container_name")
		String containerName;
		@JsonProperty
		String image;
		@JsonProperty
		String restart;
	}
}
