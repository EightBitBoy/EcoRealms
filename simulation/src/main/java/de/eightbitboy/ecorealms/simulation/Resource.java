package de.eightbitboy.ecorealms.simulation;

public enum Resource {
	Fish(100),
	Stone(200),
	Wood(150);

	public float productionRate;

	Resource(float productionRate) {
		this.productionRate = productionRate;
	}
}
