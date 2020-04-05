package net.fabricmc.loader.api.modprovider;

import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.ModMetadata;

public interface ModSubmitter {
	ModContainer getEntrypointProvider();

	ProvidedModContainer submit(ModMetadata.Builder metadataBuilder) throws InvalidModException;
}
