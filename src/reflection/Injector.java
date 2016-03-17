package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Injector {

    private final Map<Class<?>, Object> _objectGraph = new HashMap<>();

    public Injector with(final Object value) {
	_objectGraph.put(value.getClass(), value);
	return this;
    }

    public <T> T newInstance(final Class<T> type) {
	if (_objectGraph.containsKey(type)) {
	    return (T) _objectGraph.get(type);
	} else {
	    instantiate(type);
	}
	return (T) _objectGraph.computeIfAbsent(type, this::instantiate);
    }

    private Object instantiate(Class<?> type) {
	try {
	    Constructor<?>[] constructors = type.getConstructors();
	    if (constructors.length != 1) {
		throw new IllegalArgumentException(type + " must only have 1 constructor");
	    }

	    Constructor<?> constructor = constructors[0];
	    Object[] args = Stream.of(constructor.getParameterTypes())
		    .map(param -> (Object) newInstance(param))
		    .toArray();

	    return constructor.newInstance(args);
	} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
	    throw new RuntimeException(e);
	}
    }
}
