package net.fabricmc.loader.modprovider;

import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.fabricmc.loader.api.modprovider.ProvidedModContainer;

import java.nio.file.Path;

public class ProvidedModContainerImpl implements ProvidedModContainer {
	private ModContainer provider;
	private ModMetadata metadata;
	private Path path;

	public ProvidedModContainerImpl(ModContainer provider, ModMetadata metadata, Path path) {
		this.provider = provider;
		this.metadata = metadata;
		this.path = path;
	}

	@Override
	public ModContainer getProvider() {
		return this.provider;
	}

	@Override
	public ModMetadata getMetadata() {
		return this.metadata;
	}

	@Override
	public Path getRootPath() {
		return this.path;
	}
}
