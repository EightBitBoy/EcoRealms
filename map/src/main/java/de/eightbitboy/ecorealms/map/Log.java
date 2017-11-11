package de.eightbitboy.ecorealms.map;

import org.slf4j.Logger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//FIXME This is experimental!
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Log {
	Logger logger = null;
}
