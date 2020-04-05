package net.fabricmc.loader.metadata;

import java.util.Collection;
import java.util.Optional;

import net.fabricmc.loader.api.Version;
import net.fabricmc.loader.api.metadata.ContactInformation;
import net.fabricmc.loader.api.metadata.CustomValue;
import net.fabricmc.loader.api.metadata.ModDependency;
import net.fabricmc.loader.api.metadata.Person;

public class ProvidedModMetadata extends AbstractModMetadata {
	private final String type;
	private final String id;
	private final Version version;
	private final Collection<ModDependency> depends;
	private final Collection<ModDependency> recommends;
	private final Collection<ModDependency> suggests;
	private final Collection<ModDependency> conflicts;
	private final Collection<ModDependency> breaks;
	private final String name;
	private final String description;
	private final Collection<Person> authors;
	private final Collection<Person> contributors;
	private final ContactInformation contact;
	private final Collection<String> license;
	/*Nullable*/
	private final String iconPath;

	public ProvidedModMetadata(String type, String id, Version version, Collection<ModDependency> depends, Collection<ModDependency> recommends,
		Collection<ModDependency> suggests, Collection<ModDependency> conflicts, Collection<ModDependency> breaks, String name, String description,
		Collection<Person> authors, Collection<Person> contributors, ContactInformation contact, Collection<String> license, /* Nullable */String iconPath) {
		this.type = type;
		this.id = id;
		this.version = version;
		this.depends = depends;
		this.recommends = recommends;
		this.suggests = suggests;
		this.conflicts = conflicts;
		this.breaks = breaks;
		this.name = name;
		this.description = description;
		this.authors = authors;
		this.contributors = contributors;
		this.contact = contact;
		this.license = license;
		this.iconPath = iconPath;
	}

	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public Version getVersion() {
		return this.version;
	}

	@Override
	public Collection<ModDependency> getDepends() {
		return this.depends;
	}

	@Override
	public Collection<ModDependency> getRecommends() {
		return this.recommends;
	}

	@Override
	public Collection<ModDependency> getSuggests() {
		return this.suggests;
	}

	@Override
	public Collection<ModDependency> getConflicts() {
		return this.conflicts;
	}

	@Override
	public Collection<ModDependency> getBreaks() {
		return this.breaks;
	}

	@Override
	public String getName() {
		return this.name != null ? this.name : this.id;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public Collection<Person> getAuthors() {
		return this.authors;
	}

	@Override
	public Collection<Person> getContributors() {
		return this.contributors;
	}

	@Override
	public ContactInformation getContact() {
		return this.contact;
	}

	@Override
	public Collection<String> getLicense() {
		return this.license;
	}

	@Override
	public Optional<String> getIconPath(int size) {
		return Optional.ofNullable(this.iconPath);
	}

	@Override
	public boolean containsCustomValue(String key) {
		return false;
	}

	@Override
	public CustomValue getCustomValue(String key) {
		// TODO: CustomValue handling at a later date
		return CustomValueImpl.NULL;
	}
}
