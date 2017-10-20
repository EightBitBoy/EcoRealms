package de.eightbitboy.ecorealms.entity;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;

public class EntityEngine {
	private Engine engine;

	public EntityEngine() {
		engine = new Engine();
		addExampleEntity();
	}

	public void update(float deltaTime) {
		engine.update(deltaTime);
	}

	private void addExampleEntity() {
		ExampleEntity entity = new ExampleEntity();
		entity.add(new PositionComponent());
		entity.add(new ModelComponent());
		engine.addEntity(entity);
	}

	private class ExampleEntity extends Entity {

	}
}
