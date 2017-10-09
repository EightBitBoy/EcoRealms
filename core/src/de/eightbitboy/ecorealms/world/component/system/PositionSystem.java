package de.eightbitboy.ecorealms.world.component.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.utils.ImmutableArray;

import de.eightbitboy.ecorealms.world.component.PositionComponent;

public class PositionSystem extends EntitySystem {
	private ImmutableArray<Entity> entities;

	private ComponentMapper<PositionComponent> positionMapper = ComponentMapper.getFor(PositionComponent.class);
}
