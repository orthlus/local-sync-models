package art.aelaort.models.servers.k8s;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class K8sService {
	@JsonProperty
	private String name;
	@JsonProperty
	private String namespace;
	@JsonProperty
	private String kind;
	@JsonProperty
	private String type;
	@JsonProperty
	private String appSelector;
	@JsonProperty
	private Integer port;
	@JsonProperty
	private String targetPort;
	@JsonProperty
	private Integer nodePort;
	@JsonProperty
	private Boolean hasAnotherPorts;
	@With
	@JsonProperty
	private String route;
}
