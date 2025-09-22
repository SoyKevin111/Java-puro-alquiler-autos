package repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

abstract class AbstractRepository<T> {

	protected Map<Long, T> storage = new HashMap<>();

	public T guardar(T entity) {
		return entity;
	}

	public Set<T> todos() {
		return new HashSet<>(storage.values());
	}

	public Optional<T> porId(long id) {
		return Optional.ofNullable(storage.get(id));
	}

	public void eliminar(long id) {
		storage.remove(id);
	}

}
