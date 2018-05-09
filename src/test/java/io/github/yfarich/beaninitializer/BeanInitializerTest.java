package io.github.yfarich.beaninitializer;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import io.github.yfarich.BeanInitializer;
import io.github.yfarich.beaninitializer.beans.City;
import io.github.yfarich.beaninitializer.beans.Country;

public class BeanInitializerTest {

	@Test
	public void createNewTest() {
		City grenoble = BeanInitializer.createNew(City.class).withAllSubProperties();

		Assertions.assertThat(grenoble).isNotNull();
		Assertions.assertThat(grenoble.getCityName()).isNotNull();
		Assertions.assertThat(grenoble.getPhonePrefix()).isNotNull();
	}

	@Test
	public void withAllSubPropertiesTest() {
		Country france = new Country();

		france = BeanInitializer.initialize(france).withAllSubProperties();

		Assertions.assertThat(france.getName()).isNotNull();
		Assertions.assertThat(france.getCapitaCity()).isNotNull();
		Assertions.assertThat(france.getPopulation()).isNotNull();
		Assertions.assertThat(france.getCapitaCity().getCityName()).isNotNull();
		Assertions.assertThat(france.getCapitaCity().getPhonePrefix()).isNotNull();
		Assertions.assertThat(france.getCapitaCity().getCityZipCodes()).isNotNull();
	}

	@Test
	public void withOnlySubPropertiesWithClassNameTest() {
		Country france = BeanInitializer.createNew(Country.class)
				.withOnlySubPropertiesWithClassName(Arrays.asList("City", "Coutry"));
		Assertions.assertThat(france.getName()).isNull();
		Assertions.assertThat(france.getCapitaCity()).isNotNull();
		Assertions.assertThat(france.getCapitaCity().getCityName()).isNull();
	}

	// @Test
	// public void withOnlySubPropertiesInPackagesTest(List<String> packages) {
	//
	// }
	//
	// @Test
	// public void withOnlySubPropertiesWithClassNameTest(List<String> packages) {
	//
	// }
	//
	// @Test
	// public void withOnlySubPropertiesAccordingToPredicatesTest(List<String>
	// packages) {
	//
	// }

}