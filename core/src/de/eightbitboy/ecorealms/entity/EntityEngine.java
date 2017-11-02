package de.eightbitboy.ecorealms.entity;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;

public class EntityEngine {
	private Engine engine;

	public EntityEngine() {
		engine = new Engine();
		addExampleEntity();


		Family positionFamily = Family.all(PositionComponent.class).get();
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
