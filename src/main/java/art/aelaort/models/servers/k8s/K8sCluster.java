package art.aelaort.models.servers.k8s;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.With;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Builder(toBuilder = true)
@Getter
@Accessors(fluent = true)
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class K8sCluster {
	@JsonProperty
	@With
	private String name;
	@JsonProperty
	private List<K8sApp> apps;
	@JsonProperty
	private List<K8sService> services;
	@JsonProperty
	private List<String> nodes;
	@JsonProperty
	private List<K8sHelmChart> helmCharts;
	@JsonProperty
	private List<K8sIngressRoute> ingressRoutes;
}
