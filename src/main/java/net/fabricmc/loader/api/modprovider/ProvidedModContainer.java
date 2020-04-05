package net.fabricmc.loader.api.modprovider;

import net.fabricmc.loader.api.ModContainer;

public interface ProvidedModContainer extends ModContainer {
	/**
	 * Gets the mod which has provided this mod.
	 *
	 * @return the providing mod.
	 */
	ModContainer getProvider();
}
