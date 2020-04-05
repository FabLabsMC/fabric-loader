package net.fabricmc.loader.modprovider;

import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.fabricmc.loader.api.modprovider.InvalidModException;
import net.fabricmc.loader.api.modprovider.ModSubmitter;
import net.fabricmc.loader.api.modprovider.ProvidedModContainer;
import net.fabricmc.loader.builder.ModMetadataBuilderImpl;
import net.fabricmc.loader.discovery.ModCandidateSet;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ModSubmitterImpl implements ModSubmitter {
	private net.fabricmc.loader.FabricLoader loader;
	private ModContainer provider;
	private List<ProvidedModContainer> providedMods;

	public ModSubmitterImpl(net.fabricmc.loader.FabricLoader loader, ModContainer provider) {
		this.loader = loader;
		this.provider = provider;
	}

	@Override
	public ModContainer getEntrypointProvider() {
		return this.provider;
	}

	@Override
	public ProvidedModContainer submit(ModMetadata.Builder metadataBuilder) throws InvalidModException {
		if (this.loader.isFrozen()) {
			throw new RuntimeException(); // TODO: cannot register mods when frozen
		}

		if (metadataBuilder instanceof ModMetadataBuilderImpl) {
			final ModMetadata metadata = ((ModMetadataBuilderImpl) metadataBuilder).build();

			final Optional<String> existingId = this.loader.getModContainer(metadata.getId())
					.map(ModContainer::getMetadata)
					.map(ModMetadata::getId);

			if (existingId.isPresent()) {
				throw new InvalidModException(); // TODO: Duplicate ModId
			}

			final ProvidedModContainerImpl provided = new ProvidedModContainerImpl(this.provider, metadata, null);
			this.providedMods.add(provided);

			return provided;
		}

		throw new InvalidModException(); // TODO: Builder failure since a foreign builder was used.
	}

	public Collection<ProvidedModContainer> getProvidedMods() {
		return this.providedMods;
	}
}
