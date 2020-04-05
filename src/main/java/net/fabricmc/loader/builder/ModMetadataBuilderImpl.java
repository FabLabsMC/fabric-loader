package net.fabricmc.loader.builder;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.fabricmc.loader.api.Version;
import net.fabricmc.loader.api.metadata.ContactInformation;
import net.fabricmc.loader.api.metadata.ModDependency;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.fabricmc.loader.api.metadata.Person;
import net.fabricmc.loader.metadata.ProvidedModMetadata;

public class ModMetadataBuilderImpl implements ModMetadata.Builder {
	// Required Fields
	private String type;
	private String id;
	private Version version;
	// Dependencies
	private List<ModDependency> depends = new ArrayList<>();
	private List<ModDependency> recommends = new ArrayList<>();
	private List<ModDependency> suggests = new ArrayList<>();
	private List<ModDependency> conflicts = new ArrayList<>();
	private List<ModDependency> breaks = new ArrayList<>();
	// Optional fields - metadata
	/*Nullable*/
	private String name;
	private String description = "";
	private List<Person> authors = new ArrayList<>();
	private List<Person> contributors = new ArrayList<>();
	private ContactInformation contact = ContactInformation.EMPTY;
	private List<String> license = new ArrayList<>();
	/*Nullable*/
	private String iconPath;
	
	@Override
	public ModMetadata.Builder type(String type) {
		this.type = requireNonNull(type, "Mod type cannot be null");
		return this;
	}

	@Override
	public ModMetadata.Builder id(String id) {
		this.id = requireNonNull(id, "Mod id cannot be null");
		return this;
	}

	@Override
	public ModMetadata.Builder version(Version version) {
		this.version = requireNonNull(version, "Version cannot be null");
		return this;
	}

	@Override
	public ModMetadata.Builder dependencies(ModDependency... dependencies) {
		for (ModDependency dependency : dependencies) {
			this.depends.add(requireNonNull(dependency, "Mod dependencies cannot contain null values"));
		}

		return this;
	}

	@Override
	public ModMetadata.Builder dependencies(Iterable<ModDependency> dependencies) {
		for (ModDependency dependency : dependencies) {
			this.depends.add(requireNonNull(dependency, "Mod dependencies cannot contain null values"));
		}

		return this;
	}

	@Override
	public ModMetadata.Builder name(String name) {
		this.name = requireNonNull(name, "Mod name cannot be null");
		return this;
	}

	@Override
	public ModMetadata.Builder description(String description) {
		this.description = requireNonNull(description, "Description cannot be null");
		return this;
	}

	@Override
	public ModMetadata.Builder authors(Person... people) {
		for (Person person : people) {
			this.authors.add(requireNonNull(person, "Authors cannot contain a null value"));
		}

		return this;
	}

	@Override
	public ModMetadata.Builder authors(Iterable<Person> people) {
		for (Person person : people) {
			this.authors.add(requireNonNull(person, "Authors cannot contain a null value"));
		}

		return this;
	}

	@Override
	public ModMetadata.Builder contributors(Person... people) {
		for (Person person : people) {
			this.contributors.add(requireNonNull(person, "Contributors cannot contain a null value"));
		}

		return this;
	}

	@Override
	public ModMetadata.Builder contributors(Iterable<Person> people) {
		for (Person person : people) {
			this.contributors.add(requireNonNull(person, "Contributors cannot contain a null value"));
		}

		return this;
	}

	@Override
	public ModMetadata.Builder contact(ContactInformation contactInformation) {
		this.contact = requireNonNull(contactInformation, "Contact information cannot be null");
		return this;
	}

	@Override
	public ModMetadata.Builder licenses(String... licenses) {
		for (String license : licenses) {
			this.license.add(requireNonNull(license, "License entries cannot be null"));
		}

		return this;
	}

	@Override
	public ModMetadata.Builder licenses(Iterable<String> licenses) {
		for (String license : licenses) {
			this.license.add(requireNonNull(license, "License entries cannot be null"));
		}

		return this;
	}

	@Override
	public ModMetadata.Builder iconPath(String path) {
		this.iconPath = requireNonNull(path, "Icon path cannot be null");
		return this;
	}

	@Override
	public ModMetadata.Builder entrypoint(String key, String path) {
		// TODO: Implement?
		return this;
	}

	@Override
	public ModMetadata.Builder mixinConfigs(String... paths) {
		// TODO: Implement?
		return this;
	}

	@Override
	public ModMetadata.Builder mixinConfigs(Iterable<String> paths) {
		// TODO: Implement?
		return this;
	}

	public ProvidedModMetadata build() {
		return new ProvidedModMetadata(
				// Required
				requireNonNull(this.type, "The type cannot be null"),
				requireNonNull(this.id, "The mod's id cannot be null"),
				requireNonNull(this.version, "The mod's version cannot be null"),
				// Dependencies
				Collections.unmodifiableCollection(this.depends),
				Collections.unmodifiableCollection(this.recommends),
				Collections.unmodifiableCollection(this.suggests),
				Collections.unmodifiableCollection(this.conflicts),
				Collections.unmodifiableCollection(this.breaks),
				// Metadata
				this.name,
				this.description,
				Collections.unmodifiableCollection(this.authors),
				Collections.unmodifiableCollection(this.contributors),
				this.contact,
				Collections.unmodifiableCollection(this.license),
				this.iconPath
		);
	}
}
