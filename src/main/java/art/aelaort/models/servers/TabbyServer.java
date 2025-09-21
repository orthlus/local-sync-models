package art.aelaort.models.servers;

import art.aelaort.models.servers.ssh.SshServer;

public record TabbyServer(String name, String host, String keyPath, int port) implements SshServer {
}
