package net.fabricmc.loader.api.entrypoint;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.modprovider.ModSubmitter;

/**
 * An entrypoint which can be used to provide additional mods to be loaded.
 *
 * <p><b>Avoid interfering with the game from this!</b> Accessing anything needs careful consideration to avoid
 *  * interfering with its own initialization or otherwise harming its state. It is recommended to implement this interface
 *  * on its own class to avoid running static initializers too early, e.g. because they were referenced in field or method
 *  * signatures in the same class.
 */
public interface ModProviderEntrypoint {
	/**
	 * Called to provide additional mods to be loaded.
	 *
	 * @param fabricLoader The instance of fabric loader.
	 * @param submitter The mod submitter used to submit mods to be loaded.
	 */
	void provideMods(FabricLoader fabricLoader, ModSubmitter submitter);
}
