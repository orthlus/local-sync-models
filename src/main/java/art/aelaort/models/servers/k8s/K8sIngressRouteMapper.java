package art.aelaort.models.servers.k8s;

import art.aelaort.models.servers.k8s.input.IngressRouteSpec;
import art.aelaort.models.servers.k8s.input.Route;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;

public class K8sIngressRouteMapper {
	public static K8sIngressRoute map(IngressRouteSpec ingressRouteSpec, GenericKubernetesResource genericKubernetesResource) {
		Route route = ingressRouteSpec.getRoutes().get(0);
		return K8sIngressRoute.builder()
				.name(genericKubernetesResource.getMetadata().getName())
				.namespace(genericKubernetesResource.getMetadata().getNamespace())
				.hasTls(ingressRouteSpec.getTls() != null)
				.match(route.getMatch())
				.serviceName(route.getServices().get(0).getName())
				.servicePort(route.getServices().get(0).getPort())
				.build();
	}
}
